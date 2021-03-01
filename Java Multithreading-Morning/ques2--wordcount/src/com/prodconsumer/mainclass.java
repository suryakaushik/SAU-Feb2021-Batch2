package com.prodconsumer;
import java.util.*;

public class mainclass {

	public static void main(String[] args) {

		Queue<Integer> q = new PriorityQueue<>();

		q.add(77);
		q.add(78);
		q.add(79);
		
		Thread t1 = new Thread(new producer(q,5));
		Thread t2 = new Thread(new consumer(q,5));
		
		t1.start();
		t2.start();

	}

}
