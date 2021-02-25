package com.kk;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class ques1 {
	
	public static void fun() throws Exception
	{
		File file = new File("mergedLicenses.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc1 = db.parse(file);

        Document valid = db.newDocument();
        Element root1 = valid.createElement("CSR_Producer");
        valid.appendChild(root1);
        
        Document invalid = db.newDocument();
        Element root2 = invalid.createElement("CSR_Producer");
        invalid.appendChild(root2);
        
        
        
        doc1.getDocumentElement().normalize();
        NodeList csrtag = doc1.getElementsByTagName("CSR_Producer");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    LocalDate todayDate = LocalDate.of(2021,02,16);

        for (int i = 0; i < csrtag.getLength(); ++i) {
            Element temp = (Element)csrtag.item(i);
            NodeList liclist = temp.getElementsByTagName("License");

           
            
            
            for (int j = 0; j < liclist.getLength(); j++) {
                Element t = (Element) liclist.item(j);
                String led=t.getAttribute("License_Expiration_Date");
                LocalDate leDate=LocalDate.parse(led, formatter);
                if(leDate.compareTo(todayDate)>0){
                    Node license = valid.importNode(t, true);
                    root1.appendChild(license);
                }
                else{
                    Node license = invalid.importNode(t, true);
                    root2.appendChild(license);
                }
            }
        }
        Transformer tfactory = TransformerFactory.newInstance().newTransformer();
        tfactory.transform(new DOMSource(valid), new StreamResult(new File("validlicense.xml")));
        tfactory.transform(new DOMSource(invalid), new StreamResult(new File("invalidlicense.xml")));
		
	}
    public static void main(String[] args) {
        try{
            fun();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}