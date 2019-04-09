package Exercicis;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class PassarRutesObjJSON {
	public static void main(String[] args) throws IOException, JsonException, ClassNotFoundException {

		ObjectInputStream f = new ObjectInputStream(new FileInputStream("Rutes.obj"));
		Ruta r;

		JsonObject arrel = new JsonObject();
		JsonArray rutes = new JsonArray();

		arrel.put("rutes", rutes);
		try {
			while (true) {

				r = (Ruta) f.readObject();
				LinkedHashMap obj = new LinkedHashMap();

				obj.put("nom", r.getNom());
				obj.put("desnivell", r.getDesnivell());
				obj.put("desnivellAcumulat", r.getDesnivellAcumulat());
				rutes.add(obj);

				JsonArray punts = new JsonArray();
				obj.put("punts", punts);

				for (int i = 0; i < r.length(); i++) {
					LinkedHashMap punt = new LinkedHashMap();
					punt.put("num", (i + 1));
					punt.put("nom", r.getPuntNom(i));
					punt.put("latitud", r.getPuntLatitud(i));
					punt.put("longitud", r.getPuntLongitud(i));
					punts.add(punt);

				}

			}
		} catch (EOFException ex) {
			// TODO Auto-generated catch block
			f.close();
			Writer w_json = new FileWriter("Rutes.json");
			w_json.write(arrel.toJson());
			w_json.close();

		}

	}

}
