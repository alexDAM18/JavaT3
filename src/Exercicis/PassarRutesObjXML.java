package Exercicis;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PassarRutesObjXML {

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
				arrel.appendChild(emp);

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

				for (int i = 0; i < e.length(); i++) {

					Element nieto = doc.createElement("punt");
					nieto.setAttribute("num", Integer.toString(i + 1));
					fill.appendChild(nieto);

					Element bisnet = doc.createElement("nom");
					bisnet.appendChild(doc.createTextNode(e.getPunt(i).getNom()));
					nieto.appendChild(bisnet);

					bisnet = doc.createElement("latitud");
					bisnet.appendChild(doc.createTextNode(Double.toString(e.getPuntLatitud(i))));
					nieto.appendChild(bisnet);

					bisnet = doc.createElement("longitud");
					bisnet.appendChild(doc.createTextNode(Double.toString(e.getPuntLongitud(i))));
					nieto.appendChild(bisnet);
				}

				arrel.appendChild(emp);
			}

		} catch (EOFException eof) {
			f.close();
		}
		Transformer trans = TransformerFactory.newInstance().newTransformer();

		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new FileOutputStream("Rutes.xml"));

		trans.transform(source, result);
	}
}
