package utils;

import java.util.ArrayList;
import java.util.HashMap;

import clases.Elemento;
import clases.JugaCampo;
import clases.Jugador;
import clases.Portero;
import clases.Posicion;
import clases.Temporada;

public class CargarJugadores {
	protected static HashMap<Posicion, ArrayList<Jugador>> mapaJugadores = new HashMap<>();
	
	
	public static HashMap<Posicion, ArrayList<Jugador>> CargarMapaJugadores(){
		ArrayList<Portero> listaPorteros = utils.LeerJugadorCampo.leerPorteros(MetodosProperties.lecturaProperties("FicPor"));
		ArrayList<JugaCampo> listaDefensas = utils.LeerJugadorCampo.leerJugaDefensas(MetodosProperties.lecturaProperties("FicDef"));
		ArrayList<JugaCampo> listaMedios = utils.LeerJugadorCampo.leerJugaMediocentros(MetodosProperties.lecturaProperties("FicMed"));
		ArrayList<JugaCampo> listaDelanteros = utils.LeerJugadorCampo.leerJugaDelanteros(MetodosProperties.lecturaProperties("FicDel"));
		
		//Mapeao de porteros//
		if (mapaJugadores.get(Posicion.PORTERO) == null) {
			mapaJugadores.put(Posicion.PORTERO, new ArrayList<Jugador>());
			for (Portero p : listaPorteros) {
				if (p.getApellido() == null) {
					mapaJugadores.get(Posicion.PORTERO).add(new Jugador(p.getNombre(), "", p.getTemporada(), p.getPosicion(), p.getElemento(), p.getMedia()));
				}else {
					mapaJugadores.get(Posicion.PORTERO).add(new Jugador(p.getNombre(), p.getApellido(), p.getTemporada(), p.getPosicion(), p.getElemento(), p.getMedia()));
				}
				
			}
			
		}
		
		//Mapeao de defensas//
		if (mapaJugadores.get(Posicion.DEFENSA) == null) {
			mapaJugadores.put(Posicion.DEFENSA, new ArrayList<Jugador>());
			for (JugaCampo p : listaDefensas) {
				if (p.getApellido() == null) {
					mapaJugadores.get(Posicion.PORTERO).add(new Jugador(p.getNombre(), "", p.getTemporada(), p.getPosicion(), p.getElemento(), p.getMedia()));
				}else {
					mapaJugadores.get(Posicion.PORTERO).add(new Jugador(p.getNombre(), p.getApellido(), p.getTemporada(), p.getPosicion(), p.getElemento(), p.getMedia()));
				}
				
			}
			
		}
		
		
		//Mapeao de medios//
		if (mapaJugadores.get(Posicion.MEDIOCENTRO) == null) {
			mapaJugadores.put(Posicion.MEDIOCENTRO, new ArrayList<Jugador>());
			for (JugaCampo p : listaMedios) {
				if (p.getApellido() == null) {
					mapaJugadores.get(Posicion.PORTERO).add(new Jugador(p.getNombre(), "", p.getTemporada(), p.getPosicion(), p.getElemento(), p.getMedia()));
				}else {
					mapaJugadores.get(Posicion.PORTERO).add(new Jugador(p.getNombre(), p.getApellido(), p.getTemporada(), p.getPosicion(), p.getElemento(), p.getMedia()));
				}
				
			}
			
		}
		
		//Mapeao de delanteros//
		if (mapaJugadores.get(Posicion.DELANTERO) == null) {
			mapaJugadores.put(Posicion.DELANTERO, new ArrayList<Jugador>());
			for (JugaCampo p : listaDelanteros) {
				if (p.getApellido() == null) {
					mapaJugadores.get(Posicion.PORTERO).add(new Jugador(p.getNombre(), "", p.getTemporada(), p.getPosicion(), p.getElemento(), p.getMedia()));
				}else {
					mapaJugadores.get(Posicion.PORTERO).add(new Jugador(p.getNombre(), p.getApellido(), p.getTemporada(), p.getPosicion(), p.getElemento(), p.getMedia()));
				}
				
			}
			
		}
		
		
		return mapaJugadores;
	}
}
