package Exercicis;

import java.io.RandomAccessFile;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PassarRutesSerialObj {

	public static void main(String[] args) throws IOException {

		DataInputStream f = new DataInputStream(new FileInputStream("Rutes.dat"));
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("Rutes.obj"));

		while (f.available() > 0) {
			Ruta ruta = new Ruta();
			ruta.setNom(f.readUTF());
			ruta.setDesnivell(f.readInt());
			ruta.setDesnivellAcumulat(f.readInt());
			int n = f.readInt();

			for (int i = 0; i < n; i++) {

				ruta.addPunt(new PuntGeo(f.readUTF(), new Coordenades(f.readDouble(), f.readDouble())));

			}
			obj.writeObject(ruta);
			ruta.mostraRuta();
		}
		f.close();
		obj.close();
	}

}
