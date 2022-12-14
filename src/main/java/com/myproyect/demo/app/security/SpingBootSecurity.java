package com.myproyect.demo.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpingBootSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(getEnecoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/usuario/*","/index/*", "/OlvidoContrasena/*", "/css/*","/js/*","/assets/*", "/img/*","/bootstrap5-website-master/*","/bootstrap-4.6.0-dist/*","/bootstrap-5.0.2-dist/*",  "/Reports/*")
	    .permitAll()
	    .antMatchers("/dashboard-Admin","/Seguimiento/Administrador/**","/Inventarios/Administrador/**","/Asistencia/Administrador/**").hasRole("ADMINISTRADOR")
		.antMatchers("/dashboard-Empleado","/Seguimiento/Empleado/**","/Inventarios/Empleado/*","/Asistencia/Empleado/**").hasRole("EMPLEADO")
		.antMatchers("/dashboard-Jefe","/Seguimiento/JefeArea/**","/Asistencia/JefeArea/**").hasRole("JEFE DE AREA")
		.antMatchers("/dashboard-Agente","/Asistencia/Agentes/**").hasRole("AGENTE TECNICO")
		
		.and().formLogin().loginPage("/login")
		.permitAll().defaultSuccessUrl("/acceder");
	}
	
	@Bean
	public BCryptPasswordEncoder getEnecoder() {
		return new BCryptPasswordEncoder();
	}
	

}
