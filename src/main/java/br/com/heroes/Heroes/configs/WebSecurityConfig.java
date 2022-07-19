package br.com.heroes.Heroes.configs;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.AllArgsConstructor;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@AllArgsConstructor

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()

				.authorizeRequests().antMatchers("/heroes/**").permitAll().antMatchers("/heroes/**").permitAll()
				.antMatchers("/heroes/**").permitAll();

	}

}
