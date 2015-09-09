/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniela
 */
public class Hoja7Test {
    
    public Hoja7Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Hoja7.
     */
    @Test
    public void testInsert() {
        Map arreglo[] = new TreeMap[3]; //se crea un map con cada una de las palabras
        
        String palabrain = "star";
        String palabraesp = "estrella";
        String palabrainL = "dog";
        String palabraespL = "perro";
        String palabrainLL = "pillow";
        String palabraespLL = "almohada";
        
        arreglo[0] = new TreeMap();
        arreglo[0].put(palabraesp,palabrain);
        
        arreglo[1] = new TreeMap();
        arreglo[1].put(palabraespL,palabrainL);
        
        arreglo[2] = new TreeMap();
        arreglo[2].put(palabraespLL, palabrainLL);
        
        //se crea la raiz del arbol
        System.out.println("--");
        BinaryTree<Map>[] hojastree; //se crean hojas con el numero de palabras restantes
        hojastree = new BinaryTree[2];
        BinaryTree<Map> root = new BinaryTree<>(arreglo[0]);
        
        hojastree[0] = new BinaryTree(arreglo[1]);
        hojastree[1] = new BinaryTree(arreglo[2]);
        boolean expResult = true;
        
        boolean result = root.insertar(root,hojastree[0]);
        root.insertar(root,hojastree[1]);
        if (expResult == true){
            System.out.println("Prueba con exito. expResult: " + expResult + " result: " + result);
            System.out.println("Objetos en el arbol: ");
            root.inOrder(root);
        }
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testSearch() {
        
        
        Map arreglo[] = new TreeMap[3]; //se crea un map con cada una de las palabras
        
        String palabrain = "cat";
        String palabraesp = "gato";
        String palabrainL = "dog";
        String palabraespL = "perro";
        String palabrainLL = "star";
        String palabraespLL = "estrella";
        
        arreglo[0] = new TreeMap();
        arreglo[0].put(palabraesp,palabrain);
        
        arreglo[1] = new TreeMap();
        arreglo[1].put(palabraespL,palabrainL);
        
        arreglo[2] = new TreeMap();
        arreglo[2].put(palabraespLL,palabrainLL);
        
        
        //se crea la raiz del arbol
        System.out.println("--");
        BinaryTree<Map>[] hojastree; //se crean hojas con el numero de palabras restantes
        hojastree = new BinaryTree[2];
        BinaryTree<Map> root = new BinaryTree<>(arreglo[1]);
        
        hojastree[0] = new BinaryTree(arreglo[0]);
        hojastree[1] = new BinaryTree(arreglo[2]);
        root.insertar(root,hojastree[0]);
        root.insertar(root,hojastree[1]);              
        
        String palabra = "computer";
        String expResult = null; //Que no se encuentra en el arbol
        
        String result = root.buscar(root, palabra);
       // System.out.println("expResult: " + expResult);
        //System.out.println("Result: " + result);


        assertEquals(expResult, result);        
    }
    
}
