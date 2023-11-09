package ventanas;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaElegirPlantilla extends JFrame{

	public VentanaElegirPlantilla(String formacion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 500);
		setTitle("Plantilla " + formacion);
		setLocationRelativeTo( null );
		
	
		
		int numeroDefensas = Integer.parseInt(formacion.substring(0, 1));
		int numeroMedios = Integer.parseInt(formacion.substring(2, 3));
		int numeroDelanteros = Integer.parseInt(formacion.substring(4, 5));
		
		System.out.println("Numero defensas: " + numeroDefensas + "\nNumero medios: " + numeroMedios + "\nNumero Delanteros: " + numeroDelanteros);
		
		setVisible(true);
	}
}
