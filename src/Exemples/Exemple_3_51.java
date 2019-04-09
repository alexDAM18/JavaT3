package Exemples;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class Exemple_3_51 {

	public static void main(String[] args) throws JsonException {
		String cadena = "{ \"p1\" : 2 , \"p2\" : 4 , \"p3\" : 6 , \"p4\" : 8 , \"p5\" : 10 }";

		JsonObject arrel = (JsonObject) Jsoner.deserialize(cadena);

		System.out.println(arrel.get("p5"));
	}
}