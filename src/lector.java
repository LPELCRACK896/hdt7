import com.sun.nio.sctp.AbstractNotificationHandler;

import java.io.BufferedReader;
import java.io.FileReader;

public class lector {

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
