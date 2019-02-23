package m1miage;

import java.awt.*;
import java.lang.reflect.*;

public class GenericToString {
	
	static public void main(String[] args) throws IllegalAccessException {  
		GenericToString first = new GenericToString();
		System.out.println(first.toString(new Point(12,24), 2));  	
		Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);  
		pol.getBounds();  
		System.out.println(first.toString(pol, 3));  
	} 
            
    public String toString(Object object, int profondeur) throws IllegalAccessException {	
    	String CodeOK = "ok";
    	Class cl = object.getClass();
    	String resultat = cl.getName() + "[";
    	Field[] champ = cl.getDeclaredFields();
    	for (int i = 0; i < champ.length; i++) {
    		champ[i].setAccessible(true);
    		Object objet = champ[i].get(object);
    		resultat += champ[i].getName();
    		resultat += "=";
    		if (objet != null) {
    			if (champ[i].getType().isPrimitive()) {
    				resultat += objet;
    			} else if (champ[i].getType().isArray()) {
    				resultat += "{";
    				for (int j = 0; j < Array.getLength(objet); j++) {
    					resultat += Array.get(objet, j);
    					if (j+1 < Array.getLength(objet)) {
    						resultat += ",";
    					}
    				}
    				resultat += "}";
    			} else {
    				profondeur -= 1;
    				resultat += toString(objet, profondeur);
    			}
    		} else {
    			resultat += "null";
    		}
    		if ((i + 1) != champ.length) {
    			resultat += ";";
    		}
    	}
    	resultat += "]";
    	return resultat;  	
    }
}