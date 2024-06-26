package ejercicios;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
// Ejercicio 1
public class ej1 {
   private static String DIREC = "C:\\Users\\antonio";
   private static String FILE_INFO_DIRECTION = "Act1.1\\carpetas.txt";
// Método main
   public static void main(String[] args) {
      // Creamos el fichero
	   File fichero = new File(FILE_INFO_DIRECTION);
	   // Obtenemos las direcciones del fichero
	   String[] directions = getData(fichero);
      for (int i = 0; i < directions.length; i++) {
         fichero = new File(DIREC + "\\" + directions[i]);
         createDir(fichero);
      }
   }

   private static String[] getData(File fichero) {
      String[] listDirec = new String[1];
      try (Scanner scan = new Scanner(fichero)) {
         int arrayCursor = 0;
         while (scan.hasNextLine()) {
            listDirec[arrayCursor] = scan.nextLine();
            arrayCursor++;
            if (scan.hasNextLine()) {
               listDirec = Arrays.copyOf(listDirec, listDirec.length + 1);
            }
         }
      } catch (FileNotFoundException e) {
         System.out.println("Fichero no encontrado");
      }
      return listDirec;
   }

   private static void createDir(File fichero) {
      if (!fichero.exists()) {
         fichero.mkdir();
      }
   }
}
