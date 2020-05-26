package com.example.bhaiti.assam.feignclientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class MyRequestInterceptor implements RequestInterceptor{
	
	RequestTemplate template;
	
	@Override
	  public void apply(RequestTemplate template) {
	    this.template = template;
	  }

	public void setHeader(HttpHeaders header) {
		this.template.resolve(header.toSingleValueMap());
	}
}
