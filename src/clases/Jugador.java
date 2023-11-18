package clases;

import java.util.ArrayList;

public class Jugador extends Persona {
	protected Posicion posicion;
	protected Elemento elemento;
	protected String[] superTecnicas;
	protected String equipo;
	protected Temporada temporada;
	protected int media;
	protected boolean capitan;
	protected int quimica;
	
	
	public Jugador(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public Jugador(String nombre, String apellido, Posicion posicion, Elemento elemento, String[] superTecnicas,
			String equipo, Temporada temporada, int media, ArrayList<Integer> estadisticas, boolean capitan, int qumica) {
		super(nombre, apellido);
		this.posicion = posicion;
		this.elemento = elemento;
		this.superTecnicas = superTecnicas;
		this.equipo = equipo;
		this.temporada = temporada;
		this.media = media;
		this.capitan = false;
		this.quimica = qumica;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public String[] getSuperTecnicas() {
		return superTecnicas;
	}

	public void setSuperTecnicas(String[] superTecnicas) {
		this.superTecnicas = superTecnicas;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
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
		this.media = media;
	}

	public boolean isCapitan() {
		return capitan;
	}

	public void setCapitan(boolean capitan) {
		this.capitan = capitan;
	}

	public int getQuimica() {
		return quimica;
	}

	public void setQuimica(int quimica) {
		this.quimica = quimica;
	}
	
	

	
}
