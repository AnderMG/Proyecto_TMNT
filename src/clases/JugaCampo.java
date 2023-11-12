
package clases;

import java.util.ArrayList;

public class JugaCampo extends Jugador {
	
	protected static int ritmo;
	protected static int regate;
	protected static int tiro;
	protected static int defensa;
	protected static int fisico;
	protected static int pase;

	public JugaCampo(String nombre, String apellido, Posicion posicion, Elemento elemento, String[] superTecnicas,
			String equipo, Temporada temporada, int media, ArrayList<Integer> estadisticas, boolean capitan, int quimica) {
		super(nombre, apellido, posicion, elemento, superTecnicas, equipo, temporada, media, estadisticas, capitan, quimica);
		// TODO Auto-generated constructor stub
	}

	public static int getRitmo() {
		return ritmo;
	}

	public static void setRitmo(int ritmo) {
		JugaCampo.ritmo = ritmo;
	}

	public static int getRegate() {
		return regate;
	}

	public static void setRegate(int regate) {
		JugaCampo.regate = regate;
	}

	public static int getTiro() {
		return tiro;
	}

	public static void setTiro(int tiro) {
		JugaCampo.tiro = tiro;
	}

	public static int getDefensa() {
		return defensa;
	}

	public static void setDefensa(int defensa) {
		JugaCampo.defensa = defensa;
	}

	public static int getFisico() {
		return fisico;
	}

	public static void setFisico(int fisico) {
		JugaCampo.fisico = fisico;
	}

	public static int getPase() {
		return pase;
	}

	public static void setPase(int pase) {
		JugaCampo.pase = pase;
	}

}
