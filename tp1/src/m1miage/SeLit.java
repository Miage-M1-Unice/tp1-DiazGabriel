package m1miage;

import java.io.*;
import java.util.*;

public class SeLit {
	    static public void main(String[] args) {   
	    	try {
	    		SeLit source = new SeLit();
	    		Scanner path = new Scanner(new File("./src/m1miage/SeLit.java"));
	    		source.lecture(path);
	    	} catch	(FileNotFoundException e) {
	    		System.err.println("Fichier non trouvé");
	    	}
	    }
	
	void lecture(Scanner source) {  	  
		while(source.hasNextLine()) {  
			String s = source.nextLine();          
			//System.out.println("LU:"+s);  
	        System.out.println(s);
		}  
	}
	
}
