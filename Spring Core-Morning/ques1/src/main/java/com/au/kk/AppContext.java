package com.au.kk;


	import java.io.IOException;

	import org.springframework.context.ApplicationContext;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

	public class AppContext {
		public static void main(String[] args) throws IOException {
			ApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
			Rectangle rectangle = (Rectangle) factory.getBean("rectangleObj");
			rectangle.display();
			((AnnotationConfigApplicationContext) factory).close();
		}

	}