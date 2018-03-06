package com.project.springsecureservice.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.springsecureservice.data.TollUsage;

@RestController
public class ServiceController {
	

	@GetMapping("/tolldata")
	@PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPERATOR')")
	public List<TollUsage> getTollData() {
		
		ArrayList<TollUsage> tolls = new ArrayList<>();
		
		tolls.add(new TollUsage("100", "station150", "ABC000", "2018-02-26T06:01:01"));
		tolls.add(new TollUsage("101", "station151", "ABC001", "2018-02-27T06:01:01"));
		tolls.add(new TollUsage("102", "station152", "ABC002", "2018-02-28T06:01:01"));
		return tolls;
	}
}
