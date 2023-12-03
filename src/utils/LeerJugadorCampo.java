package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Elemento;
import clases.JugaCampo;
import clases.Portero;
import clases.Posicion;
import clases.Temporada;

public class LeerJugadorCampo {
	public static ArrayList<JugaCampo> listaJugadoresDefensas = new ArrayList<>();
	public static ArrayList<JugaCampo> listaJugadoresMediocentros = new ArrayList<>();
	public static ArrayList<JugaCampo> listaJugadoresDelanteros = new ArrayList<>();
	public static ArrayList<Portero> listaJugadoresPorteros = new ArrayList<>();
	
	///////////////////////////////////LEER DEFENSAS///////////////////////////////////////////////////
	public static ArrayList<JugaCampo> leerJugaDefensas(String nombreArchivo){
		File archivo = new File(nombreArchivo);
		Scanner sc;
		try {
			sc = new Scanner(archivo);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				if (campos.length == 6) {
					JugaCampo jugador = new JugaCampo((int) Integer.parseInt(campos[0]), campos[4], null, Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[5]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresDefensas.add(jugador);
				}else {
					JugaCampo jugador = new JugaCampo((int) Integer.parseInt(campos[0]), campos[4], campos[5], Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[6]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresDefensas.add(jugador);
				}
				
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		return listaJugadoresDefensas;
	}
	
	////////////////////////LEER MEDIOCENTRO///////////////////////////////////////////////////
	public static ArrayList<JugaCampo> leerJugaMediocentros(String nombreArchivo){
		File archivo = new File(nombreArchivo);
		Scanner sc;
		try {
			sc = new Scanner(archivo);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				if (campos.length == 6) {
					JugaCampo jugador = new JugaCampo((int) Integer.parseInt(campos[0]), campos[4], null, Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[5]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresMediocentros.add(jugador);
				}else {
					JugaCampo jugador = new JugaCampo((int) Integer.parseInt(campos[0]), campos[4], campos[5], Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[6]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresMediocentros.add(jugador);
				}
				
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		return listaJugadoresMediocentros;
	}
	
	/////////////////////////////////LEER DELANTEROS//////////////////////////////////////////////////////////
	public static ArrayList<JugaCampo> leerJugaDelanteros(String nombreArchivo){
		File archivo = new File(nombreArchivo);
		Scanner sc;
		try {
			sc = new Scanner(archivo);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				if (campos.length == 6) {
					JugaCampo jugador = new JugaCampo((int) Integer.parseInt(campos[0]), campos[4], null, Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[5]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresDelanteros.add(jugador);
				}else {
					JugaCampo jugador = new JugaCampo((int) Integer.parseInt(campos[0]), campos[4], campos[5], Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[6]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresDelanteros.add(jugador);
				}
				
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		
		return listaJugadoresDelanteros;
	};
	
	
	///////////////////////////LEER PORTEROS/////////////////////////////////////////
	public static ArrayList<Portero> leerPorteros(String nombreArchivo){
		File archivo = new File(nombreArchivo);
		Scanner sc;
		try {
			sc = new Scanner(archivo);
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(",");
				if (campos.length == 6) {
					Portero portero = new Portero ((int) Integer.parseInt(campos[0]), campos[4], null, Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[5]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresPorteros.add(portero);
				}else {
					Portero portero = new Portero((int) Integer.parseInt(campos[0]), campos[4], campos[5], Posicion.valueOf(campos[2]), Elemento.valueOf(campos[1]), null, null, Temporada.valueOf(campos[3]), Integer.parseInt(campos[6]), null, false, Integer.parseInt(campos[0]));
					listaJugadoresPorteros.add(portero);
				}
				
			}			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		return listaJugadoresPorteros;
	}
}
