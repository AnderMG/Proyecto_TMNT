package utils;

import java.awt.im.InputContext;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.junit.validator.ValidateWith;

public class MetodosProperties {
	private static String archivo = "config.properties";
	
	
	//Metodos de escritura de fichero properties que se hace al inicio del programa//
	public static void escrituraProperties() {
		
		try {
			OutputStream os = new FileOutputStream(archivo);
			Properties propiedades = new Properties();
			
			propiedades.setProperty("nombre.bd", "basedatos.db");
			propiedades.setProperty("FicDef", "Defensas.txt");
			propiedades.setProperty("FicPor", "Porteros.txt");
			propiedades.setProperty("FicMed", "Mediocentros.txt");
			propiedades.setProperty("FicDel", "Delanteros.txt");
			
			propiedades.store(os, archivo);
			
		}catch (IOException e) {
			System.out.println("Error configuracion properties " +e.getMessage() );
		}
		
	}
	
	//Metodo de lectura properties que se usa cuando queremos acceder a los ficheros de base de datos o jugadores//
	public static String lecturaProperties(String claveProperty) {
		
		try {
			InputStream is = new FileInputStream(archivo);
			Properties propiedades = new Properties();
			
			propiedades.load(is);
			
			String valorProperty = propiedades.getProperty(claveProperty);
			return valorProperty;
			
		}catch (IOException e) {
			System.out.println("Error configuracion properties " +e.getMessage() );
		}
		return "";
		
	}

}
