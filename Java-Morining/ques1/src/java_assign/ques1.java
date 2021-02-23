package java_assign;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.*;
import java.util.*;


class student implements Serializable{
	
	int marks;
    int rollNumber;
    String subject;
    
    student(int rollNumber, int marks, String subject)
    {
        this.rollNumber=rollNumber;
        this.marks=marks;
        this.subject=subject;
    }
    
    student(int rollNumber,int marks){
    	this.rollNumber=rollNumber;
    	this.marks=marks;
    }
}


public class ques1 {
	
	public static void fun() throws Exception
	{
        File inputFile = new File("C:\\Users\\jayas\\Desktop\\acc univ\\day7 java\\mrng assign\\input\\student.xml");
        
        DocumentBuilderFactory documentfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docbuilder = documentfactory.newDocumentBuilder();
        Document nodeObj = docbuilder.parse(inputFile);
        nodeObj.getDocumentElement().normalize();
        NodeList lists = nodeObj.getElementsByTagName("student");


        ArrayList<student> arr = new ArrayList<>();
        
        for (int i = 0; i < lists.getLength(); i++) 
        {
            
            Element t = (Element) lists.item(i);
            
            int student_roll = Integer.parseInt(t.getElementsByTagName("roll").item(0).getTextContent());
            int student_marks=Integer.parseInt(t.getElementsByTagName("marks").item(0).getTextContent());
            String subject=(t.getElementsByTagName("subject").item(0).getTextContent());
            
            arr.add(new student(student_roll,student_marks,subject));
            
        }
        
        
        HashMap <Integer, Integer> studmap = new HashMap<>();
        for (int i = 0; i < lists.getLength(); i++) {
        	
        	int rol = arr.get(i).rollNumber;
        	if (studmap.containsKey(rol)) {
        		int total_so_far = studmap.get(rol);
        		studmap.put(rol, total_so_far + arr.get(i).marks);
        	}
        	else {
        		studmap.put(rol, arr.get(i).marks);
        	}
        }
        
        PrintWriter outfile = new PrintWriter("C:\\Users\\jayas\\Desktop\\acc univ\\day7 java\\mrng assign\\output\\student.txt");
        
        
        for (int index: studmap.keySet()) {
        	student obj = new student(index, studmap.get(index));

            outfile.println(obj.rollNumber+" "+obj.marks);
        }
        
        outfile.close();
	}
    
    public static void main(String args[])
    {
        
        try{

        	fun();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
  }