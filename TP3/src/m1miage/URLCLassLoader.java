package m1miage;

import java.net.*;

public class URLCLassLoader {

	public static void main(String[] args) {
	  try {
	  	  URL[] urlFile= new URL[]{new URL("file:///C:/Users/diazg/eclipse-workspace/TP3 - Test/")};
	      URLClassLoader urlLoader ;
          urlLoader = new URLClassLoader(urlFile);
          urlLoader.loadClass("m1miage.test");
      } catch (MalformedURLException e) {
          e.printStackTrace();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
	  }
    }
	
}
	

