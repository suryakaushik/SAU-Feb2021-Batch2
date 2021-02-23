package java_assign;


import java.io.*;
import java.util.*;



class StudentComparator implements Comparator<student>{ 
    
    public int compare(student student1, student student2) { 
    	 if(student1.marks < student2.marks) {
      	   return 1;
         }
         else if (student1.marks > student2.marks) {
      	   return -1;
         }
         
         return 0;
    }
}

public class ques2 { 
	
	
	public static void fun() throws Exception
	{
	    PriorityQueue<student> pq = new PriorityQueue<student>(new StudentComparator());     
	    
	    BufferedReader fin = new BufferedReader(new FileReader("C:\\Users\\jayas\\Desktop\\acc univ\\day7 java\\ques1\\output\\student.txt"));
	    
	    String c;
	    while((c=fin.readLine())!=null)
	    {
	    	String[] t=c.split(" ",2);
	    	pq.add(new student(Integer.parseInt(t[0]),Integer.parseInt(t[1])));
	    }
	    
	  
	    fin.close();
	   
	   	StringBuffer strbuf = new StringBuffer();
	   	
	    strbuf.append("Rank, Roll Number, Total Marks");
	    FileOutputStream outputfile = new FileOutputStream("C:\\Users\\jayas\\Desktop\\acc univ\\day7 java\\ques1\\output\\answer2.csv");
	    BufferedWriter outputcsv = new BufferedWriter(new OutputStreamWriter(outputfile, "UTF-8"));
	    
	    outputcsv.write(strbuf.toString());
	    outputcsv.newLine();
	    for(int i = 0; i < 3; i++) {
	    	
		   student student = pq.poll();
	       strbuf = new StringBuffer();
	       
	       // using i+1 for storing the rank
	       strbuf.append(i+1);
	       
	       // appends comma for the entry in new column
	       strbuf.append(",");
	       
	       strbuf.append(student.rollNumber);
	       
	       
	       strbuf.append(",");
	       strbuf.append(student.marks);
	       
	       outputcsv.write(strbuf.toString());
	       
	       outputcsv.newLine();
	    }
	    
	    outputcsv.flush();
	    outputcsv.close();
	}
    
	public static void main(String[] args) {
	    try
	    {
	    	fun();

	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	} 
}