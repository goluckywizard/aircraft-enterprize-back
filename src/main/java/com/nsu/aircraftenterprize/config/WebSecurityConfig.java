package com.nsu.aircraftenterprize.config;

import com.nsu.aircraftenterprize.security.JwtConfigurer;
import com.nsu.aircraftenterprize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    private final JwtConfigurer jwtConfigurer;
    public WebSecurityConfig(JwtConfigurer jwtConfigurer) {
        this.jwtConfigurer = jwtConfigurer;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity = httpSecurity.cors().and().csrf().disable();
        httpSecurity = httpSecurity.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();
        httpSecurity = httpSecurity
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                )
                .and();
        httpSecurity
                //.csrf().disable()
                //.cors().and()

                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/manufacture").hasRole("USER")
                .antMatchers("/department").permitAll()
                //.antMatchers("/department").hasAnyRole()
                .antMatchers("/employee-category").permitAll()
                .antMatchers("/employee-attribute").permitAll()
                .antMatchers("/employee-attribute/{category_id}").permitAll()
                .antMatchers("/product-category").permitAll()
                .antMatchers("/product-attribute").permitAll()
                .antMatchers("/product-attribute/{category_id}").permitAll()
                .antMatchers("/engineer").permitAll()
                .antMatchers("/engineer/{category_id}").permitAll()
                .antMatchers("/product-type").permitAll()
                .antMatchers("/product-type/{category_id}").permitAll()
                .antMatchers("/worker").permitAll()
                .antMatchers("/stage").permitAll()
                .antMatchers("/brigade").permitAll()
                .antMatchers("/product").permitAll()
                .antMatchers("/product/type/{type_id}").permitAll()
                .antMatchers("/product/type/{type_id}/{page}/{count}").permitAll()
                .antMatchers("/product/category/{category_id}").permitAll()
                .antMatchers("/testfield").permitAll()
                .antMatchers("/test-equipment").permitAll()
                .antMatchers("/work").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .apply(jwtConfigurer);

    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}
