package com.example.bhaiti.assam.feignclientdemo;

import java.net.URI;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(name = "sslClient", configuration = FeignConfigurationGR.class)
public interface GRClient{
		@GetMapping("/globalrepository/allforasite")
		ResponseEntity<?> getAllRepsitoryForASite(URI determinedBasePathUri,
				@RequestHeader HttpHeaders header,@RequestParam(value="siteName",required = false) String siteName);
		
		@GetMapping("/globalrepository")
		String getGreeting(URI determinedBasePathUri,@RequestHeader Map<String,String> header);
		
		@PostMapping(value = "/globalrepository/register", consumes = "application/json", produces = "application/json")
		public ResponseEntity<String> register(URI determinedBasePathUri,@RequestHeader("Authorization") String token,@RequestBody GlobalRepository repo);
		
		
		@PostMapping(value = "/globalrepository/register", consumes = "application/json", produces = "application/json")
		public ResponseEntity<String> register2(URI determinedBasePathUri,@RequestBody GlobalRepository repo);
		
}
