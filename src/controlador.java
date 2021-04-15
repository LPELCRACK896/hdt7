import java.util.HashMap;

/**
 * @author Luis Gonzalez
 */
public class controlador {
    public BST diccionarioIngles;
    public BST diccionarioEspanol;
    public BST diccionarioFrances;
    private lector leer;

    /**
     * Constructor
     */
    public controlador(){
        diccionarioIngles = new BST("English");
        diccionarioEspanol = new BST("Spanish");
        diccionarioFrances = new BST("French");
        leer = new lector();
        leer.lecturaDeDiccionario(diccionarioIngles, diccionarioEspanol, diccionarioFrances);
    }

    /**
     *
     * @param idiomaOriginal ingresa el idioma del la frase que se traduce
     * @param idiomaDestino ingresa el idioma al que desesa traducir
     * @return devuelve enunciado de la traduccion
     */
    public String traduceme(String idiomaOriginal, String idiomaDestino){
        BST diccionario;
        diccionario=(idiomaOriginal.equals("Spanish"))?diccionarioEspanol:(idiomaOriginal.equals("English"))?diccionarioIngles:diccionarioFrances;
        String enunciado=leer.lecturaDeEnunciado();
        String enunciadoFinal="";
        for(String palabra: enunciado.split(" ")){
            HashMap<String, String> traducciones;
            diccionario.traducir(diccionario.raiz, palabra);
            traducciones=diccionario.getTranslations();
            diccionario.resetTranslations();
            if(traducciones!=null){
                enunciadoFinal=enunciadoFinal+" "+traducciones.get(idiomaDestino);

            }else{
                enunciadoFinal=enunciadoFinal+" *"+palabra+"*";
            }
        }
        return enunciadoFinal;
    }

    /**
     * Muestra todos los recorridos de los diccionarios
     */
    public void muestraRecorridosInOrder(){
        System.out.println("****De ingles a frances y español****");
         diccionarioIngles.recorridoInorder(diccionarioIngles.raiz);
        System.out.println("****De español a ingles y frances****");
         diccionarioEspanol.recorridoInorder(diccionarioEspanol.raiz);
        System.out.println("****De frances a ingles y español****");
         diccionarioFrances.recorridoInorder(diccionarioFrances.raiz);
    }
}
