package com.example.session.dbauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

import com.example.session.dbauth.repository.UsersRepository;
import com.example.session.dbauth.service.CustomUserDetailsService;

@EnableJpaRepositories(basePackageClasses = UsersRepository.class)
@Configuration
@EnableWebSecurity
public class SessionSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getBcryotPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// https://www.baeldung.com/spring-security-session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		http.csrf().disable().authorizeRequests() //
				.antMatchers("/ua/*").permitAll() //
				.antMatchers("/auth/*").authenticated() //
				.and().requestCache() //
				.requestCache(new NullRequestCache()) //
				.and().httpBasic().disable().formLogin().disable();
	}

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}

			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return true;
			}
		};
	}

	@Bean
	public BCryptPasswordEncoder getBcryotPasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
