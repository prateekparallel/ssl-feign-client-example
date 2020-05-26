package com.example.resttemplate.resttemplatedemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller
public class GRController {	 
	
	@Autowired
	GRServiceProvider grServiceProvider;
	
	@GetMapping(path="/globalrepository", produces = "application/json")
	public ResponseEntity<String> getGRGreeting() {
		return grServiceProvider.getGRGreeting("/globalrepository");
	}
	
	@GetMapping("/globalrepository/allforasite")
	ResponseEntity<?> getAllRepsitoryForASite(@RequestHeader HttpHeaders header,@RequestParam(value="siteName",required = false) String siteName){
		return grServiceProvider.getAllRepsitoryForASite(header, siteName);
	}		
	
	@PostMapping(path="/globalrepository/register", value = "/globalrepository/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> register(@RequestHeader HttpHeaders header,@RequestBody GlobalRepository repo)  {
		return grServiceProvider.register(header, repo);	
	}
}
