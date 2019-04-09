package Exercicis;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.github.cliftonlabs.json_simple.JsonException;



public class Vis_Rutes_JSON {

    public static void main(String[] args) throws FileNotFoundException, IOException, JsonException {
        Vis_Rutes_JSON_Pantalla finestra = new Vis_Rutes_JSON_Pantalla();
        finestra.iniciar();
    }
}