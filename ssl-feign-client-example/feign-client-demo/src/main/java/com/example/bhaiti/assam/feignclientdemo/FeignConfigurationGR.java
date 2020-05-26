package com.example.bhaiti.assam.feignclientdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Client;
import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignConfigurationGR {
	
	@Bean
	public Client getfeignClientGR()
	{
		SSLUtil.setupSslContext();
	    Client trustSSLSockets = new Client.Default(
	            SSLUtil.getClientSSLSocketFactory(),
	            null);

	    System.out.println("feignClient called");
	    return trustSSLSockets;
	}
	/*
	@Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptorGR() {
        return new BasicAuthRequestInterceptor("babatu", "test1234");
    }*/

}
