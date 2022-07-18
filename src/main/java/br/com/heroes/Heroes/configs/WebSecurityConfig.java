package br.com.heroes.Heroes.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.AllArgsConstructor;

//@SuppressWarnings("deprecation")
//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().authorizeRequests().antMatchers("/**").permitAll();
//	}
//}

@SuppressWarnings("deprecation")
@EnableWebSecurity
@AllArgsConstructor

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
@Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
        
        .authorizeRequests()
        .antMatchers("/heroes/**").permitAll()
        .antMatchers("/heroes/**").permitAll()
        .antMatchers("/heroes/**").permitAll();
        
        
}

}

