package m1miage;
import java.io.*;
 
public class Exercice1a {
	
	public static void main(String[] args) {
		File fichier = new File(".");	
		Exercice1a Ex1 = new Exercice1a();
		Ex1.question1a(fichier);
		Ex1.question2a(fichier);
		String flter = ".class";
		filtre EX1C = new filtre(flter);
//Le filtre ne fonctionne pas correctement
		//EX1C.filtreDossier(fichier, EX1C.ext);
		
	}
	
	public void question1a(File fichier) {
		String[] fichiers1 = fichier.list(); 
		for (String fichierQ1 : fichiers1) {
			System.out.println(fichierQ1);
		}
	}
	
	public void question2a(File fichier) {
		File []  fichiers2 = fichier.listFiles();
		for (File fichierQ21 : fichiers2) {
			System.out.println(fichierQ21);
			if (fichierQ21.isDirectory()) {
				question2a(fichierQ21);
			}
		}
	}
	
	class filterNameInterne implements FilenameFilter {
		protected String ext;

        public filterNameInterne(String ext) {
            this.ext = ext.toLowerCase();
        }

        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(ext);
        }
    }
	
	public void filtreDossier(File dossier, String filtre) {
		if(!dossier.exists()) {
			System.out.println(dossier.getName() + "Le dossier n'existe pas");
		}
		
		//Classe interne
		File [] fichier = dossier.listFiles(new filterNameInterne(filtre));
	
		for (File f : dossier.listFiles()) {
			if (f.isDirectory()) {
				filtreDossier(f, filtre);
			}
		}
		
		if (fichier.length == 0) {
			System.out.println(dossier.getName() +"n'a pas de fichier pr�fix� par" + filtre);
		} else {
			for (File f : fichier) {
				System.out.println(dossier.getName()+"/"+f.getName());
			}
		}
	}
	
}
  