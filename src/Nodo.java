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
    /*
    *          Si el diccionario esta en español: Traduccion1 debe estar en ingles
    *          Si el diccionario esta en ingles: Traduccion1 debe estar en español
    *          Si el diccionario esta en Frances: Traduccion1 debe estar en español
    *
     */
    public Nodo (String palabraOriginal, String traduccionUno, String traduccionDos, String idiomaPalabraOriginal){
            establecerKey(palabraOriginal, idiomaPalabraOriginal);
             if(this.key == 0) System.out.println("El primer caracter de la palabra en "+idiomaPalabraOriginal +" no es valido\n***El nodo no fue creado***");
             else {
                 traducciones = new HashMap<String, HashMap<String, String>>();
                 traducciones.put(palabraOriginal, new HashMap<String, String>());
                 switch (idiomaPalabraOriginal) {
                     case "Spanish": {
                         traducciones.get(palabraOriginal).put(idiomaPalabraOriginal, palabraOriginal);
                         traducciones.get(palabraOriginal).put("English", traduccionUno);
                         traducciones.get(palabraOriginal).put("French", traduccionDos);
                         break;
                     }
                     case "English": {
                         traducciones.get(palabraOriginal).put("Spanish", traduccionUno);
                         traducciones.get(palabraOriginal).put(idiomaPalabraOriginal, palabraOriginal);
                         traducciones.get(palabraOriginal).put("French", traduccionDos);
                         break;
                     }
                     case "French": {
                         traducciones.get(palabraOriginal).put("Spanish", traduccionUno);
                         traducciones.get(palabraOriginal).put("English", traduccionDos);
                         traducciones.get(palabraOriginal).put(idiomaPalabraOriginal, palabraOriginal);
                         break;
                     }
                 }
             }
    }
    private void establecerKey(String palabraClave, String idioma){
        String caracteresString;
        if(idioma.equals("Spanish")) caracteresString="abcdefghijklmnñopqrstuvwxyz";
        else caracteresString="abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> caracteres= new ArrayList<String>(Arrays.asList(caracteresString.split("")));
        String primeraLetraPalabra = palabraClave.split("")[0];
        primeraLetraPalabra=primeraLetraPalabra.toLowerCase();
        for (String caracter: caracteres){
            if(caracter.equals(primeraLetraPalabra)){
                this.key=caracteres.indexOf(caracter)+1;
                break;
            }
        }
    }

}
