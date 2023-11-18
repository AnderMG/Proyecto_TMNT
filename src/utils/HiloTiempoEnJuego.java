package utils;

public class HiloTiempoEnJuego extends Thread{
	protected static int contadorSegundos;
	
		public void run() {
			contadorSegundos = 0;
			while (!isInterrupted()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					interrupt();
				}
				contadorSegundos++;
//				System.out.println("Tiempo en juego: " + contadorSegundos);
			}
			
		}
}
	
