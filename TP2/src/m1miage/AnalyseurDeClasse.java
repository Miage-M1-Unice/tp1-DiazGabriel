package m1miage;
import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse {

  public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
    // R�cup�ration d'un objet de type Class correspondant au nom pass� en param�tres
    Class cl = getClasse(nomClasse);

    afficheEnTeteClasse(cl);

    System.out.println();
    afficheAttributs(cl);

    System.out.println();
    afficheConstructeurs(cl);

    System.out.println();
    afficheMethodes(cl);

    // L'accolade fermante de fin de classe !
    System.out.println("}");
  }


  /** Retourne la classe dont le nom est pass� en param�tre */
  public static Class getClasse(String nomClasse) throws ClassNotFoundException {
    //Class c1 = Class.forName(nomClasse);
	//Class c1 = String.class;
	Class c1 = new String(nomClasse).getClass();
    
    return(c1);
  }

  /** Cette m�thode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
  public static void afficheEnTeteClasse(Class cl) {
	String entete;
    //  Affichage du modifier et du nom de la classe
	int i = cl.getModifiers();
	entete = Modifier.toString(i);
    entete += cl.getName();
   // R�cup�ration de la superclasse si elle existe (null si cl est le type Object)
    Class supercl = cl.getSuperclass();

    // On ecrit le "extends " que si la superclasse est non nulle et
    // diff�rente de Object
    if (supercl != null  && supercl !=  cl) {
    	entete += " extends " + supercl.toString();
    }

    // Affichage des interfaces que la classe implemente
    Class[] interfaces = cl.getInterfaces(); 

    if (interfaces.length != 0) {
    	entete += " implements ";
    	for (int j=0; j<interfaces.length; j++) {
    		entete += interfaces[j].toString();
    	}
    }
    
    System.out.println(entete);
    // Enfin, l'accolade ouvrante !
    System.out.print(" {\n");
  }

  public static void afficheAttributs(Class cl) {
    Field[] champs = cl.getFields();
    
    if (champs.length == 0) {
    	System.out.println("Cette classe ne contient pas d'attribut");
    } else {
    	System.out.println("Liste des attributs :");
    	for(int i=0; i<champs.length; i++) {
    		if (champs[i].getName() != champs[i-1].getName()) {
    			System.out.println(champs[i].getName());
    		}
    	}
    }
  }

  public static void afficheConstructeurs(Class cl) {
    Constructor[] constructeurs = cl.getConstructors();
    
    if (constructeurs.length == 0) {
    	System.out.println("Cette classe ne contient pas de constructeurs");
    } else { 
    	System.out.println("Liste des constructeurs :");
    	for(int i=0; i< constructeurs.length; i++) {
    		if (constructeurs[i].getName() != constructeurs[i-1].getName()) {
        		System.out.println(constructeurs[i].getName());
    		}
    	}
    }
  }
  
  public static void afficheMethodes(Class cl) {
    Method[] methodes = cl.getMethods();
    
    if (methodes.length == 0) {
    	System.out.println("Cette classe ne contient m�thode");
    } else {
    	System.out.println("Liste des m�thodes :");
    	for(int i=0; i< methodes.length; i++) {
    		if (methodes[i].getName() != methodes[i-1].getName()) {
    			System.out.println(methodes[i].getName());
    		}
    	}
    }
  }

  public static String litChaineAuClavier() throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return br.readLine();
  }

  public static void main(String[] args) {
    boolean ok = false;

    while(!ok) {
      try {
        System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
        String nomClasse = litChaineAuClavier();
        
        AnalyseurDeClasse.analyseClasse(nomClasse);

        ok = true;
      } catch(ClassNotFoundException e) {
        System.out.println("Classe non trouv�e.");
      }catch(IOException e) {
        System.out.println("Erreur d'E/S!");
      }
    }
  }
}