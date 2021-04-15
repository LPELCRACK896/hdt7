import java.util.HashMap;

public class controlador {
    public BST diccionarioIngles;
    public BST diccionarioEspanol;
    public BST diccionarioFrances;
    private lector leer;
    public controlador(){
        diccionarioIngles = new BST("English");
        diccionarioEspanol = new BST("Spanish");
        diccionarioFrances = new BST("French");
        leer = new lector();
        leer.lecturaDeDiccionario(diccionarioIngles, diccionarioEspanol, diccionarioFrances);
    }
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
    public void muestraRecorridosInOrder(){
        System.out.println("****De ingles a frances y español****");
         diccionarioIngles.recorridoInorder(diccionarioIngles.raiz);
        System.out.println("****De español a ingles y frances****");
         diccionarioEspanol.recorridoInorder(diccionarioEspanol.raiz);
        System.out.println("****De frances a ingles y español****");
         diccionarioFrances.recorridoInorder(diccionarioFrances.raiz);
    }
}
