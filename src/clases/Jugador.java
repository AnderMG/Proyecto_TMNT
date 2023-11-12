package clases;

import java.util.ArrayList;

public class Jugador extends Persona {
	protected static Posicion posicion;
	protected static Elemento elemento;
	protected static String[] superTecnicas;
	protected static String equipo;
	protected static Temporada temporada;
	protected static int media;
	protected static boolean capitan;
	protected static int quimica;
	
	
	public Jugador(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public Jugador(String nombre, String apellido, Posicion posicion, Elemento elemento, String[] superTecnicas,
			String equipo, Temporada temporada, int media, ArrayList<Integer> estadisticas, boolean capitan, int qumica) {
		super(nombre, apellido);
		Jugador.posicion = posicion;
		Jugador.elemento = elemento;
		Jugador.superTecnicas = superTecnicas;
		Jugador.equipo = equipo;
		Jugador.temporada = temporada;
		Jugador.media = media;
		Jugador.capitan = false;
		Jugador.quimica = qumica;
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
		Jugador.temporada = temporada;
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
		Jugador.capitan = capitan;
	}

	public static int getQuimica() {
		return quimica;
	}

	public static void setQuimica(int quimica) {
		Jugador.quimica = quimica;
	}
	
	
	
}
