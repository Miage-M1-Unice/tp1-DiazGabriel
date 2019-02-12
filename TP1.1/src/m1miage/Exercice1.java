package m1miage;
import java.io.File;
 
public class Exercice1 {
	
	public static void main(String[] args) {
		Exercice1 Ex1 = new Exercice1();
		Ex1.question1();
		Ex1.question2();
	}
	
	public void question1() {
		File fichier1 = new File(".");
		String[] fichiers1 = fichier1.list(); 
		for (String fichierQ1 : fichiers1) {
			System.out.println(fichierQ1);
		}
	}
	
	public void question2() {
		File fichier2 = new File(".");
		File []  fichiers2 = fichier2.listFiles();
		for (File fichierQ2 : fichiers2) {
			System.out.println(fichierQ2);
		}
	}
}  