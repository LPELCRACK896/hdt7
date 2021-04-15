import java.util.HashMap;

/**
 * @author Luis Gonzalez
 */
public class BST {
    private String idiomaOriginal;
    private HashMap<String, String> translations;
    Nodo raiz;

    /**
     *
     * @param idiomaOriginal ingresa el idioma de origen del cual se hara el diccionario
     */
    public BST(String idiomaOriginal){
        this.idiomaOriginal=idiomaOriginal;
        translations=null;
        raiz=null;
    }

    /**
     *
     * @param palabraOriginal ingresa la palabra en el idioma del diccionario
     * @param traduccionUno ingresa su primera traduccion
     * @param traduccionDos ingresa su segundo traduccion
     */
    public void insertar(String palabraOriginal, String traduccionUno, String traduccionDos){
        Nodo n = new Nodo(palabraOriginal, traduccionUno, traduccionDos, idiomaOriginal);

        if(raiz==null){
            raiz=n;
        }else{
            Nodo temporal=raiz;
            while(temporal!=null)
            {
                n.padre= temporal;
                if(n.key>=temporal.key)
                {
                    temporal=temporal.der;
                }else
                {
                    temporal= temporal.izq;
                }
            }
            if(n.key< n.padre.key) n.padre.izq=n;
            else n.padre.der=n;
        }

    }

    /**
     *
     * @param x ingresa el nodo raiz para comenzar el recorrido
     * @param palabraBuscada ingresa la palabra que se desea traducir
     */
    public void  traducir(Nodo x, String palabraBuscada){
        if(x!=null){
            if(x.traducciones.get(palabraBuscada)!=null){
                translations =x.traducciones.get(palabraBuscada);
            }
            else{
                traducir(x.izq, palabraBuscada);
                traducir(x.der, palabraBuscada);
            }


        }
    }

    /**
     *
     * @return devuelve las traducciones de una palabra; usar unicamente posterior a metodo traducir
     */
    public HashMap<String, String> getTranslations() {
        return translations;
    }

    /**
     * resetea el valor de las traducciones para reinstanciar, usado posterior a getTranslations
     */
    public void  resetTranslations() {
         translations=null;
    }

    /**
     * Basado en https://youtu.be/nS96R2H_YY4
     * @param x ingresa el nodo del cual quiere hacer recorrido
     */
    public void recorridoInorder(Nodo x){
        if(x!=null){
          recorridoInorder(x.izq);
          System.out.println("Key: "+x.key+"\tValor: "+x.traducciones);
          recorridoInorder(x.der);

        }
    }

}
