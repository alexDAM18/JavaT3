package Exemples;
import java.io.FileReader;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.JsonArray;


public class mirarBicicas {

    public static void main(String[] args) throws IOException, JsonException {
        JsonArray arrel = (JsonArray) Jsoner.deserialize(new FileReader("bicicas.json"));
        JsonObject obj = (JsonObject) arrel.get(0);
        JsonArray estacions = (JsonArray) obj.get("ocupacion");

        for (int i=0; i<estacions.size();i++){
            JsonObject e = (JsonObject) estacions.get(i);
            System.out.println(e.get("id") + ".- " + e.get("punto") + " (" + e.get("ocupados") + "/" + e.get("puestos") + ")");
        }
    }
}