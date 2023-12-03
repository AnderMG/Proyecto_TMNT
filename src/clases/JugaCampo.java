
package clases;

import java.util.ArrayList;

public class JugaCampo extends Jugador {
	
	protected int ritmo;
	protected int regate;
	protected int tiro;
	protected int defensa;
	protected int fisico;
	protected int pase;
	
	
	public JugaCampo(int ID, String nombre, String apellido, Posicion posicion, Elemento elemento, String[] superTecnicas,
			String equipo, Temporada temporada, int media, ArrayList<Integer> estadisticas, boolean capitan,
			int qumica) {
		super(ID, nombre, apellido, posicion, elemento, superTecnicas, equipo, temporada, media, estadisticas, capitan, qumica);
	}
	
	public JugaCampo(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public int getRitmo() {
		return ritmo;
	}

	public void setRitmo(int ritmo) {
		this.ritmo = ritmo;
	}

	public int getRegate() {
		return regate;
	}

	public void setRegate(int regate) {
		this.regate = regate;
	}

	public int getTiro() {
		return tiro;
	}

	public void setTiro(int tiro) {
		this.tiro = tiro;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getFisico() {
		return fisico;
	}

	public void setFisico(int fisico) {
		this.fisico = fisico;
	}

	public int getPase() {
		return pase;
	}

	public void setPase(int pase) {
		this.pase = pase;
	}
	
	
	
}
