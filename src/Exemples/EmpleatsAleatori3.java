package Exemples;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EmpleatsAleatori3 {

	public static void main(String[] args) throws IOException {

		RandomAccessFile f = new RandomAccessFile("Empleats3.dat", "rw");
		Scanner sc = new Scanner(System.in);
		System.out.println("Quin registre? (-1 per a eixir): ");
		int num = sc.nextInt();
		char[] nom = new char[20];
		while (num != -1) {

			f.seek(40 * (num - 1));
			System.out.println("Núm.: " + f.readInt());
			for (int i = 0; i < 10; i++)

				nom[i] = f.readChar();

			System.out.println("Nom: " + new String(nom));
			System.out.println("Depart: " + f.readInt());
			System.out.println("Edat: " + f.readInt());
			System.out.println("Sou: " + f.readDouble());
			System.out.println();
			System.out.println("Quin registre? (-1 per a eixir): ");
			num = sc.nextInt();

		}
		f.close();

	}

}