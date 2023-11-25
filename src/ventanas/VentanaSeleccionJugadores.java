package ventanas;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class VentanaSeleccionJugadores extends JFrame {

	
	
	public VentanaSeleccionJugadores(int posicion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 400);
		switch (posicion) {
		case 1:
			setTitle("Seleccion de porteros");
			break;
		case 2:
			setTitle("Seleccion de defensas");
			break;
		case 3:
			setTitle("Seleccion de medios");
			break;
		case 4:
			setTitle("Seleccion de delanteros");
			break;			
		default:
			break;
		}
		setLocationRelativeTo( null );
		
		setVisible(true);
		
	}
	
}
