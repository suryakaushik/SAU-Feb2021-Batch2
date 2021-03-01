package com.prodconsumer;
import java.util.*;

public class producer extends Thread
{
	Queue<Integer> q = null;
	int size;
	Random rand = new Random();
	public producer(Queue<Integer> q,Integer size)
	{
		super();
		this.q = q;
		this.size=size;
	}
	public void run()
	{
		int c=0;
		while(true)
		{
			c+=1;
			if(c>4)
				System.exit(0);
			else
			{
				int amount=rand.nextInt(1000);
				try
				{
					synchronized(q)
					{
						while(q.size() == this.size)
						{
							System.out.println("Queue is full..");
							q.wait();
						}
					}
					synchronized(q)
					{
						
						System.out.println("Producer produced: " + amount+"Rupees");
						q.add(amount);
						Thread.sleep(60);
						q.notify();
					}
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
		}
	}
}