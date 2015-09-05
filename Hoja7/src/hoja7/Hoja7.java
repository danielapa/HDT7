/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja7;


import java.util.*;

/**
 *
 * @author Daniela
 */
public class Hoja7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map palabras = new TreeMap();
        palabras.put("word", "palabra");
        System.out.print("\t" + palabras);
        
        BinaryTree<Map> tree = new BinaryTree<Map>(palabras);

    }
    
}
