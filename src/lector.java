import com.sun.nio.sctp.AbstractNotificationHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class lector {

    public void lecturaDeDiccionario(BST bst){
        try{
            BufferedReader bf = new BufferedReader(new FileReader("assets/diccionario.txt"));
            String bfRead;
            while((bfRead=bf.readLine()) != null){
                String[] lista = bfRead.split(",");
                bst.insertar(lista[0], lista[1], lista[2]);
            }

        }catch (Exception e){

        }

    }
    public String  lecturaDeEnunciado(){
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
