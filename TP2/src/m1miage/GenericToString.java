package m1miage;
import java.lang.reflect.*;
import java.io.*;
import java.awt.*;

public class GenericToString {

	public static void getBounds() {
		
	}
	
	
	static public void main(String[] args) {  
		System.out.println(new GenericToString().toString(new Point(12,24)));  
		  
		Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);  
		pol.getBounds();  
		System.out.println(new GenericToString().toString(pol, 2));  
	} 
	
}
