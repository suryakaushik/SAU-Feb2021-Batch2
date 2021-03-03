package com.au.kk;

import org.springframework.stereotype.Component;

@Component //Its a Bean
public class NewBean {
	
	int num=123;
	
	public void fun() {
		System.out.println("Inside fun() of Component/Bean");
	}
	
	public int getdetails()
	{
		System.out.println("Inside getdetails() of Component/Bean");
		return num;
	}

}