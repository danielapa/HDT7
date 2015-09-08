/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja7;


import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela
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
             System.out.println("Largo del archivo: " + lines + "\n");
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
                    System.out.println("Linea leida: " + line);
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
                    //Imprimimos las palabras
                    System.out.println("Palabra en ingles: " + palabrain);
                    System.out.println("Palabra en espanol: " + palabraes);
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
            arreglo[y].put(palabras[y][0], palabras[y][1]);
            System.out.println("\t" + arreglo[y]);
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
        
        System.out.println("############");
        root.inOrder(root);
        System.out.println("############");
        
        String oracion[] = new String[3]; //palabras de la oracion que se tiene en el archivo
        int contadororacion=3; //numero de palabras que se tienen
        for(int t=0;t<contadororacion;t++){
           root.buscar(oracion[t]);
        }         
        
        root.print();
    }
}
