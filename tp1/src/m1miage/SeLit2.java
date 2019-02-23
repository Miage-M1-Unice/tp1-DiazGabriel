package m1miage;

import java.io.*;
import java.util.*;

public class SeLit2 {
	    static public void main(String[] args) {   
	        try {
	   			System.out.print("Entrez un nom pour le fichier de sortie: ");
	   			String nomFichier = litChaineAuClavier();
	   			File fichier = new File("./" + nomFichier + ".txt") ;
	   			SeLit2 source = new SeLit2();
	   			Scanner path = new Scanner(new File("./src/m1miage/SeLit2.java"));
	   			PrintWriter writer = new PrintWriter(fichier);
	   			source.ecriture(path, writer);
	        } catch	(FileNotFoundException e) {
	        	System.err.println("Fichier non trouvé");
	        } catch(IOException e) {
	            System.out.println("Erreur d'E/S!");
	        }
	    }
	
	
	void ecriture(Scanner source, PrintWriter writer) {
		while(source.hasNextLine()) {  
			String s = source.nextLine();  
			writer.println(s);  
		}
		writer.close();
	}	
	
	 public static String litChaineAuClavier() throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 return br.readLine();
	  }
}