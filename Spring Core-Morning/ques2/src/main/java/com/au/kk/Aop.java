package com.au.kk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Aop {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		NewBean b = ctx.getBean(NewBean.class);
		b.fun();

	}

}