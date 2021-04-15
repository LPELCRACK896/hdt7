import java.util.HashMap;

public class BST {
    private String idiomaOriginal;
    private HashMap<String, String> translations;
    Nodo raiz;
    public BST(String idiomaOriginal){
        this.idiomaOriginal=idiomaOriginal;
        translations=null;
        raiz=null;
    }
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
    public HashMap<String, String> getTranslations() {
        return translations;
    }

    public void  resetTranslations() {
         translations=null;
    }
    /*
    Basado en https://youtu.be/nS96R2H_YY4
     */
    public void recorridoInorder(Nodo x){
        if(x!=null){
          recorridoInorder(x.izq);
          System.out.println("Key: "+x.key+"\tValor: "+x.traducciones);
          recorridoInorder(x.der);

        }
    }
}
