package br.com.PomodoroTasks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.PomodoroTasks.service.CustomUserDetailService;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private CustomUserDetailService customDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/tasks").permitAll()
				.anyRequest().authenticated()
				.and()
				.httpBasic()
				.and()
				.csrf().disable();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}