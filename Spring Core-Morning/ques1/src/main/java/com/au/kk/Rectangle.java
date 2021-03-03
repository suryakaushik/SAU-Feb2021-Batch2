package com.au.kk;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Rectangle {
	
	private Set<String> s;

	int height, width;

	@Autowired
	@Qualifier("s1")
	private Point p1;

	@Autowired
	@Qualifier("s2")
	private Point p2;

	@Autowired
	@Qualifier("s3")
	private Point p3;

	@Autowired
	@Qualifier("s4")
	private Point p4;

	public Rectangle( Set<String> s, Point p1, Point p2, Point p3, Point p4) {
		
		this.s = s;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}

	public Point getPoint1() {
		return p1;
	}

	public void setPoint1(Point p1) {
		this.p1 = p1;
	}

	public Point getPoint2() {
		return p2;
	}

	public void setPoint2(Point p2) {
		this.p2 = p2;
	}

	public Point getPoint3() {
		return p3;
	}

	public void setPoint3(Point p3) {
		this.p3 = p3;
	}

	public Point getPoint4() {
		return p4;
	}

	public void setPoint4(Point p4) {
		this.p4 = p4;
	}

	public int getHeight() {
		this.height = p2.getb() - p1.geta();
		return this.height;
	}

	public int getWidth() {
		this.width = p3.geta() - p1.geta();
		return this.width;
	}

	public void display() {
		System.out.println();
		System.out.println(" Contents Of Rectangle:");
		System.out.println("  Point1 "+" =>"+getPoint1().geta()+", "+getPoint1().getb());
		System.out.println("  Point2 "+" =>"+getPoint2().geta()+", "+getPoint2().getb());
		System.out.println("  Point3 "+" =>"+getPoint3().geta()+", "+getPoint3().getb());
		System.out.println("  Point4 "+" =>"+getPoint4().geta()+", "+getPoint4().getb());
		System.out.println();
		System.out.println(" Properties Of Rectangle:");
		System.out.println("  Height "+ getHeight());
		System.out.println("  Width "+ getWidth());
		System.out.println();
		System.out.println("  Displaying... ");
		
		for(String i:s)
		{
			System.out.println("  "+i);
		}
	}
}