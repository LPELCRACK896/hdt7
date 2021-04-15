import com.sun.nio.sctp.AbstractNotificationHandler;

/**
 * @author Luis Gonzalez
 */
import java.io.BufferedReader;
import java.io.FileReader;

public class lector {
    /**
     *
     * @param diccionarioIngles ingresa el diccionario en ingles  (estructura de arbol de busqueda)
     * @param diccionarioEspanol ingresa el diccionario en español (estructura de arbol de busqueda)
     * @param diccionarioFrances ingresa el diccionario en frances (estructura de arbol de busqueda)
     */
    public void lecturaDeDiccionario(BST diccionarioIngles, BST diccionarioEspanol,  BST diccionarioFrances ){


        try{
            BufferedReader bf = new BufferedReader(new FileReader("assets/diccionario.txt"));
            String bfRead;
            while((bfRead=bf.readLine()) != null){
                String[] lista = bfRead.split(",");

                diccionarioIngles.insertar(lista[0], lista[1], lista[2]);
                diccionarioEspanol.insertar(lista[1], lista[0], lista[2]);
                diccionarioFrances.insertar(lista[2], lista[1], lista[0]);
            }


        }catch (Exception e){

        }

    }

    /**
     *
     * @return devuelve el enunciado del .txt como string
     */
    public String lecturaDeEnunciado(){
        try{
            BufferedReader bf = new BufferedReader(new FileReader("assets/enunciado.txt"));
            String bfRead;
            if((bfRead= bf.readLine())!=null) return bfRead;
            else return "";
        }catch (Exception e){
            return null;
        }
    }
}
