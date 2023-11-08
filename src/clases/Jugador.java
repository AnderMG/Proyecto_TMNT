package clases;

import java.util.ArrayList;

public class Jugador extends Persona {
	private static Posicion posicion;
	private static Elemento elemento;
	private static String[] superTecnicas;
	private static String equipo;
	private static Temporada temporada;
	private static int media;
	private boolean capitan;
	
	public Jugador(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public Jugador(String nombre, String apellido, Posicion posicion, Elemento elemento, String[] superTecnicas,
			String equipo, Temporada temporada, int media, ArrayList<Integer> estadisticas, boolean capitan) {
		super(nombre, apellido);
		Jugador.posicion = posicion;
		Jugador.elemento = elemento;
		Jugador.superTecnicas = superTecnicas;
		Jugador.equipo = equipo;
		Jugador.temporada = temporada;
		Jugador.media = media;
		this.capitan = false;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		Jugador.posicion = posicion;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		Jugador.elemento = elemento;
	}

	public String[] getSuperTecnicas() {
		return superTecnicas;
	}

	public void setSuperTecnicas(String[] superTecnicas) {
		Jugador.superTecnicas = superTecnicas;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		Jugador.equipo = equipo;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public int getMedia() {
		return media;
	}

	public void setMedia(int media) {
		Jugador.media = media;
	}

	public boolean isCapitan() {
		return capitan;
	}

	public void setCapitan(boolean capitan) {
		this.capitan = capitan;
	}
	
	
	
}
