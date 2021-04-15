import com.sun.nio.sctp.AbstractNotificationHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class lector {

    public void lecturaDeDiccionario(BST diccionarioIngles, BST diccionarioEspanol,  BST diccionarioFrances ){


        try{
            BufferedReader bf = new BufferedReader(new FileReader("assets/diccionario.txt"));
            String bfRead;
            while((bfRead=bf.readLine()) != null){
                String[] lista = bfRead.split(",");
                /**
                 * lista[0] esta en ingles
                 * lista[1] esta en español
                 * lista[2] esta en frances
                 * **/
                diccionarioIngles.insertar(lista[0], lista[1], lista[2]);
                diccionarioEspanol.insertar(lista[1], lista[0], lista[2]);
                diccionarioFrances.insertar(lista[2], lista[1], lista[0]);
                System.out.println("Recore una linea: "+bfRead);
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
