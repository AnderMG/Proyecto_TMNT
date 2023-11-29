package utils;

import clases.Jugador;

public class Quimica {
	public static int calcularQuimicaJugadores(Jugador jugador, Jugador jugador2) {
		int quimica = 0;
		if (jugador.getElemento() == jugador2.getElemento()) {
			quimica = quimica + 10;
		}
		if (jugador.getTemporada() == jugador2.getTemporada()) {
			quimica = quimica + 10;
		}	
		return quimica;
	}
	

	public static int calcularQuimicaFormacion(String formacion, Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4, Jugador jugador5, Jugador jugador6) {
		int quimica = 0;
		if(formacion == "1-3-1") {
			int quimica1 = calcularQuimicaJugadores(jugador1,jugador2); // por df
			int quimica2 = calcularQuimicaJugadores(jugador2,jugador3); // df mi
			int quimica3 = calcularQuimicaJugadores(jugador2,jugador4); // df mc
			int quimica4 = calcularQuimicaJugadores(jugador2,jugador5); // df md
			int quimica5 = calcularQuimicaJugadores(jugador3,jugador4); // mi mc
			int quimica6 = calcularQuimicaJugadores(jugador4,jugador5); // mc md
			int quimica7 = calcularQuimicaJugadores(jugador3,jugador6); // mi dl
			int quimica8 = calcularQuimicaJugadores(jugador5,jugador6); // md dl
			quimica = quimica + quimica1 + quimica2 + quimica3 + quimica4 + quimica5 + quimica6 + quimica7 + quimica8;
		}
		
		if(formacion == "2-2-1") {
			int quimica1 = calcularQuimicaJugadores(jugador1,jugador2); // por dfi
			int quimica2 = calcularQuimicaJugadores(jugador1,jugador3); // por dfd
			int quimica3 = calcularQuimicaJugadores(jugador2,jugador3); // dfi dfd
			int quimica4 = calcularQuimicaJugadores(jugador2,jugador4); // dfi mi
			int quimica5 = calcularQuimicaJugadores(jugador3,jugador5); // dfd md
			int quimica6 = calcularQuimicaJugadores(jugador4,jugador5); // mi md
			int quimica7 = calcularQuimicaJugadores(jugador4,jugador6); // mi dl
			int quimica8 = calcularQuimicaJugadores(jugador5,jugador6); // md dl
			quimica = quimica + quimica1 + quimica2 + quimica3 + quimica4 + quimica5 + quimica6 + quimica7 + quimica8;
		}
		
		if(formacion == "1-2-2") {
			int quimica1 = calcularQuimicaJugadores(jugador1,jugador2); // por df
			int quimica2 = calcularQuimicaJugadores(jugador2,jugador3); // df mi
			int quimica3 = calcularQuimicaJugadores(jugador2,jugador4); // df md
			int quimica4 = calcularQuimicaJugadores(jugador3,jugador4); // mi md
			int quimica5 = calcularQuimicaJugadores(jugador3,jugador5); // mi dli
			int quimica6 = calcularQuimicaJugadores(jugador4,jugador6); // md dld
			int quimica7 = calcularQuimicaJugadores(jugador3,jugador6); // mi dld
			int quimica8 = calcularQuimicaJugadores(jugador4,jugador5); // md dli
			quimica = quimica + quimica1 + quimica2 + quimica3 + quimica4 + quimica5 + quimica6 + quimica7 + quimica8;
		}
		if(formacion == "2-1-2") {
			int quimica1 = calcularQuimicaJugadores(jugador1,jugador2); // por dfi
			int quimica2 = calcularQuimicaJugadores(jugador1,jugador3); // por dfd
			int quimica3 = calcularQuimicaJugadores(jugador2,jugador3); // dfi dfd
			int quimica4 = calcularQuimicaJugadores(jugador2,jugador4); // dfi mi
			int quimica5 = calcularQuimicaJugadores(jugador3,jugador4); // dfd md
			int quimica6 = calcularQuimicaJugadores(jugador4,jugador5); // mc dl
			int quimica7 = calcularQuimicaJugadores(jugador4,jugador6); // mc dl
			int quimica8 = calcularQuimicaJugadores(jugador5,jugador6); // dl dl
			quimica = quimica + quimica1 + quimica2 + quimica3 + quimica4 + quimica5 + quimica6 + quimica7 + quimica8;
		}
		if(formacion == "3-1-1") {
			int quimica1 = calcularQuimicaJugadores(jugador1,jugador2); // por dfi
			int quimica2 = calcularQuimicaJugadores(jugador1,jugador3); // por dfd
			int quimica3 = calcularQuimicaJugadores(jugador1,jugador4); // por dfc
			int quimica4 = calcularQuimicaJugadores(jugador2,jugador4); // dfi dfc
			int quimica5 = calcularQuimicaJugadores(jugador3,jugador4); // dfd dfc
			int quimica6 = calcularQuimicaJugadores(jugador2,jugador5); // dfi mc
			int quimica7 = calcularQuimicaJugadores(jugador3,jugador5); // dfd mc
			int quimica8 = calcularQuimicaJugadores(jugador5,jugador6); // mc dl
			quimica = quimica + quimica1 + quimica2 + quimica3 + quimica4 + quimica5 + quimica6 + quimica7 + quimica8;
		}

		if (quimica > 100) {
			quimica = 100;
		}
		return quimica;
	}
	
	public static int calcularValoracionFormacion(Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4, Jugador jugador5, Jugador jugador6) {
		int valoracion = 0;
		
		valoracion =( ( jugador1.getMedia() + jugador2.getMedia() + jugador3.getMedia() + jugador4.getMedia() + jugador5.getMedia() + jugador6.getMedia() ) / 6 );
		return valoracion;
	}
	
	public static int calcularValoracionTotal(String formacion, Jugador jugador1, Jugador jugador2, Jugador jugador3, Jugador jugador4, Jugador jugador5, Jugador jugador6) {
		int valoracion = calcularValoracionFormacion(jugador1, jugador2, jugador3, jugador4, jugador5, jugador6);
		int quimica = calcularQuimicaFormacion(formacion, jugador1, jugador2, jugador3, jugador4, jugador5, jugador6);
		int valoracionTotal = valoracion + quimica;
		
		return valoracionTotal;

	}
}
