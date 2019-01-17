package com.nareshit;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class HospitalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalServiceApplication.class, args);
	}
	@Bean
	public HibernateJpaSessionFactoryBean sessionfactory() {
		return new HibernateJpaSessionFactoryBean();
	}
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}
