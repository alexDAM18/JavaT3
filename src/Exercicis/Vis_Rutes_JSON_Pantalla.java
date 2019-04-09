package Exercicis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class Vis_Rutes_JSON_Pantalla extends JFrame implements ActionListener {

	JComboBox combo;
	JTextArea area = new JTextArea();

	JsonObject arrel;
	JsonArray rutes;

	public void iniciar() throws FileNotFoundException, IOException, JsonException {
		// sentències per a omplir arrel i rutes

		Reader r_json = new FileReader("Rutes.json");
		JsonObject arrel = (JsonObject) Jsoner.deserialize(r_json);
		rutes = (JsonArray) arrel.get("rutes");

		this.setBounds(100, 100, 450, 300);
		this.setLayout(new BorderLayout());

		JPanel panell1 = new JPanel(new FlowLayout());
		JPanel panell2 = new JPanel(new BorderLayout());
		this.add(panell1, BorderLayout.NORTH);
		this.add(panell2, BorderLayout.CENTER);

		ArrayList<String> llista_rutes = new ArrayList<String>();
		// sentències per a omplir l'ArrayList amb el nom de les rutes

		for (Object obj : rutes) {
			JsonObject r = (JsonObject) obj;
			llista_rutes.add(r.get("nom").toString());
			System.out.println(r.get("nom").toString());
		}

		combo = new JComboBox(llista_rutes.toArray());

		panell1.add(combo);

		panell2.add(new JLabel("LLista de punts de la ruta:"), BorderLayout.NORTH);
		panell2.add(area, BorderLayout.CENTER);

		this.setVisible(true);
		combo.addActionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == combo) {
			// accions quan s'ha seleccionat un element del combobox, i que han de consistir
			// en omplir el JTextArea
			area.setText("");

			for (Object obj : rutes) {
				JsonObject r = (JsonObject) obj;
				if (combo.getSelectedItem().equals(r.get("nom").toString())) {
					JsonArray punts = (JsonArray) r.get("punts");
					for (Object ob : punts) {
						JsonObject punt = (JsonObject) ob;
						area.append(punt.get("nom").toString() + "(" + punt.get("latitud").toString()
								+ punt.get("longitud") + ")\n");
					}

				}

			}

		}
	}
}