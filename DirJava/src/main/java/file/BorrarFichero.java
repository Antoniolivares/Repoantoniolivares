package file;

import java.io.File;

public class BorrarFichero {
	public static void main(String[] args) {

	   File fichero = new File("C:\\pruebas","miFichero.txt");
	   if (fichero.exists()) 
	      fichero.delete();
	}
	}
