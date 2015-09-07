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
public class Palabra extends TreeMap implements Comparable<Palabra>{

    String llave, word;
    
    @Override
    public Object put(Object key, Object value) {
        llave = (String)(Object)key;
        return super.put(key, value); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Object key) {
        return super.get(key); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int compareTo(String word) {
        return llave.compareTo(word);
    }

    @Override
    public int compareTo(Palabra o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
