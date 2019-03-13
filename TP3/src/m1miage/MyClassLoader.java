package m1miage;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureClassLoader;
import java.util.ArrayList;

public class MyClassLoader extends SecureClassLoader {
    private ArrayList<File> path = null;

    public MyClassLoader(ArrayList<File> p) {
        this.path = p;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = new byte[0];
        return super.defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) throws ClassNotFoundException, IOException {
        File f = new File(name);
        DataInputStream input = new DataInputStream(new FileInputStream(f));
        byte[] content = new byte[(int)f.length()];
        input.readFully(content);
        return content;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ArrayList<File> al = new ArrayList<File>();
        al.add(new File("File:///C:/Users/diazg/eclipse-workspace/m1miage.test"));
        MyClassLoader myCL = new MyClassLoader(al);
        try {  
        	myCL.loadClass("m1miage.test");  
        } catch (ClassNotFoundException e) {  
        	e.printStackTrace();  
        }  
    }  
}