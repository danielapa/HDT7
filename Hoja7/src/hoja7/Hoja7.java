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
        Map arreglo[] = new TreeMap[20];
        arreglo[0] = new TreeMap();
        arreglo[0].put("jelly", "gelatina");
        System.out.print("\t" + arreglo[0]);
        BinaryTree<Map> tree = new BinaryTree<Map>(arreglo[0]);

    }
    
}
