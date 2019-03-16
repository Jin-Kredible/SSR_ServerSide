package com.sinc.service;

import org.springframework.stereotype.Service;


@Service("mySqlService")
public class TestServiceImpl implements TestService {
	
	public void testService() {
		System.out.println("mysqlservice testService()"); // <-- controller가 아니기때문에 @requestmapping이 이루어지지 않는다.
	}
	
	
}
