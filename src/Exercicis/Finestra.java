package Exercicis;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Finestra extends JFrame implements ActionListener {
	JComboBox combo;
	JButton boto1;

	public void iniciar() {
		setSize(400, 200);
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(new JLabel("Tria un color"));

		String[] llista = { "Roig", "Blau", "Verd", "Groc" };
		combo = new JComboBox(llista);
		getContentPane().add(combo);
		boto1 = new JButton("Color");
		getContentPane().add(boto1);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		combo.addActionListener(this);
		combo.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == combo) {
			boto1.setText(combo.getSelectedItem().toString());
			switch (combo.getSelectedIndex()) {
			case 0:
				boto1.setBackground(Color.red);
				break;
			case 1:
				boto1.setBackground(Color.blue);
				break;
			case 2:
				boto1.setBackground(Color.GREEN);
				break;
			case 3:
				boto1.setBackground(Color.yellow);
				break;
			}
		}
	}
}