package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Elemento;
import clases.JugaCampo;
import clases.Posicion;
import clases.Temporada;

public class LeerJugadorCampo {
	static ArrayList<JugaCampo> listaJugadoresCampo = new ArrayList<>();
	
	public static ArrayList<JugaCampo> leerJugaCampo(String nombreArchivo){
		File archivo = new File(nombreArchivo);
		Scanner sc;
		try {
			sc = new Scanner(archivo);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				if (campos.length == 6) {
					JugaCampo jugador = new JugaCampo(campos[4], null, Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[5]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresCampo.add(jugador);
				}else {
					JugaCampo jugador = new JugaCampo(campos[4], campos[5], Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[6]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresCampo.add(jugador);
				}
				
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		return listaJugadoresCampo;
	}
	
}
