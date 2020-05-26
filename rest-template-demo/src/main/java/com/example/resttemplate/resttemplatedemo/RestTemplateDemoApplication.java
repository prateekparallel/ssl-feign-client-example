package com.example.resttemplate.resttemplatedemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class RestTemplateDemoApplication {

	public static void main(String[] args) {
		System.setProperty("javax.net.ssl.keyStore", "C:\\Projects\\mgssource\\ssl\\client\\keyStore.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "deva1972");
		System.setProperty("javax.net.ssl.trustStore", "C:\\Projects\\mgssource\\ssl\\client\\trustStore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "deva1972");
		SpringApplication.run(RestTemplateDemoApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
/*
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		// Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

		// Note: here we are making this converter to process any kind of response, 
		// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		restTemplate.setMessageConverters(messageConverters);
		
	*/	
		/*
		 * 
		 * 
		 * KeyStore keyStore; HttpComponentsClientHttpRequestFactory requestFactory =
		 * null;
		 * 
		 * try { keyStore = KeyStore.getInstance("jks"); ClassPathResource
		 * classPathResource = new ClassPathResource("nt-gateway.jks"); InputStream
		 * inputStream = classPathResource.getInputStream(); keyStore.load(inputStream,
		 * "nt-gateway".toCharArray());
		 * 
		 * SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(new
		 * SSLContextBuilder() .loadTrustMaterial(null, new TrustSelfSignedStrategy())
		 * .loadKeyMaterial(keyStore, "nt-gateway".toCharArray()).build(),
		 * NoopHostnameVerifier.INSTANCE);
		 * 
		 * HttpClient httpClient =
		 * HttpClients.custom().setSSLSocketFactory(socketFactory)
		 * .setMaxConnTotal(Integer.valueOf(5)) .setMaxConnPerRoute(Integer.valueOf(5))
		 * .build();
		 * 
		 * requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		 * requestFactory.setReadTimeout(Integer.valueOf(10000));
		 * requestFactory.setConnectTimeout(Integer.valueOf(10000));
		 * 
		 * restTemplate.setRequestFactory(requestFactory); } catch (Exception exception)
		 * {
		 * System.out.println("Exception Occured while creating restTemplate "+exception
		 * ); exception.printStackTrace(); }
		 */
		return restTemplate;
	}

}
