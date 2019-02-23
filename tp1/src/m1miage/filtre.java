package m1miage;
import java.io.*;

public class filtre implements FilenameFilter {
	protected String ext;
	
	public filtre(String ext) {
		this.ext = ext.toLowerCase();
	}
	
	public boolean accept(File dossier, String nom) {
		return nom.toLowerCase().endsWith(ext);
	}
	
	public String toString() {
		return "filtre[ext="+ext+"]";
	}
}
