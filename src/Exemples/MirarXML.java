package Exemples;

import java.io.FileNotFoundException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class MirarXML {

	public static void main(String[] args)
			throws ParserConfigurationException, FileNotFoundException, IOException, SAXException {

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("cotxes.xml");
		System.out.println(doc.getNodeName()); // torna el nom del document. No és l'element arrel. Ens dirà #document
		Element arrel = doc.getDocumentElement(); // apuntarà a l'element arrel
		System.out.println(arrel.getNodeName()); // torna el nom de l'element. Ens dirà oferta

		System.out.println(arrel.getNodeValue()); // torna el valor de l'element. Com és un element que conté altres
													// elements, el valor és null

	}
}
