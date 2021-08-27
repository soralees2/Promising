package com.promising.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// remember-me 기억하는 db
//	create table persistent_logins (
//			username varchar(64) not null,
//			series varchar(64) primary key,
//			token varchar(64) not null,
//			last_used timestamp not null);
	@Autowired
	private DataSource dataSource;
	@Autowired
	 private MemberDetailService mservice;
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().antMatchers("/css/**", "/script/**", "image/**", "/fonts/**", "lib/**");
	}
	


	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		
		http.authorizeRequests()
		.antMatchers("/project/auth/**").hasRole("BASIC")
		.antMatchers("/member/auth/**").hasRole("BASIC")
		.anyRequest().permitAll()
		.and()
        .formLogin() // 7
           .loginPage("/member/login") // 로그인 페이지 링크
        
           .defaultSuccessUrl("/") // 로그인 성공 후 리다이렉트 주소
           .failureUrl("/member/login")
       .and()
         .logout().logoutUrl("/logout") // 8
           .logoutSuccessUrl("/member/login") // 로그아웃 성공시 리다이렉트 주소
	    .invalidateHttpSession(true); // 세션 날리기
			
		http.userDetailsService(mservice);
			//.antMatchers("/**").permitAll();
		http.rememberMe().key("promising")
		.userDetailsService(mservice)
		.tokenRepository(getJDBCRepository())
		.tokenValiditySeconds(60*60*24);
		
		 http.sessionManagement()
         .maximumSessions(1)
         .maxSessionsPreventsLogin(false)
         .expiredUrl("/member/login")
         .sessionRegistry(sessionRegistry());
		
	}
	private PersistentTokenRepository getJDBCRepository() {
		JdbcTokenRepositoryImpl repo= new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(mservice).passwordEncoder(passwordEncoder());
	}
	
	
//	  @Override
//	  public void configure(AuthenticationManagerBuilder auth) throws Exception { // 9
//	    auth.userDetailsService(userService)
//	    	// 해당 서비스(userService)에서는 UserDetailsService를 implements해서 
//	        // loadUserByUsername() 구현해야함 (서비스 참고)
//	    	.passwordEncoder(new BCryptPasswordEncoder()); 
//	   }
}
