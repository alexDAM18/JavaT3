package Exemples;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CrearEmpleats3 {
	public static void main(String[] args) throws IOException {
		DataOutputStream f = new DataOutputStream(new FileOutputStream("Empleats3.dat"));
		String[] noms = { "Andreu    ", "Bernat    ", "Clàudia   ", "Damià     " };
		int[] departaments = { 10, 20, 10, 10 };
		int[] edats = { 32, 28, 26, 40 };
		double[] sous = { 1000.0, 1200.0, 1100.0, 1500.0 };
		for (int i = 0; i < 4; i++) {
			f.writeInt(i + 1);
			f.writeChars(noms[i]);
			f.writeInt(departaments[i]);
			f.writeInt(edats[i]);
			f.writeDouble(sous[i]);
		}
		f.close();
	}
}