package clases;

import java.util.ArrayList;

public class Portero extends Jugador {

	protected int estirda;
	protected int reflejos;
	protected int parada;
	protected int velocidad;
	protected int posicionamiento;
	protected int saque;
	
	
	public Portero(int ID, String nombre, String apellido, Posicion posicion, Elemento elemento, String[] superTecnicas,
			String equipo, Temporada temporada, int media, ArrayList<Integer> estadisticas, boolean capitan,
			int qumica) {
		super(ID, nombre, apellido, posicion, elemento, superTecnicas, equipo, temporada, media, estadisticas, capitan, qumica);
	}
	
	public Portero(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public int getEstirda() {
		return estirda;
	}

	public void setEstirda(int estirda) {
		this.estirda = estirda;
	}

	public int getReflejos() {
		return reflejos;
	}

	public void setReflejos(int reflejos) {
		this.reflejos = reflejos;
	}

	public int getParada() {
		return parada;
	}

	public void setParada(int parada) {
		this.parada = parada;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getPosicionamiento() {
		return posicionamiento;
	}

	public void setPosicionamiento(int posicionamiento) {
		this.posicionamiento = posicionamiento;
	}

	public int getSaque() {
		return saque;
	}

	public void setSaque(int saque) {
		this.saque = saque;
	}
	
	
}
