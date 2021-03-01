package com.wordcount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class without_thread 
{
	public static void main(String[] args) 
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
}