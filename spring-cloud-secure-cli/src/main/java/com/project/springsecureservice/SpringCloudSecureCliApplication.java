package com.project.springsecureservice;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SpringCloudSecureCliApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecureCliApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("Starting a Cron job");
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header);
		resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");
		resourceDetails.setScope(Arrays.asList("toll_read"));
		
		//client credentials
		resourceDetails.setClientId("dawntamayo");
		resourceDetails.setClientSecret("dawntamayosecret");
		resourceDetails.setUsername("Benedict");
		resourceDetails.setPassword("Benedictpass");

		OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
		System.out.println(template.getAccessToken().toString());
		
		String response = template.getForObject("http://localhost:9001/services/tolldata", String.class);
		System.out.println("Results :" + response);
	}
}
