package Exercicis;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Vis_Rutes_XML_Pantalla extends JFrame implements ActionListener{
    
    JComboBox combo;
    JTextArea area = new JTextArea();
    Document doc;
    
    public void iniciar() throws SAXException, IOException, ParserConfigurationException{
    	
    	Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream("Rutes.xml"));
    	
    	Element arrel = (Element) doc.getChildNodes().item(0);
    	NodeList llista = arrel.getElementsByTagName("ruta");
    	
        this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout());
        
        JPanel panell1 = new JPanel(new FlowLayout());
        JPanel panell2 = new JPanel(new BorderLayout());
        this.add(panell1,BorderLayout.NORTH);
        this.add(panell2,BorderLayout.CENTER);
        
        ArrayList<String> llista_rutes = new ArrayList<String>();
        
        for(int i = 0; i<llista.getLength(); i++) {
        	Element em = (Element) llista.item(i);
        	llista_rutes.add(em.getElementsByTagName("nom").item(0).getChildNodes().item(0).getNodeValue());
        }
       
        combo = new JComboBox(llista_rutes.toArray());
        
        panell1.add(combo);
        
        panell2.add(new JLabel("LLista de punts de la ruta:"),BorderLayout.NORTH);
        panell2.add(area,BorderLayout.CENTER);
        
        this.setVisible(true);
        combo.addActionListener(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == combo){
            area.setText("");
            Document doc;
            try {
            	doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream("Rutes.xml"));
            	Element arrel = (Element) doc.getChildNodes().item(0);
            	
            	NodeList rutes = arrel.getElementsByTagName("ruta");
            	for(int i = 0; i<rutes.getLength(); i++) {
            		Element ruta = (Element) rutes.item(i);
            		if(combo.getSelectedItem().equals(ruta.getElementsByTagName("nom").item(0).getTextContent())) {
            			NodeList llista_punts = (ruta).getElementsByTagName("punt");
            			for(int j = 0; j<llista_punts.getLength(); j++) {
            				Element el = (Element) llista_punts.item(j);
            				area.append(el.getElementsByTagName("nom").item(0).getChildNodes().item(0).getNodeValue());
            				area.append("(" 
            					+ el.getElementsByTagName("latitud").item(0).getChildNodes().item(0).getNodeValue() + ",");
            				area.append(el.getElementsByTagName("longitud").item(0).getChildNodes().item(0).getNodeValue() + ")" + "\n");
            			}	
            		}
            	}
            } catch (IOException | SAXException | ParserConfigurationException ex) {
            	
            }
        	
            
        }
    }
}