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
        try{
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    try {
                        for(String line; (line = br.readLine()) != null; ){
                            System.out.println("Palabra leida: " + line);
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
        arreglo[0].put("jelly", "gelatina");
        System.out.print("\t" + arreglo[0]);
        BinaryTree<Map> tree = new BinaryTree<Map>(arreglo[0]);

    }
    
}
