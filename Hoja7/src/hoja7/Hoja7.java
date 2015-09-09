/*
 * Hoja de trabajo 7 
 * Arboles Binarios
 * Juan Diego Benitez - 14124
 * Daniela Pocasangre - 14612
 * Diccionario ingles a espaniol.
 */

package hoja7;


import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela Pocasangre, Juan Diego Benitez
 */
public class Hoja7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         boolean hacer = true;
         File file = new File("diccionario.txt");
         int contador = 0;
         int lines = 0;

         try {
             BufferedReader br2 = new BufferedReader(new FileReader(file));
             lines = 0;
             while (br2.readLine() != null) lines++;
             br2.close();
         }
         catch (IOException e){

         }
        String palabras[][] = new String[lines][2];
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                for(String line; (line = br.readLine()) != null; ){
                    StringBuilder buildpalabrain = new StringBuilder();
                    StringBuilder buildpalabraes = new StringBuilder();
                    boolean idioma = true; //Si esta en true, significa que es una palabra en ingles. Si esta en false, es una palabra en espanol.

                    for (int x = 1; x<line.length()-1; x++){ //inicia en x = 1 y termina en largo-1 porque el primero y el ultimo son parentesis
                        if (line.charAt(x) != 44){
                            if (idioma==true){ //se obtiene char por char para formar palabra
                                char c = line.charAt(x);
                                buildpalabrain.append(c);
                            }
                            if (idioma==false){
                                char c = line.charAt(x);
                                buildpalabraes.append(c);
                            }
                        }
                        if (line.charAt(x) == 44){
                            //Si es una coma, se cambia el idioma a espanol porque la palabra que sigue es la traduccion.
                            idioma = false;
                        }
                        else {
                            //Si es un espacio, no se agrega
                        }
                    }
                    String palabrain = buildpalabrain.toString();
                    String palabraes = buildpalabraes.toString();

                    palabras[contador][1] = palabrain; //agregan palabras en array que contiene en espaniol e ingles
                    palabras[contador][0] = palabraes;
                    contador++;
                }
            }
            catch(IOException ex) {
                Logger.getLogger(Hoja7.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	catch(FileNotFoundException ex) {
            Logger.getLogger(Hoja7.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Map arreglo[] = new TreeMap[contador]; //se crea un map con cada una de las palabras
        
        for(int y=0; y<contador; y++){
            arreglo[y] = new TreeMap();
            arreglo[y].put(palabras[y][0], palabras[y][1]); //se agregan las palabras al maps
        }
        
        //se crea la raiz del arbol
        System.out.println("--");
        BinaryTree<Map>[] hojastree; //se crean hojas con el numero de palabras restantes
        hojastree = new BinaryTree[contador];
        BinaryTree<Map> root = new BinaryTree<>(arreglo[0]);
        
        for(int t=1;t<contador;t++){
            hojastree[t] = new BinaryTree(arreglo[t]);
            root.insertar(root,hojastree[t]);
        } 
        
        System.out.println("Palabras Ordenadas:");
        root.inOrder(root);
        
        System.out.println("\n Texto Traducido \n");
        
        //Segundo reader
        File archivo = new File("texto.txt");
        int contadorpal = 0;
        StringBuilder buildpalabra = new StringBuilder();
        try{
            BufferedReader br2 = new BufferedReader(new FileReader(archivo));
            try {
                for(String line; (line = br2.readLine()) != null; ){
                    for (int x = 0; x<line.length(); x++){
                        
                        if (line.charAt(x)!= 32){ //si todavia no se ha llegado a un enter, se forma la palabra
                            char d = line.charAt(x);
                            buildpalabra.append(d);
                            contadorpal++;
                        }
                        
                        if ((line.charAt(x) == 32) && contadorpal>0){
                            //mandamos la palabra
                            String palabramandada = buildpalabra.toString();
                            String busqueda = root.buscar(root, palabramandada);
                            buildpalabra = new StringBuilder(); //Reseteamos el StringBuilder

                            if (busqueda == null){
                                System.out.print(" *" + palabramandada + "* "); //si no se tiene la traduccion, se imprime palabra en ingles
                            }
                            else {
                                System.out.print(" "+busqueda+" "); //si se tiene la traduccion, se imprime palabra en espaniol
                            }
                            contadorpal = 0;
                        }
                        if( (x == (line.length()-1)) && (line.charAt(line.length()-1) != 32)){ //utilizado para la palabra al final de la oracion
                            String palabramandada = buildpalabra.toString();
                            String busqueda = root.buscar(root, palabramandada);
                            if (busqueda == null){
                                System.out.print(" *" + palabramandada + "* ");
                            }
                            else {
                                System.out.print(" "+busqueda+" ");
                            }
                            buildpalabra = new StringBuilder(); //Reseteamos el StringBuilder
                        }
                        
                    }
                    System.out.println();
                }
            }
            catch(IOException ex) {
                Logger.getLogger(Hoja7.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	catch(FileNotFoundException ex) {
            Logger.getLogger(Hoja7.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}