package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import utils.FondoEnVentana;
import utils.HiloTiempoEnJuego;
import utils.Quimica;

public class VentanaElegirPlantilla extends JFrame{
	JPanel panelAlineacion = new JPanel();
	JPanel panelQuimiValo = new JPanel();
	JPanel panelPortero = FondoEnVentana.panelConFondo("terrenoPor.png");
	JPanel panelDefensa = FondoEnVentana.panelConFondo("terrenoDef.png");
	JPanel panelMedio = FondoEnVentana.panelConFondo("terrenoMed.png");
	JPanel panelDelantero = FondoEnVentana.panelConFondo("terrenoDel.png");
	protected static JProgressBar barraQumica = new JProgressBar(0, 100);
	protected static JProgressBar barraValoracion = new JProgressBar(0, 100);
	protected static boolean plantillaCompleta = false;
//	int contador = 0;
//	Thread hiloTiempoPartida;
	String ruta = "src/imagenes/DefaultCardPeque.png";
	VentanaSeleccionJugadores ventSeleccion;

	public VentanaElegirPlantilla(String formacion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 800);
		setTitle("Plantilla " + formacion);
		setLocationRelativeTo( null );
		
		HiloTiempoEnJuego hiloDuracion = new HiloTiempoEnJuego();
		
		int numeroDefensas = Integer.parseInt(formacion.substring(0, 1));
		int numeroMedios = Integer.parseInt(formacion.substring(2, 3));
		int numeroDelanteros = Integer.parseInt(formacion.substring(4, 5));
		
		System.out.println("Numero defensas: " + numeroDefensas + "\nNumero medios: " + numeroMedios + "\nNumero Delanteros: " + numeroDelanteros);
		
		panelAlineacion.setLayout(new BoxLayout(panelAlineacion, BoxLayout.Y_AXIS));
		
		panelDelantero.setLayout(new GridLayout(1, numeroDelanteros, 0, 0));
		panelMedio.setLayout(new GridLayout(1, numeroMedios, 0, 0));
		panelDefensa.setLayout(new GridLayout(1, numeroDefensas, 0, 0));
		
		panelDelantero = crearAlineacion(numeroDelanteros, panelDelantero, 4);
		panelMedio = crearAlineacion(numeroMedios, panelMedio, 3);
		panelDefensa = crearAlineacion(numeroDefensas, panelDefensa, 2);
		panelPortero = crearAlineacion(1, panelPortero, 1);
		
		
		panelAlineacion.add(panelDelantero);
		panelAlineacion.add(panelMedio);
		panelAlineacion.add(panelDefensa);
		panelAlineacion.add(panelPortero);
		
		
//		JLabel segundos = new JLabel("segundos: " + contador);
//		
//		hiloTiempoPartida = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				while(!hiloTiempoPartida.isInterrupted()) {
//					try {
//						segundos.setText("segundos: " + contador);
//						Thread.sleep(1000);
//						contador++;
//					}catch (Exception e) {
//					}
//					
//				}
//				
//				
//			}
//		});
		
		panelQuimiValo.setLayout(new GridLayout(2, 2));
//		panelQuimiValo.add(new JLabel("Temporizacion partida", SwingConstants.CENTER));
		panelQuimiValo.setForeground(Color.white);
		panelQuimiValo.add(new JLabel("Valoracion: ", SwingConstants.RIGHT));
		panelQuimiValo.add(barraValoracion);
//		panelQuimiValo.add(segundos);
		panelQuimiValo.add(new JLabel("Quimica: ", SwingConstants.RIGHT));
		panelQuimiValo.add(barraQumica);
		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				hiloDuracion.interrupt();
				VentanaPrincipal.logger.log(Level.FINE, "Se ha terminado la partida");
				System.out.println("Se ha finalizado el juego");
				if (!(ventSeleccion == null)) {
					ventSeleccion.dispose();
				}
				super.windowClosed(e);
			}
			
		});
		add(panelQuimiValo, BorderLayout.NORTH);
		add(panelAlineacion, BorderLayout.CENTER);
		
		
//		addWindowListener(new WindowAdapter() {
//
//			@Override
//			public void windowStateChanged(WindowEvent e) {
//				for (Component c: panelPortero.getComponents()) {
//					c.resize((VentanaElegirPlantilla.this.size().width/14), (VentanaElegirPlantilla.this.size().height/7));
//				}
//				for (Component c: panelDefensa.getComponents()) {
//					c.resize((VentanaElegirPlantilla.this.size().width/14), (VentanaElegirPlantilla.this.size().height/7));
//				}
//				for (Component c: panelMedio.getComponents()) {
//					c.resize((VentanaElegirPlantilla.this.size().width/14), (VentanaElegirPlantilla.this.size().height/7));
//				}
//				for (Component c: panelDelantero.getComponents()) {
//					c.resize((VentanaElegirPlantilla.this.size().width/14), (VentanaElegirPlantilla.this.size().height/7));
//				}
//				super.windowStateChanged(e);
//			}
//			
//			
//		});
		
		setVisible(true);
		hiloDuracion.start();
	}
	
	//Metodo rellenar las lineas de la alineacion con las imagenes
	public JPanel crearAlineacion (int nJugadoresPosicion, JPanel panelPosicion, int posicion) {
		for (int i = 0; i < nJugadoresPosicion; i++) {
			JLabel etiqueta = new JLabel("", SwingConstants.CENTER);
			etiqueta.setBounds(0, 0, 70, 115);
			SetImageLabel(etiqueta, ruta);
			etiqueta.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					ventSeleccion = new VentanaSeleccionJugadores(posicion, etiqueta);
					VentanaPrincipal.logger.log(Level.FINE, "Se ha abierto la ventana de seleccion de jugador");
					super.mouseClicked(e);					
				}
				
			});
			panelPosicion.add(etiqueta);
		}
		return panelPosicion;
	}
	
	//Metodo insertar la imagen en la etiqueta
	public static void SetImageLabel (JLabel etiqueta, String ruta) {
		ImageIcon image = new ImageIcon(ruta);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_DEFAULT));
		etiqueta.setIcon(icon);
	}
	
}
