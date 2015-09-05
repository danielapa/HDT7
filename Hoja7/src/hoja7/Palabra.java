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
public class Palabra implements Comparable<Palabra>{
    private String ingles;
    private String espan;
    
    public Palabra(String ing, String espa) {
        this.ingles = ing;
        this.espan = espa;

    }  
    
    public String getIngles() {
        return ingles;
    }
    
    public String getEspan() {
        return espan;
    }

    public void setIngles(String ing) {
        this.ingles = ing;
    }
    
    public void setEspan(String espa) {
        this.espan = espa;
    } 
    
    @Override
    public int compareTo(Palabra o) {
        return ingles.compareTo(o.ingles);
    }

}
