package Exercicis;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Vis_Rutes_XML {

	public static void main(String[] args) {
		Vis_Rutes_XML_Pantalla finestra = new Vis_Rutes_XML_Pantalla();
		try {
			finestra.iniciar();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}