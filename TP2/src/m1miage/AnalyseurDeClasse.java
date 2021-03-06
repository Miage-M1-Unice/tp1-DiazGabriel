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
    return Class.forName(nomClasse);
  }

  /** Cette m�thode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
  public static void afficheEnTeteClasse(Class cl) {
	String entete;
    //  Affichage du modifier et du nom de la classe
	int i = cl.getModifiers();
	entete = Modifier.toString(i);
	entete += " class "; 
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
    		if (j<interfaces.length-1) {
    			entete += " ,";
    		}
    	}
    }
    entete += " {";    
    System.out.println(entete);
  }

  public static void afficheAttributs(Class cl) {
    Field[] champs = cl.getDeclaredFields();
    int fieldsModifier;
    String displayChamp;
    
    if (champs.length == 0) {
    	System.out.println("*****Cette classe ne contient pas de champs*****");
    } else {
    	System.out.println("*****Champs*****");
    	for(int i=0; i<champs.length; i++) {
    		fieldsModifier = champs[i].getModifiers();
    		displayChamp = Modifier.toString(fieldsModifier) +" "+ champs[i].getType() +" "+ champs[i].getName();
    		displayChamp += ";";
        	System.out.println(displayChamp); 
    	}
    	   
    }
  }

  public static void afficheConstructeurs(Class cl) {
    Constructor[] constructeurs = cl.getDeclaredConstructors();
    int constructorModifier;
    String displayConstructeur;
    
    if (constructeurs.length == 0) {
    	System.out.println("*****Cette classe ne contient pas de constructeurs*****");
    } else { 
    	System.out.println("*****Liste des constructeurs*****");
    	for(int i=0; i< constructeurs.length; i++) {
    		constructorModifier = constructeurs[i].getModifiers();
    		Parameter[] parametres = constructeurs[i].getParameters();
    		displayConstructeur = Modifier.toString(constructorModifier) +" "+ constructeurs[i].getName();
    		if (parametres.length != 0) {
				displayConstructeur += "(";
    			for(int j=0; j<parametres.length; j++) {
    				displayConstructeur += parametres[j].getParameterizedType();
    				if (j<parametres.length-1) {
    					displayConstructeur += ", ";
    				}
    			}
    			displayConstructeur += ")";
    		} else {
    			displayConstructeur += "()";
    		}
    		displayConstructeur += ";";
    		System.out.println(displayConstructeur);
    	}
    }   	
 }
  
  public static void afficheMethodes(Class cl) {
    Method[] methodes = cl.getDeclaredMethods();
    int methodModifier;
    String displayMethode;
    
    if (methodes.length == 0) {
    	System.out.println("*****Cette classe ne contient m�thode*****");
    } else {
    	System.out.println("*****Liste des m�thodes*****");
    	for(int i=0; i< methodes.length; i++) {
    		methodModifier = methodes[i].getModifiers();
    		Parameter[] parametres = methodes[i].getParameters();
    		displayMethode = Modifier.toString(methodModifier) +" "+ methodes[i].getGenericReturnType() +" "+ methodes[i].getName();
    		if (parametres.length != 0) {
				displayMethode += "(";
    			for(int j=0; j<parametres.length; j++) {
    				displayMethode += parametres[j].getParameterizedType();
    				if (j<parametres.length-1) {
    					displayMethode += ", ";
    				}
    			}
    			displayMethode += ")";
    		} else {
    			displayMethode += "()";
    		}
    		displayMethode +=";";
    		System.out.println(displayMethode);
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
        
        analyseClasse(nomClasse);

        ok = true;
      } catch(ClassNotFoundException e) {
        System.out.println("Classe non trouv�e.");
      }catch(IOException e) {
        System.out.println("Erreur d'E/S!");
      }
    }
  }
}