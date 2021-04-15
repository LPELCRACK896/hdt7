import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

public class Nodo {
    public Nodo padre;
    public Nodo izq;
    public Nodo der;
    public int key=0;
    public HashMap<String, HashMap<String, String>> traducciones;
    public Nodo (String palabraEnIngles, String palabraEnEspañol, String palabraEnFrances){
            traducciones = new HashMap<String, HashMap<String, String>>();
            traducciones.put(palabraEnIngles, new HashMap<String, String>());
            traducciones.get(palabraEnIngles).put("Spanish", palabraEnEspañol);
            traducciones.get(palabraEnIngles).put("English", palabraEnIngles);
            traducciones.get(palabraEnIngles).put("French", palabraEnFrances);
            establecerKey(palabraEnIngles);
            if(this.key == 0) System.out.println("El primer caracter de la palabra en ingles no es valido");
    }
    private void establecerKey(String palabraClave){
        String caracteresString="abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> caracteres= new ArrayList<String>(Arrays.asList(caracteresString.split("")));
        String caracterDeReferencia = palabraClave.split("")[0];
        caracterDeReferencia=caracterDeReferencia.toLowerCase();
        for (String car: caracteres){
            if(car.equals(caracterDeReferencia)){
                this.key=caracteres.indexOf(car)+1;
                return;
            }
        }
    }

}
