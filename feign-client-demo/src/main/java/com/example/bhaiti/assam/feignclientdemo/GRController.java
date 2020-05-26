package com.example.bhaiti.assam.feignclientdemo;


import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller
public class GRController {

	@Autowired
	GRClient grClient;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	MyRequestInterceptor myRequestInterceptor;
	 
	public String getBaseUrl() {
	    Application application =
	      eurekaClient.getApplication("global-repository");
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    return "https://" + hostname + ":" + port;
	   
	    //if you are not using a discovery server just return like below or as per our requirement
	    //return "https://" + host + port;
	}
	
	@GetMapping(path="/globalrepository", produces = "application/json")
	public ResponseEntity<String> getGRGreeting(@RequestHeader Map<String,String> header) {
		URI determinedBasePathUri = URI.create(getBaseUrl());
		String resp = grClient.getGreeting(determinedBasePathUri,header);
		return ResponseEntity.ok().body(resp);
	}

	@GetMapping("/globalrepository/allforasite")
	ResponseEntity<?> getAllRepsitoryForASite(@RequestHeader HttpHeaders header,@RequestParam(value="siteName",required = false) String siteName){
		URI determinedBasePathUri = URI.create(getBaseUrl());
		System.out.println("Abhijit_ :" + header.toString());
		System.out.println("Abhijit_2 " + header.getFirst(HttpHeaders.AUTHORIZATION));
		return grClient.getAllRepsitoryForASite(determinedBasePathUri,header, siteName);
	}		
	
	//@RequestMapping(method = RequestMethod.POST, value = "/globalrepository/register", consumes = "application/json", produces = "application/json")
	//@ResponseBody
	@PostMapping("/globalrepository/register")
	public ResponseEntity<String> register(@RequestHeader("Authorization") String token,@RequestBody GlobalRepository repo)  {
		URI determinedBasePathUri = URI.create(getBaseUrl());
		return grClient.register(determinedBasePathUri,token,repo);
	}
		
	@PostMapping(value = "/globalrepository/register2", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> register2(@RequestHeader HttpHeaders header,@RequestBody GlobalRepository repo)  {
		URI determinedBasePathUri = URI.create(getBaseUrl());
		myRequestInterceptor.setHeader(header);
		return grClient.register2(determinedBasePathUri,repo);
		
	}
	
}
