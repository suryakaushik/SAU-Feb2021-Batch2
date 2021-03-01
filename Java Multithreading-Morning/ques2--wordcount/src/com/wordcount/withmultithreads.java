package com.wordcount;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class withmultithreads extends Thread{
	
    public void run()
	{
    	var startTime = System.currentTimeMillis();
    	long words=0;
		try(BufferedReader br = new BufferedReader(new FileReader("dummytext.txt")))
		{
			String s;
			while((s=br.readLine())!=null)
			{
				words+=s.split("\\s+").length;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Total number of words are: " + words);
		var endTime = System.currentTimeMillis();
		System.out.println("Total Time taken is: " + (endTime-startTime) + "ms");
    } 
	public static void main(String[] args) {

		withmultithreads t1=new withmultithreads();
		withmultithreads t2=new withmultithreads();
		
        t1.start();
        t2.start();
	}
}