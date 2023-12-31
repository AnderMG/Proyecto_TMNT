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
	
	static JugaCampo jugador1 = new JugaCampo(1, "Zinedine", "Zidane", Posicion.MEDIOCENTRO, Elemento.BOSQUE, null, null, Temporada.TEMPORADA2, 91, null, false, 0);
	static JugaCampo jugador2 = new JugaCampo(2, "Lionel", "Messi", Posicion.DELANTERO, Elemento.AIRE, null, null, Temporada.TEMPORADA3, 94, null, false, 0);
	static JugaCampo jugador3 = new JugaCampo(3, "Cristiano", "Ronaldo", Posicion.DELANTERO, Elemento.FUEGO, null, null, Temporada.TEMPORADA3, 93, null, false, 0);
	static JugaCampo jugador4 = new JugaCampo(4, "Vinicius", "Junior", Posicion.DELANTERO, Elemento.FUEGO, null, null, Temporada.TEMPORADA4, 88, null, false, 0);
	static JugaCampo jugador5 = new JugaCampo(4, "Ferran", "Torres", Posicion.DELANTERO, Elemento.FUEGO, null, null, Temporada.TEMPORADA4, 99, null, false, 0);
	static JugaCampo jugador6 = new JugaCampo(4, "Erling", "Haaland", Posicion.DELANTERO, Elemento.MONTANIA, null, null, Temporada.TEMPORADA5, 90, null, false, 0);
	
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
			new Object[] {0, Quimica.calcularQuimicaJugadores(jugador1, jugador2)},
			new Object[] {5, Quimica.calcularQuimicaJugadores(jugador3, jugador2)},
			new Object[] {10, Quimica.calcularQuimicaJugadores(jugador4, jugador5)}
			//Objetos quimica con 3 jugadores

		);
				
	}
	@Parameter(0)
	public int esperado;
	public int esperado1 = 10;
	public int esperado2 = 20;
	public int esperado3 = 0;
	
	@Parameter(1)
	public int obtenido;
	public int obtenido1 = Quimica.calcularQuimicaJugadores(jugador3, jugador4);
	public int obtenido2 = Quimica.calcularQuimicaJugadores(jugador4, jugador5);
	public int obtenido3 = Quimica.calcularQuimicaJugadores(jugador1, jugador2);

	@Test
	public void testQuimica2() {
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void testQuimicaFormacion() {
		assertEquals(40, Quimica.calcularQuimicaFormacion("1-3-1", jugador1, jugador2, jugador3, jugador4, jugador5, jugador6));
		assertEquals(20, Quimica.calcularQuimicaFormacion("3-1-1", jugador1, jugador2, jugador3, jugador4, jugador5, jugador6));
	}
	
	@Test
	public void testValoracion() {
		assertEquals(92, Quimica.calcularValoracionFormacion(jugador1, jugador2, jugador3, jugador4, jugador5, jugador6));
	}
	
}
	