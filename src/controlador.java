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
            //diccionario.busquedaDePalabra()
        }

        return enunciadoFinal;
    }
}
