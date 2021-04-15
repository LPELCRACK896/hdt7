import jdk.swing.interop.SwingInterOpUtils;

/**
 * @author Luis Gonzalez
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//git: https://github.com/LPELCRACK896/hdt7.git
public class main {
    public static void main(String[]args){
        controlador con = new controlador();
        Scanner escribe = new Scanner(System.in);
        String opcion;
        int contador=0;
        int opcionAux=0;
        String opcSalir="";
        System.out.println("**Bienvenido al diccionario frances-ingles-español**\n");

        System.out.println("****ACLARACION DEL FUNCINAMIENTO****"
                +"\n\n1. El programa tiene 3 estructuras de arbol, todas basadas en el mismo archivo pero cada una correspone a un idioma de origen"
                +"\nPor ello al hacer el recorrido, en realidad realiza 3  recorridos distintos "
                +"\n2. Los enunciado no los recibe a traves de algun input del main, unicamente atraves del archivo de texto "
                +"\n3. El diccionario igualmente viene del archivo de txt bajo el siguiente formato:"
                +"\n\tpalabra_en_ingles,palabra_en_español,palabra_en_frances");
        System.out.println("\n\nPresiones la tecla \"A\" y luego enter para iniciar");
        escribe.nextLine();
        while(true){
            System.out.println("¿Qué desea hacer?" +
                    "\n1. Mostrar recorrido de arbol" +
                    "\n2. Probar traduccion" +
                    "\n (ingrese el indice de la opcion)");
            try{
            opcionAux=escribe.nextInt();}
            catch (Exception e){
                System.out.println("no valido");
            }
            opcion=(opcionAux==1)?"1":(opcionAux==2)?"2":"opcion invalida";
            switch (opcion){
                case"1":
                {
                    con.muestraRecorridosInOrder();

                    break;
                }
                case"2":{
                    String IdiomaOrigen;
                    int NumindiceIdiomaOrigen=0;
                    String IdiomaDestino;
                    int NumindiceIdiomaDestino=0;
                    System.out.println("Ingrese el indice del idioma del que quiere traducir\n1.Ingles\n2.Español\n3.Frances");
                    try{
                        NumindiceIdiomaOrigen=escribe.nextInt();}
                    catch (Exception e){
                        System.out.println("no valido");
                    }
                    IdiomaOrigen=(NumindiceIdiomaOrigen==1)?"English":(NumindiceIdiomaOrigen==2)?"Spanish":(NumindiceIdiomaOrigen==3)?"French":"no valido";
                    System.out.println("Ingrese el indice del idioma al que quiere traducir\n1.Ingles\n2.Español\n3.Frances");
                    try{
                        NumindiceIdiomaDestino=escribe.nextInt();}
                    catch (Exception e){
                        System.out.println("no valido");
                    }
                    IdiomaDestino=(NumindiceIdiomaDestino==1)?"English":(NumindiceIdiomaDestino==2)?"Spanish":(NumindiceIdiomaDestino==3)?"French":"no valido";
                    System.out.println(con.traduceme(IdiomaOrigen, IdiomaDestino));


                    break;
                }
                default:
                    System.out.println("Ingrese un indice valido");

            }
            System.out.println("Desea salir del menu y finalizar el programa (S/N) [si ya presiono enter y el input persiste vuelva a inidicar su decision por favor]");
            escribe.nextLine();
            opcSalir=escribe.nextLine();
            if(opcSalir.equals("S")||opcSalir.equals("s")) break;

        }
    }
}
