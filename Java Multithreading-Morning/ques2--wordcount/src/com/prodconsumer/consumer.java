package com.prodconsumer;
import java.util.*;

public class consumer extends Thread
{
	Queue<Integer> q = null;
	int size;
	public consumer(Queue<Integer> q,Integer size)
	{
		super();
		this.q=q;
		this.size=size;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				synchronized(q)
				{
					while(q.isEmpty())
					{
						System.out.println("Queue is empty..");
						q.wait();
					}
				}
				synchronized(q)
				{
					Thread.sleep(100);
					int t=q.poll();
					System.out.println("Consumer consumed: " + t+"Rupees");
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