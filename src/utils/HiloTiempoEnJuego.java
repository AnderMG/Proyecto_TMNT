package utils;

import javax.swing.JLabel;

import ventanas.VentanaElegirPlantilla;

public class HiloTiempoEnJuego extends Thread{
	protected static int contadorSegundos;

	
	public void run() {
			contadorSegundos = 0;
			while (!isInterrupted()) {
				actualizarJlabel();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					interrupt();
				}
				contadorSegundos++;				
			}
			
		}
		
	public void actualizarJlabel() {
		VentanaElegirPlantilla.etiquetaContador.setText("Tiempo en juego: " + contadorSegundos + " segundos");
	}
}
	
