package kok.spring21.config;

import kok.spring21.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("kok.spring21")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthProvider ap;

    @Override
    public void configure(AuthenticationManagerBuilder a) throws Exception{
        System.out.println(">>>SC-c()");
        a.authenticationProvider(ap);
    }


    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()

                .antMatchers("/admin/**").authenticated() //.hasRole("ADMIN")
                .antMatchers("/admin/1").permitAll()
                .antMatchers("/admin/2").hasRole("ADMIN")
                .antMatchers("/login/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers( "/favicon.ico").permitAll()
                //.antMatchers("/**").authenticated()//hasAnyRole()
                .and()
                .formLogin();//.successHandler(new myAuthenticationSuccessHandler())
        ;
        ///return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}

