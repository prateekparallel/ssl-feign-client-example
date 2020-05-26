package com.bhaiti.uk.global.repo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
//@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = { "com.bhaiti" })
public class GlobalrepositoryApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(GlobalrepositoryApplication.class, args);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 /**
		   * This section defines the user accounts which can be used for
		   * authentication as well as the roles each user has.
		   */
		auth.inMemoryAuthentication().withUser("bhaiti").password("{noop}test1234").roles("USER").and().withUser("babatu")
				.password("{noop}test1234").roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// http.requiresChannel().anyRequest().requiresSecure();
		// http
		// .httpBasic().and()
		// .authorizeRequests()
		// .antMatchers(HttpMethod.POST, "/globalrepository/register").hasRole("ADMIN");

		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/globalrepository/register").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/globalrepository/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PATCH, "/globalrepository/**").hasRole("ADMIN").and()
			      .csrf().disable();
		
		  //http .httpBasic().and().authorizeRequests()
		  //.antMatchers("/globalrepository/register" , "/globalrepository/register/**")
		  //.antMatchers("/globalrepository" ,  "/globalrepository/**") 
		  //.permitAll().anyRequest().authenticated()
		  //.and().csrf().disable();
		
	}
	
	//alternate to above configuration
	
	/*
	 @Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password("password").roles("USER").build());
        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
        return manager;

    }
	 */

}
