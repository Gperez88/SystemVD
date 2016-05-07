package com.perezmejia.systemvd.config;

import com.perezmejia.systemvd.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Guil on 5/3/2016.
 */

@Configuration
@EnableGlobalMethodSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserDetailsService userDetailsService;

//    @Override
//    public void configure(WebSecurity builder) throws Exception {
//        builder.ignoring()
//                .antMatchers("/static/**", "/templates/**");
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/secured/**").hasAnyRole(new String[]{"USER", "ADMIN"})
                .antMatchers("/secured/inventory/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error")
                .defaultSuccessUrl("/inicio")
                .usernameParameter("username").passwordParameter("password")
                .loginProcessingUrl("/spring_security_login")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .sessionManagement().sessionFixation().migrateSession();

//        .and()
//                .csrf()
    }

}
