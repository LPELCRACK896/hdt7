public class BST {
    Nodo raiz;
    public BST(){
        raiz=null;
    }
    public void insertar(String palabraEnIngles, String palabraEnEspañol, String palabraEnFrances){
        Nodo nodoAInsertar = new Nodo(palabraEnIngles, palabraEnEspañol, palabraEnFrances);
        int key=nodoAInsertar.key;
        if(raiz==null) raiz = nodoAInsertar;
        else{
            Nodo temporal = raiz;
            while(temporal!=null){
                nodoAInsertar.padre= temporal;
                if(nodoAInsertar.key>= temporal.key) temporal=temporal.der;
                else temporal=temporal.izq;
            }
            if(nodoAInsertar.key< nodoAInsertar.padre.key) nodoAInsertar.padre.izq=nodoAInsertar;
            else nodoAInsertar.padre.der=nodoAInsertar;
        }
    }
}
