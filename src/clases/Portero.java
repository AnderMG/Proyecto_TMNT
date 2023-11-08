package clases;

import java.util.ArrayList;

public class Portero extends Jugador {

	private static int estirda;
	private static int reflejos;
	private static int parada;
	private static int velocidad;
	private static int posicionamiento;
	private static int saque;
	
	public Portero(String nombre, String apellido, Posicion posicion, Elemento elemento, String[] superTecnicas,
			String equipo, Temporada temporada, int media, ArrayList<Integer> estadisticas, boolean capitan) {
		super(nombre, apellido, posicion, elemento, superTecnicas, equipo, temporada, media, estadisticas, capitan);
		
	}



	public static int getEstirda() {
		return estirda;
	}

	public static void setEstirda(int estirda) {
		Portero.estirda = estirda;
	}

	public static int getReflejos() {
		return reflejos;
	}

	public static void setReflejos(int reflejos) {
		Portero.reflejos = reflejos;
	}

	public static int getParada() {
		return parada;
	}

	public static void setParada(int parada) {
		Portero.parada = parada;
	}

	public static int getVelocidad() {
		return velocidad;
	}

	public static void setVelocidad(int velocidad) {
		Portero.velocidad = velocidad;
	}

	public static int getPosicionamiento() {
		return posicionamiento;
	}

	public static void setPosicionamiento(int posicionamiento) {
		Portero.posicionamiento = posicionamiento;
	}

	public static int getSaque() {
		return saque;
	}

	public static void setSaque(int saque) {
		Portero.saque = saque;
	}

		
}
