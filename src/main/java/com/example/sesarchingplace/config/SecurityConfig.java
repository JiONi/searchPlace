package com.example.sesarchingplace.config;

import com.example.sesarchingplace.component.AuthComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    AuthComponent authComponent;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**, *.ico");		// Resources 파일이나 Javascript 파일 경로 무시
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //csrf기능을 사용하지않겠다.

        http.authorizeRequests()
                .antMatchers("/login", "/join/**","/static/**").permitAll()
                .antMatchers("/**").authenticated();

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/search/page")
                .usernameParameter("userId")
                .passwordParameter("password");

        http.authenticationProvider(authComponent);

    }
}
