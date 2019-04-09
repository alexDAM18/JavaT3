package Exercicis;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

public class PassarCotxesXMLJSON {
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("cotxes.xml");
		Writer w_json = new FileWriter("cotxes.json");

		Element arrel = (Element) doc.getChildNodes().item(0);
		NodeList llista = arrel.getElementsByTagName("vehiculo");

		JsonObject arrelJson = new JsonObject();
		JsonObject oferta = new JsonObject();
		
		arrelJson.put("Oferta", oferta);

		for (int i = 0; i < llista.getLength(); i++) {

		}
	}
}