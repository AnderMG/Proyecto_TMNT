package ventanas;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import utils.HiloTiempoEnJuego;

public class VentanaElegirPlantilla extends JFrame{

	public VentanaElegirPlantilla(String formacion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 500);
		setTitle("Plantilla " + formacion);
		setLocationRelativeTo( null );
		
		HiloTiempoEnJuego hiloDuracion = new HiloTiempoEnJuego();
		
		int numeroDefensas = Integer.parseInt(formacion.substring(0, 1));
		int numeroMedios = Integer.parseInt(formacion.substring(2, 3));
		int numeroDelanteros = Integer.parseInt(formacion.substring(4, 5));
		
		System.out.println("Numero defensas: " + numeroDefensas + "\nNumero medios: " + numeroMedios + "\nNumero Delanteros: " + numeroDelanteros);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				hiloDuracion.interrupt();
				System.out.println("Se ha finalizado el juego");
				super.windowClosed(e);
			}
			
		});
		
		setVisible(true);
		hiloDuracion.start();
	}
}
