package com.sinc.service;

import org.springframework.stereotype.Service;

@Service("oracleService")
public class SampleServiceImpl implements TestService{

	@Override
	public void testService() {
		System.out.println("oracleService testService()");
		
	}

}
