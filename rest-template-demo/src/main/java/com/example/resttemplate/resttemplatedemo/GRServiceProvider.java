package com.example.resttemplate.resttemplatedemo;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GRServiceProvider {

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	RestTemplate restTemplate;
	
	private static Map<String,GlobalRepository> localRepo = new ConcurrentHashMap<String,GlobalRepository>();

	public String getBaseUrl() {
		Application application = eurekaClient.getApplication("global-repository");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		// String hostname = instanceInfo.getHostName();
		String url = instanceInfo.getHomePageUrl();
		// int port = instanceInfo.getPort();
		// System.out.println(instanceInfo.);
		return url;// "https://" + hostname + ":" + port;
	}
	
	@HystrixCommand(fallbackMethod = "getGRGreeting_Fallback")
	public ResponseEntity<String> getGRGreeting(String path) {
		URI determinedBasePathUri = URI.create(getBaseUrl() + path);
		String resp = restTemplate.getForObject(determinedBasePathUri, String.class);
		return ResponseEntity.ok().body(resp);
	}
	
	public ResponseEntity<String> getGRGreeting_Fallback(String path) {
		return ResponseEntity.ok().body("Service is Down at the moment");
	}
	
	@HystrixCommand(fallbackMethod = "getAllRepsitoryForASite_Fallback")
	ResponseEntity<?> getAllRepsitoryForASite(@RequestHeader HttpHeaders header,@RequestParam(value="siteName",required = false) String siteName){
		URI determinedBasePathUri = URI.create(getBaseUrl()+ "globalrepository/allforasite?siteName=" + siteName);
		System.out.println("Abhijit_ :" + header.toString());
		System.out.println("Abhijit_2 " + header.getFirst(HttpHeaders.AUTHORIZATION));
		GlobalRepository repo =  restTemplate.getForObject(determinedBasePathUri,GlobalRepository.class);
		localRepo.put(siteName, repo);
		return ResponseEntity.ok().body(repo);
	}
	
	ResponseEntity<?> getAllRepsitoryForASite_Fallback(@RequestHeader HttpHeaders header,@RequestParam(value="siteName",required = false) String siteName){
		System.out.println("Fall_back service activated - ");
		System.out.println("Abhijit_# :" + header.toString());
		System.out.println("Abhijit_3 " + header.getFirst(HttpHeaders.AUTHORIZATION));
		GlobalRepository repo = localRepo.get(siteName);
		return ResponseEntity.ok().body(repo);
	}
	
	public ResponseEntity<?> register(@RequestHeader HttpHeaders header,@RequestBody GlobalRepository repo)  {
		URI uri = URI.create(getBaseUrl() + "globalrepository/register");
		HttpEntity<?> httpEntiry = null;
		httpEntiry = new HttpEntity<>(repo,header);		
		System.out.println(uri.toString());
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		// Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response, 
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		
		return  restTemplate.postForEntity(uri, httpEntiry, Object.class);
		//return ResponseEntity.ok().body(resp);
	}

}
