package Exemples;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

public class Exemple_3_53 {

    public static void main(String[] args) throws IOException, JsonException {
        Reader r_json = new FileReader("empleat.json");
        
        JsonObject arrel = (JsonObject) Jsoner.deserialize(r_json);
        
        JsonObject empleat = (JsonObject) arrel.get("empleat");
        
        System.out.println(empleat.get("nom") + " (" + empleat.get("sou") + ")");
    }
}