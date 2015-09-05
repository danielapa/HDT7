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
                            if (idioma==true){
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
                    palabras[contador][0] = palabrain;
                    palabras[contador][1] = palabraes;
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
        
        Map arreglo[] = new TreeMap[contador];
        
        for (int x = 0; x<contador; x++){
            arreglo[x] = new TreeMap();
        }
        
        for(int y=0; y<contador; y++){
            arreglo[y].put(palabras[y][0], palabras[y][1]);
            System.out.println("\t" + arreglo[y]);
                    
            if(contador==0){

            }
            else if(contador!=0){

            }
        }

        BinaryTree<Map> root = new BinaryTree<>(arreglo[0]);
        System.out.println("--");

        for(int t=0; t<contador; t++){
            arreglo[t].put(palabras[t][0], palabras[t][1]);

            System.out.println("\t" + arreglo[t]);
                    
            if(contador==0){

            }
            else if(contador!=0){
                BinaryTree<Map> tree1 = new BinaryTree<>(arreglo[t]);
                root.setLeftChild(tree1);
            }
        }        
        /*setRightChild();
        root.print();*/
    }
}
