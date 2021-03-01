package com.wordcount;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class withonethread extends Thread{
    public void run()
	{
    	long words=0;
		var startTime = System.currentTimeMillis();
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
		withonethread t1=new withonethread();
        t1.start();
	}
}
