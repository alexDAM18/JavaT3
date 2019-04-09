package Exemples;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;


public class Exemple_3_52 {

    public static void main(String[] args) throws JsonException, IOException  {
        
         Reader r_json = new FileReader("nomParelles.json");
         
         JsonObject arrel = (JsonObject) Jsoner.deserialize(r_json);
         
         System.out.println(arrel.get("p1"));
    }
}