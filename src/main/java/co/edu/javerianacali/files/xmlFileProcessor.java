package co.edu.javerianacali.files;

import co.edu.javerianacali.entitites.Model;
import org.w3c.dom.Document;
import org.w3c.dom.*;
import java.net.URL;
import org.xml.sax.SAXParseException; 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;

public class xmlFileProcessor{

    /**
    * Método para tomar los datos de xml
    * @author Fernando Ayala y Andres Calderon
    * @param xmlName nombre del archivo que se va a capturar con la extención
    * @version 0.1
    */
    public void readXML(String xmlName)
    {
    try {
            URL url = FileProcessor.class.getClassLoader().getResource(xmlName);    
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(url.openStream());
            
            Model model = new Model();
            
            
            // normalize text representation
            doc.getDocumentElement().normalize();
            //nombre de la raiz
            String nameRoot = doc.getDocumentElement().getNodeName();
            
            //tomo la raiz de archivo
            NodeList root = doc.getElementsByTagName(nameRoot);
            //tamaño de la raiz que debe ser 1
            int rootsize = root.getLength();
            
            /**/         
            //hijos de la raiz
            NodeList listOfChildren = root.item(rootsize-1).getChildNodes(); 
            //cantidad de hijos de la raiz
            int childLe = listOfChildren.getLength();
            //datos de los hijos de la raiz
            String child = listOfChildren.item(3).getTextContent(); 
            
            
            
             /**/     
            
            //hijos de la raiz, se tomar los numeros impares
            String getChild = root.item(rootsize-1).getChildNodes().item(3).getNodeName();
            //hijos de los hujos de la raiz, se tomar los numeros impares
            NodeList childOfChild = root.item(rootsize-1).getChildNodes().item(3).getChildNodes();
            
            /*System.out.println("name of children : " + getChild);
            System.out.println("length of children : " + getChild.length());
            System.out.println("***************");
            System.out.println("child of child len:  "  + childOfChild.getLength() ); // len de los hijos de los hijos*/
            
            //dato final (dato hoja)
            String finalData = childOfChild.item(3).getTextContent();
            //dato final (dato hoja) y su tamaño
            NodeList NOchildOfChild = childOfChild.item(3).getChildNodes();
            int sizeFinalXml =  NOchildOfChild.getLength();
            
            
          

        }catch (SAXParseException err) {
        System.out.println ("** Parsing error" + ", line " 
             + err.getLineNumber () + ", uri " + err.getSystemId ());
        System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
        Exception x = e.getException ();
        ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
        t.printStackTrace ();
        }
        //System.exit (0);

    }
    
   
       
    public static void main(String[] args) {
        xmlFileProcessor file = new xmlFileProcessor();
        file.readXML("xmlFile.xml");
        
    }
    
}
