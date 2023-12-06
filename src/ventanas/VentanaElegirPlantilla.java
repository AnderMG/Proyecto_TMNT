package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	JPanel panelContadorTerminar = new JPanel();
	JPanel panelCabecera = new JPanel();
	JPanel panelPortero = FondoEnVentana.panelConFondo("terrenoPor.png");
	JPanel panelDefensa = FondoEnVentana.panelConFondo("terrenoDef.png");
	JPanel panelMedio = FondoEnVentana.panelConFondo("terrenoMed.png");
	JPanel panelDelantero = FondoEnVentana.panelConFondo("terrenoDel.png");
	protected static JProgressBar barraQumica = new JProgressBar(0, 100);
	protected static JProgressBar barraValoracion = new JProgressBar(0, 100);
	protected static boolean plantillaCompleta = false;
	protected static int numMaxClickPor = 1;
	protected static int numMaxClickDef;
	protected static int numMaxClickMed;
	protected static int numMaxClickDel;
	public static JLabel etiquetaContador = new JLabel();
	String ruta = "src/imagenes/DefaultCardPeque.png";
	VentanaSeleccionJugadores ventSeleccion;

	public VentanaElegirPlantilla(String formacion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 800);
		setTitle("Plantilla " + formacion);
		setLocationRelativeTo( null );
		setResizable(false);
		
		HiloTiempoEnJuego hiloDuracion = new HiloTiempoEnJuego();

		int numeroDefensas = Integer.parseInt(formacion.substring(0, 1));
		int numeroMedios = Integer.parseInt(formacion.substring(2, 3));
		int numeroDelanteros = Integer.parseInt(formacion.substring(4, 5));
		numMaxClickDef = numeroDefensas;
		numMaxClickMed = numeroMedios;
		numMaxClickDel = numeroDelanteros;
		
		System.out.println("Numero defensas: " + numeroDefensas + "\nNumero medios: " + numeroMedios + "\nNumero Delanteros: " + numeroDelanteros);
		
		panelAlineacion.setLayout(new BoxLayout(panelAlineacion, BoxLayout.Y_AXIS));
		
		panelDelantero.setLayout(new FlowLayout(FlowLayout.CENTER, 600/numeroDelanteros, 0));
		panelMedio.setLayout(new FlowLayout(FlowLayout.CENTER, 600/numeroMedios, 0));
		panelDefensa.setLayout(new FlowLayout(FlowLayout.CENTER, 600/numeroDefensas, 0));
		
		panelDelantero = crearAlineacion(numeroDelanteros, panelDelantero, 4, formacion);
		panelMedio = crearAlineacion(numeroMedios, panelMedio, 3, formacion);
		panelDefensa = crearAlineacion(numeroDefensas, panelDefensa, 2, formacion);
		panelPortero = crearAlineacion(1, panelPortero, 1, formacion);
		
		
		panelAlineacion.add(panelDelantero);
		panelAlineacion.add(panelMedio);
		panelAlineacion.add(panelDefensa);
		panelAlineacion.add(panelPortero);
		
		
		
		panelQuimiValo.setLayout(new GridLayout(2, 1));
		panelQuimiValo.setForeground(Color.white);
//		panelQuimiValo.add(new JLabel("Valoracion: ", SwingConstants.RIGHT));
		panelQuimiValo.add(barraValoracion);
//		panelQuimiValo.add(new JLabel("Quimica: ", SwingConstants.RIGHT));
		panelQuimiValo.add(barraQumica);
		
		
		panelContadorTerminar.setLayout(new GridLayout(2, 2));
		panelContadorTerminar.add(etiquetaContador);
		panelContadorTerminar.add(new JLabel("Valoracion: ", SwingConstants.RIGHT));
		panelContadorTerminar.add(new JLabel());
		panelContadorTerminar.add(new JLabel("Quimica: ", SwingConstants.RIGHT));
		
		panelCabecera.setLayout(new GridLayout(1, 2));
		panelCabecera.add(panelContadorTerminar);
		panelCabecera.add(panelQuimiValo);
		
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
		add(panelCabecera, BorderLayout.NORTH);
		add(panelAlineacion, BorderLayout.CENTER);
		
		
		
		setVisible(true);
		hiloDuracion.start();
	}
	
	//Metodo rellenar las lineas de la alineacion con las imagenes
	public JPanel crearAlineacion (int nJugadoresPosicion, JPanel panelPosicion, int posicion, String formacion) {
		for (int i = 0; i < nJugadoresPosicion; i++) {
			JLabel etiqueta = new JLabel("", SwingConstants.CENTER);
			etiqueta.setBounds(0, 0, 120, 160);
			SetImageLabel(etiqueta, ruta);
			etiqueta.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if (posicion==1 & numMaxClickPor!=0 || posicion==2 & numMaxClickDef!=0 || posicion==3 & numMaxClickMed!=0 || posicion==4 & numMaxClickDel!=0)
					ventSeleccion = new VentanaSeleccionJugadores(posicion, etiqueta, formacion);
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
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH));
		etiqueta.setIcon(icon);
	}
	
}
