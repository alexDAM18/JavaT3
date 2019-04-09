package Exemples;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Exercicis.Ruta;

public class CrearEmpleatsXML {
	public static void main(String[] args)
			throws IOException, ClassNotFoundException, ParserConfigurationException, TransformerException {
		ObjectInputStream f = new ObjectInputStream(new FileInputStream("Rutes.obj"));

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element arrel = doc.createElement("rutes");
		doc.appendChild(arrel);

		Ruta e;
		try {
			while (true) {
				e = (Ruta) f.readObject();
				Element emp = doc.createElement("ruta");
				emp.appendChild(doc);

				Element fill = doc.createElement("nom");
				fill.appendChild(doc.createTextNode(e.getNom()));
				emp.appendChild(fill);

				fill = doc.createElement("desnivell");
				fill.appendChild(doc.createTextNode(Integer.toString(e.getDesnivell())));
				emp.appendChild(fill);

				fill = doc.createElement("desnivellAcumulat");
				fill.appendChild(doc.createTextNode(Integer.toString(e.getDesnivellAcumulat())));
				emp.appendChild(fill);

				fill = doc.createElement("punts");
				emp.appendChild(fill);

				arrel.appendChild(emp);
			}

		} catch (EOFException eof) {
			f.close();
		}
		Transformer trans = TransformerFactory.newInstance().newTransformer();

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("Ruta.xml"));

		trans.transform(source, result);
	}
}
