package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import clases.Usuario;

public class LeerFichero {
	
	public static Usuario crearUsuario(String nombreUsuario, String password) throws FileNotFoundException {
        File archivo = new File("Usuarios.txt");
        Scanner scanner = new Scanner(archivo);
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] campos = linea.split(";");
            if (campos.length == 5 && campos[1].equals(nombreUsuario) && campos[2].equals(password)) {
                Usuario usuario = new Usuario(Integer.parseInt(campos[0]), campos[1], campos[2], campos[3], Integer.parseInt(campos[4]));
                scanner.close();
                return usuario;
            }
        }
        scanner.close();
        return null; 
    }
	
	public static ArrayList<Usuario> leerUsuariosDesdeArchivo(String nombreArchivo) throws FileNotFoundException{
		ArrayList<Usuario> usuarios = new ArrayList<>();
		 File archivo = new File(nombreArchivo);
	     Scanner scanner = new Scanner(archivo);

	     while (scanner.hasNextLine()) {
	    	 String[] datos = scanner.nextLine().split(";");
	    	 int id = Integer.parseInt(datos[0]);
	    	 String nombreUsuario = datos[1];
	    	 String contraseña = datos[2];
	    	 String nombreReal = datos[3];
	         int edad = Integer.parseInt(datos[4]);
	         usuarios.add(new Usuario(id,nombreUsuario, contraseña, nombreReal, edad));
	     }
		return usuarios;
		}
	
	public static boolean validarUsuario(String nombreUsuario, String password) throws FileNotFoundException{
        File archivo = new File("Usuarios.txt");
        Scanner scanner = new Scanner(archivo);
        while (scanner.hasNextLine()) {
            String linea = scanner.nextLine();
            String[] campos = linea.split(";");
            if (campos.length == 5 && campos[1].equals(nombreUsuario) && campos[2].equals(password)) {
                scanner.close();
                return true;
            }
        }
        scanner.close();
        return false;
    }
	
	public static int obtenerUltimoId() {
        int ultimoId = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 2) {
                    ultimoId = Integer.parseInt(datos[0]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo.");
            e.printStackTrace();
        }

        return ultimoId;
    }

}
