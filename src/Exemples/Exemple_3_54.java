package Exemples;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.Jsoner;

public class Exemple_3_54 {

    public static void main(String[] args) throws JsonException {
        String cadena = "[ 5 , 7 , 8 , 7 ]";
        
        JsonArray arrel = (JsonArray) Jsoner.deserialize(cadena);
        
        for (int i=0; i<arrel.size();i++)
            System.out.println(arrel.get(i));
    }
}