package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class EscribirFichero {
	
	public static void agregarUsuario(String nombreUsuario, String password, String nombreCompleto, int edad) throws IOException {
        int id = utils.LeerFichero.obtenerUltimoId()+1;
        String id_string = id+"";
        BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.txt", true));
        writer.write(id_string + ";" + nombreUsuario + ";" + password + ";" + nombreCompleto + ";" + edad);
        writer.newLine();
        writer.close();
    }
	
	public static void eliminarUsuario(int idUsuario) {
	    File inputFile = new File("Usuarios.txt");
	    File tempFile = new File("temp.txt");
	
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	
	        String linea;
	
	        while ((linea = reader.readLine()) != null) {
	            String[] datos = linea.split(";");
	            int usuarioSeleccionado = Integer.parseInt(datos[0]);
	
	            if (usuarioSeleccionado != idUsuario) {
	                writer.write(linea);
	                writer.newLine();
	            }
	        }
	
	        writer.close();
	        reader.close();

	        if (inputFile.delete()) {
	            if (!tempFile.renameTo(inputFile)) {
	                throw new IOException("Error al renombrar el archivo temporal");
	            }
	        } else {
	            throw new IOException("Error al eliminar el archivo de entrada");
	        }
	
	        JOptionPane jp = new JOptionPane();
	        JOptionPane.showMessageDialog(jp, "Usuario eliminado correctamente");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}