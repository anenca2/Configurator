/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.files;

import java.io.File;
import java.net.URL;
import java.util.List;
//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 *
 * @author FernandoBadilloAyala
 */
public class FileProcessor {
    
    
       
    
    /**
    * Método que devuelve una lista con la información contenida en un xml
    * @author Fernando Ayala y Andres Calderon
    * @param xmlName nombre del archivo que se va a capturar con la extención
    * @return Lista con la información contenida en el xml
    * @version 0.1
    */
    @SuppressWarnings("empty-statement")
    public void readXML(String xmlName)
    {

    try {

	//File fXmlFile = new File("C:\\Users\\FernandoBadilloAyala\\Documents\\NetBeansProjects\\configurador\\src\\main\\resources\\"+xmlName);
        URL url = FileProcessor.class.getClassLoader().getResource(xmlName);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(url.openStream());
			
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		
        NodeList prueba = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
	NodeList nList = doc.getElementsByTagName("Portatil");
			
	System.out.println("---------------------------- " + prueba.item(0));
        
        

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
                System.out.println("\ndata Elementsd :" + nNode.getFirstChild().getNodeName());
                System.out.println("\ndata Element :" + nNode.getChildNodes());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
                        
                        //System.out.println("\ndata Element :" + eElement.getC);
			//System.out.println("Staff id : " + eElement.getAttribute("id"));
			System.out.println("Procesador: " + eElement.getElementsByTagName("Procesador").item(0).getTextContent());
			System.out.println("Memoria Ram: " + eElement.getElementsByTagName("MemoriaRam").item(0).getTextContent());
			System.out.println("Disco Duro: " + eElement.getElementsByTagName("DiscoDuro").item(0).getTextContent());
			System.out.println("Sistema Operativo: " + eElement.getElementsByTagName("SistemaOperativo").item(0).getTextContent());
                        System.out.println("Resolucion Pantalla: " + eElement.getElementsByTagName("ResolucionPantalla").item(0).getTextContent());
                        System.out.println("Pantalla: " + eElement.getElementsByTagName("Pantalla").item(0).getTextContent());
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
    
    
    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.
        FileProcessor file = new FileProcessor();
        file.readXML("xmlFile.xml");
        
    }
}
