package Exemples;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.JsonArray;

public class Exemple_3_55 {

    public static void main(String[] args) throws IOException, JsonException {
        Reader r_json = new FileReader("empresa.json");
        
        JsonObject arrel = (JsonObject) Jsoner.deserialize(r_json);
        
        JsonObject empresa = (JsonObject) arrel.get("empresa");
        
        JsonArray empleats = (JsonArray) empresa.get("empleats");
        
        for (Object e : empleats) {
            JsonObject emp = (JsonObject) e;
            System.out.println(emp.get("nom") + " (" + emp.get("sou") + ")");
        }
    }
}