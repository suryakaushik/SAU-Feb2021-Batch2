package com.au.kk;



import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean(name = "rectangleObj")
	public Rectangle getRectangle() {
		Set<String> s = new HashSet<>();
		s.add("Orange");
		s.add("Red");
		s.add("Brown");
		s.add("Green");
		return new Rectangle( s, getPoint1(), getPoint2(), getPoint3(), getPoint4());
	}

	@Bean(name = "s1")
	public Point getPoint1() {
		return new Point(1, 10);
	}

	@Bean(name = "s2")
	public Point getPoint2() {
		return new Point(20, 30);
	}

	@Bean(name = "s3")
	public Point getPoint3() {
		return new Point(40, 50);
	}

	@Bean(name = "s4")
	public Point getPoint4() {
		return new Point(30, 20);
	}

}
