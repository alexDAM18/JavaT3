package Exercicis;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Llegir_Rutes_Serial {
	public static void main(String[] args) throws IOException {

		DataInputStream f = new DataInputStream(new FileInputStream("Rutes.obj"));

		while (f.available() > 0) {

			System.out.println("Ruta: " + f.readUTF());
			System.out.println("Desnivell" + f.readInt());
			System.out.println("Desnivell acumulat:" + f.readInt());
			int punts = f.readInt();
			System.out.println("Te:" + punts + " punts");

			for (int i = 0; i < punts; i++)
				System.out.println("Punt " + (i + 1) + ":" + f.readUTF() + "(" + f.readDouble() + ")" + f.readDouble());
		}

	}
}
