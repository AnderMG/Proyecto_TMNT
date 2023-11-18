package utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Elemento;
import clases.JugaCampo;
import clases.Jugador;
import clases.Posicion;
import clases.Temporada;

public class QuimicaTest {
	
	JugaCampo jugador1 = new JugaCampo("Zinedine", "Zidane", Posicion.MEDIOCENTRO, Elemento.BOSQUE, null, null, Temporada.TEMPORADA2, 0, null, false, 0);
	JugaCampo jugador2 = new JugaCampo("Lionel", "Messi", Posicion.DELANTERO, Elemento.AIRE, null, null, Temporada.TEMPORADA3, 0, null, false, 0);
	JugaCampo jugador3 = new JugaCampo("Cristiano", "Ronaldo", Posicion.DELANTERO, Elemento.FUEGO, null, null, Temporada.TEMPORADA3, 0, null, false, 0);
	JugaCampo jugador4 = new JugaCampo("Vinicius", "Junior", Posicion.DELANTERO, Elemento.FUEGO, null, null, Temporada.TEMPORADA4, 0, null, false, 0);
	JugaCampo jugador5 = new JugaCampo("Ferran", "Torres", Posicion.DELANTERO, Elemento.FUEGO, null, null, Temporada.TEMPORADA4, 0, null, false, 0);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(0, Quimica.calcularQuimica2Jugadores(jugador1, jugador2));
		assertEquals(5, Quimica.calcularQuimica2Jugadores(jugador3, jugador2));
		assertEquals(10, Quimica.calcularQuimica2Jugadores(jugador4, jugador5));
		
		assertEquals(0, Quimica.calcularQuimica3Jugadores(jugador1, jugador2, jugador3));
		assertEquals(5, Quimica.calcularQuimica3Jugadores(jugador2, jugador3, jugador4));
		assertEquals(5, Quimica.calcularQuimica3Jugadores(jugador3, jugador4, jugador5));
	}

}
