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
        
        
        /*String leol = "shoe";
        String coso = root.buscar(root, leol);
        System.out.println(coso);
        if (coso == null){
            System.out.print("*" + leol + "*");
        }
        else {
            System.out.print(leol);
        }
        
        System.out.println("---------");
        leol = "air";
        coso = root.buscar(root, leol);
        System.out.println(coso);
        if (coso == null){
            System.out.print("*" + leol + "*");
        }
        else {
            System.out.print(leol);
        }
        */
        root.print();
        
        System.out.println("\n Traductada \n");
        
        //Segundo reader
        File archivo = new File("texto.txt");
        int contadorpal = 0;
        StringBuilder buildpalabra = new StringBuilder();
        try{
            BufferedReader br2 = new BufferedReader(new FileReader(archivo));
            try {
                for(String line; (line = br2.readLine()) != null; ){
                    for (int x = 0; x<line.length(); x++){
                       // System.out.println("Last char: " + line.charAt(line.length()-1));
                        //System.out.println(line);
                        
                        //contadorpal = 0;
                        if (line.charAt(x)!= 32){
                            char d = line.charAt(x);
                            buildpalabra.append(d);
                            //System.out.println(d);
                            contadorpal++;
                        }
                        
                        if ((line.charAt(x) == 32) && contadorpal>0){
                            //System.out.println("espacio");
                            //mandamos la palabra
                            String palabramandada = buildpalabra.toString();
                            //System.out.print("Palabra mandada: " + palabramandada + " ");
                            //System.out.println("Palabra mandada: " + palabramandada);
                            String busqueda = root.buscar(root, palabramandada);
                           //System.out.println("Busqueda " + busqueda);
                            if (busqueda == null){
                                System.out.print("*" + palabramandada + "*");
                            }
                            else {
                                System.out.print(busqueda);
                            }
                            buildpalabra = new StringBuilder();
                            contadorpal = 0;
                        }
                        if( (x == (line.length()-1)) && (line.charAt(line.length()-1) != 32)){
                            String palabramandada = buildpalabra.toString();
                            String busqueda = root.buscar(root, palabramandada);
                            if (busqueda == null){
                                System.out.print("*" + palabramandada + "*");
                            }
                            else {
                                System.out.print(busqueda);
                            }
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
