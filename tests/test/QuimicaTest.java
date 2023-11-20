package test;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import clases.Elemento;
import clases.JugaCampo;
import clases.Posicion;
import clases.Temporada;
import utils.Quimica;

public class QuimicaTest {
	
	static JugaCampo jugador1 = new JugaCampo("Zinedine", "Zidane", Posicion.MEDIOCENTRO, Elemento.BOSQUE, null, null, Temporada.TEMPORADA2, 0, null, false, 0);
	static JugaCampo jugador2 = new JugaCampo("Lionel", "Messi", Posicion.DELANTERO, Elemento.AIRE, null, null, Temporada.TEMPORADA3, 0, null, false, 0);
	static JugaCampo jugador3 = new JugaCampo("Cristiano", "Ronaldo", Posicion.DELANTERO, Elemento.FUEGO, null, null, Temporada.TEMPORADA3, 0, null, false, 0);
	static JugaCampo jugador4 = new JugaCampo("Vinicius", "Junior", Posicion.DELANTERO, Elemento.FUEGO, null, null, Temporada.TEMPORADA4, 0, null, false, 0);
	static JugaCampo jugador5 = new JugaCampo("Ferran", "Torres", Posicion.DELANTERO, Elemento.FUEGO, null, null, Temporada.TEMPORADA4, 0, null, false, 0);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Parameters
	public static List<Object> dataQuimica2(){	
		
		return Arrays.asList(
			//Objetos quimica con 2 jugadores
			new Object[] {0, Quimica.calcularQuimica2Jugadores(jugador1, jugador2)},
			new Object[] {5, Quimica.calcularQuimica2Jugadores(jugador3, jugador2)},
			new Object[] {10, Quimica.calcularQuimica2Jugadores(jugador4, jugador5)},
			//Objetos quimica con 3 jugadores
			new Object[] {0, Quimica.calcularQuimica3Jugadores(jugador1, jugador2, jugador3)},
			new Object[] {5, Quimica.calcularQuimica3Jugadores(jugador2, jugador3, jugador4)},
			new Object[] {10, Quimica.calcularQuimica3Jugadores(jugador3, jugador4, jugador5)}
		);
				
	}
	@Parameter(0)
	public int esperado;
	
	@Parameter(1)
	public int obtenido;

	
	@Test
	public void testQuimica2() {
		assertEquals(esperado, obtenido);
		
	}
	
}
	