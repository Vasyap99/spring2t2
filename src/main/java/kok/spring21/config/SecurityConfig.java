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


import java.io.RandomAccessFile;



@Configuration
@ComponentScan("kok.spring21")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthProvider ap;

    @Override
    public void configure(AuthenticationManagerBuilder a) throws Exception{
        try{
            RandomAccessFile raf = new RandomAccessFile("c:/#/log-spr.txt", "rw");

            raf.seek(raf.length());
            //читаем строку, начиная с текущего положения курсора и до конца строки
            raf.writeBytes(">>0 configure1()");

            //закрываем файл
            raf.close();
        }catch(Exception e){}
        System.out.println(">>>SC-c()");
        ///a.authenticationProvider(ap);
        a.inMemoryAuthentication()
                .withUser("u1")
                   .password("p1")
                   .authorities("ROLE_USER")
                .and()
                .withUser("u2")
                   .password("p2")
                   .authorities("ROLE_USER");
        try{
            RandomAccessFile raf = new RandomAccessFile("c:/#/log-spr.txt", "rw");

            raf.seek(raf.length());
            //читаем строку, начиная с текущего положения курсора и до конца строки
            raf.writeBytes(">>E configure1()");

            //закрываем файл
            raf.close();
        }catch(Exception e){}
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception{
        try{
            RandomAccessFile raf = new RandomAccessFile("c:/#/log-spr.txt", "rw");

            raf.seek(raf.length());
            //читаем строку, начиная с текущего положения курсора и до конца строки
            raf.writeBytes(">>0 configure()");

            //закрываем файл
            raf.close();
        }catch(Exception e){}

        http.authorizeRequests()
        .antMatchers("/people/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .and()
        .formLogin();

        /*http.authorizeRequests()

                .antMatchers("/admin/**").authenticated() //.hasRole("ADMIN")
                .antMatchers("/admin/1").permitAll()
                .antMatchers("/admin/2").hasRole("ADMIN")
                .antMatchers("/login/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers( "/favicon.ico").permitAll()
                .antMatchers("/**").hasRole("ADMIN")//hasAnyRole()
                .antMatchers("/").hasRole("ADMIN")
                .and()
                .formLogin().defaultSuccessUrl("/", true);  //.successHandler(new myAuthenticationSuccessHandler())
        ;*/
        ///return http.build();
		//super.configure(http);//?? from proj

        try{
            RandomAccessFile raf = new RandomAccessFile("c:/#/log-spr.txt", "rw");
            
            raf.seek(raf.length());
            //читаем строку, начиная с текущего положения курсора и до конца строки
            raf.writeBytes(">>E configure()");

            //закрываем файл
            raf.close();
        }catch(Exception e){}
    }


/*
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        try{
            RandomAccessFile raf = new RandomAccessFile("c:/#/log-spr.txt", "rw");

            raf.seek(raf.length());
            //читаем строку, начиная с текущего положения курсора и до конца строки
            raf.writeBytes(">>0 configure()");

            //закрываем файл
            raf.close();
        }catch(Exception e){}

        http.authorizeRequests()

                .antMatchers("/admin/**").authenticated() //.hasRole("ADMIN")
                .antMatchers("/admin/1").permitAll()
                .antMatchers("/admin/2").hasRole("ADMIN")
                .antMatchers("/login/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers( "/favicon.ico").permitAll()
                .antMatchers("/**").hasRole("ADMIN")//hasAnyRole()
                .antMatchers("/").hasRole("ADMIN")
                .and()
                .formLogin();//.successHandler(new myAuthenticationSuccessHandler())
        ;
		//super.configure(http);//?? from proj

        try{
            RandomAccessFile raf = new RandomAccessFile("c:/#/log-spr.txt", "rw");
            
            raf.seek(raf.length());
            //читаем строку, начиная с текущего положения курсора и до конца строки
            raf.writeBytes(">>E configure()");

            //закрываем файл
            raf.close();
        }catch(Exception e){}

        return http.build();
    }
*/


    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }
}

