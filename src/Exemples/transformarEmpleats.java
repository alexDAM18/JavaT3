package Exemples;
import java.io.FileWriter;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.JsonArray;

public class transformarEmpleats {

    public static void main(String[] args) throws IOException {
        String[] noms = {"Andreu","Bernat","Clàudia","Damià"};
        int[] departaments = {10,20,10,10};
        int[] edats = {32,28,26,40};
        double[] sous = {1000.0,1200.0,1100.0,1500.0};
        
        JsonObject arrel = new JsonObject();
        JsonObject empresa = new JsonObject();
        arrel.put("empresa", empresa);
        JsonArray empleats = new JsonArray();
        empresa.put("empleat", empleats);
        
        for (int i=0;i<4;i++){
            JsonObject emp = new JsonObject();
            emp.put("num", i+1);
            emp.put("nom", noms[i]);
            emp.put("departament", departaments[i]);
            emp.put("edat", edats[i]);
            emp.put("sou", sous[i]);
            empleats.add(emp);
        }
        
        FileWriter f = new FileWriter("Empleats.json");
        f.write(arrel.toJson());
        f.close();
    }
}