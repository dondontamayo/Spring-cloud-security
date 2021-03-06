package com.project.springsecureservice;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class SpringCloudSecureServiceAuthserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecureServiceAuthserverApplication.class, args);
	}
	
	@GetMapping("/user")
	public Principal userInfo(Principal user) {
		return user;
	}
}
