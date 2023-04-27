package demo.xml_operation;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DataWrite 
{
	public static void main(String[] args)
	{
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			
			Element rootElement = doc.createElement("Characters");
			doc.appendChild(rootElement);
			
			Element seriesElement = doc.createElement("Series");
			rootElement.appendChild(seriesElement);
			
			Attr attribute = doc.createAttribute("Name");
			attribute.setValue("One Punch Man");
			seriesElement.setAttributeNode(attribute);
			
			Element name1 = doc.createElement("Name");
			Attr attr1 = doc.createAttribute("Role");
			attr1.setValue("Hero");
			name1.setAttributeNode(attr1);
			name1.appendChild(doc.createTextNode("Saitama"));
			seriesElement.appendChild(name1);
			
			Element name2 = doc.createElement("Name");
			Attr attr2 = doc.createAttribute("Role");
			attr2.setValue("Villain");;
			name2.setAttributeNode(attr2);
			name2.appendChild(doc.createTextNode("Garou"));
			seriesElement.appendChild(name2);
			
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(doc);
			
			StreamResult streamResult = new StreamResult("C:\\Users\\ACNadmin2\\Desktop\\Demon\\Eclipse-Wrokplace\\Excel_Operations\\ExcelFiles\\Character.xml");
			transformer.transform(domSource, streamResult);
			
			StreamResult consResult = new StreamResult(System.out);
	        transformer.transform(domSource, consResult);
		}
		catch(Exception e) {}
	}

}
