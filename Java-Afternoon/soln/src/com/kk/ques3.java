package com.kk;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.HashMap;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class ques3 
{
	public static void fun() throws Exception
	{
		File file1 = new File("License1.xml");
        File file2 = new File("License2.xml");

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc1 = db.parse(file1);
        doc1.getDocumentElement().normalize();
        Document doc2 = db.parse(file2);
        doc2.getDocumentElement().normalize();
        
        Document outputdoc = db.newDocument();
        Element root = outputdoc.createElement("CSR_Producer");
        outputdoc.appendChild(root);
        
        HashMap<String,Element> finalmap=new HashMap<>();
        NodeList l1 = doc1.getElementsByTagName("CSR_Producer");
        NodeList l2 = doc2.getElementsByTagName("CSR_Producer");

        for (int i = 0; i < l1.getLength(); ++i) {
            Element temp = (Element) l1.item(i);
            StringBuilder key=new StringBuilder(temp.getAttribute("NIPR_Number"));
            NodeList liclist = temp.getElementsByTagName("License");
            for (int j = 0; j < liclist.getLength(); j++) {
                Element t = (Element) liclist.item(j);
                key.append(",");
                key.append(t.getAttribute("State_Code"));
                key.append(",");
                key.append(t.getAttribute("License_Number"));
                key.append(",");
                key.append(t.getAttribute("Date_Status_Effective"));
                finalmap.put(key.toString(), t);
                key=new StringBuilder(temp.getAttribute("NIPR_Number"));
            }
        }

        for (int i = 0; i < l2.getLength(); ++i) {
            Node node = l2.item(i);
            Element tElement2 = (Element) node;
            StringBuilder key=new StringBuilder(tElement2.getAttribute("NIPR_Number"));
            NodeList liclist = tElement2.getElementsByTagName("License");
            for (int j = 0; j < liclist.getLength(); j++) {
                Element t = (Element) liclist.item(j);
                key.append(",");
                key.append(t.getAttribute("State_Code"));
                key.append(",");
                key.append(t.getAttribute("License_Number"));
                key.append(",");
                key.append(t.getAttribute("Date_Status_Effective"));
                if(finalmap.containsKey(key.toString())){
                    Node license = outputdoc.importNode(t, true);
                    root.appendChild(license);
                }
                else
                {
                	key=new StringBuilder(tElement2.getAttribute("NIPR_Number"));
                }
            }
        }

        Transformer tfactory = TransformerFactory.newInstance().newTransformer();
        tfactory.transform(new DOMSource(outputdoc), new StreamResult(new File("mergedLicenses.xml")));
	}
    public static void main(String[] args) {
        try {
            fun();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
