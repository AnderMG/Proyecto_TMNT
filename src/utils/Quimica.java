package utils;

import clases.Jugador;

public class Quimica {
	public static int calcularQuimica2Jugadores(Jugador jugador, Jugador jugador2) {
		int quimica = 0;
		if (jugador.getElemento() == jugador2.getElemento()) {
			quimica++;
		}
		if (jugador.getTemporada() == jugador2.getTemporada()) {
			quimica++;
		}	
		return quimica*5;
	}
	

	public static int calcularQuimica3Jugadores(Jugador jugador, Jugador jugador2, Jugador jugador3) {
		int quimica = 0;
		if (jugador.getElemento() == jugador2.getElemento()) {
			quimica++;
		}
		if (jugador.getTemporada() == jugador2.getTemporada()) {
			quimica++;
		}	
		return quimica*5;
	}
}
