package Exemples;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.JsonArray;

public class transformarBicicas {

    public static void main(String[] args) throws IOException, JsonException {
        Reader r_json = new FileReader("bicicas.json");

        JsonArray estacions = (JsonArray) ((JsonObject) ((JsonArray ) Jsoner.deserialize(r_json)).get(0)).get("ocupacion");
        
        JsonArray destEstacions = new JsonArray();
        
        for (Object est : estacions){
            JsonObject e = (JsonObject) est;
            JsonObject destE = new JsonObject();
            destE.put("num", e.get("id"));
            destE.put("nom", e.get("punto"));
            destE.put("llocs", e.get("puestos"));
            destE.put("ocupats", e.get("ocupados"));
            int lliures = Integer.parseInt(e.get("puestos").toString())-Integer.parseInt(e.get("ocupados").toString());
            destE.put("lliures", lliures );
            destEstacions.add(destE);
        }
        
        JsonObject bicicas = new JsonObject();
        bicicas.put("bicicas",destEstacions);
        
        Writer w_json = new FileWriter("bicicas2.json");
        w_json.write(bicicas.toJson());
        w_json.close();
    }
}