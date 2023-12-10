package ventanas;

import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import utils.DaoFormacion;
import utils.FondoEnVentana;
import utils.HiloTiempoEnJuego;

public class VentanaElegirPlantilla extends JFrame{
	JPanel panelAlineacion = new JPanel();
	JPanel panelQuimiValo = new JPanel();
	JPanel panelContadorTerminar = new JPanel();
	JPanel panelCabecera = new JPanel();
	JPanel panelPortero = FondoEnVentana.panelConFondo("terrenoPor.png");
	JPanel panelDefensa = FondoEnVentana.panelConFondo("terrenoDef.png");
	JPanel panelMedio = FondoEnVentana.panelConFondo("terrenoMed.png");
	JPanel panelDelantero = FondoEnVentana.panelConFondo("terrenoDel.png");
	JButton botonTerminar = new JButton();
	protected static JProgressBar barraQumica = new JProgressBar(0, 100);
	protected static JProgressBar barraValoracion = new JProgressBar(0, 100);
	protected static boolean plantillaCompleta = false;
	protected static int numMaxClickPor = 1;
	protected static int numMaxClickDef;
	protected static int numMaxClickMed;
	protected static int numMaxClickDel;
	public static JLabel etiquetaContador = new JLabel();
	public static JLabel etiquetaValoracion = new JLabel();
	public static JLabel etiquetaQuimica = new JLabel();
	String ruta = "src/imagenes/DefaultCardPeque.png";
	VentanaSeleccionJugadores ventSeleccion;
	
	DaoFormacion dao = new DaoFormacion();

	public VentanaElegirPlantilla(String formacion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 800);
		setTitle("Plantilla " + formacion);
		setLocationRelativeTo( null );
		setResizable(false);
		
		//Inicializar la etiqueta y el hilo contador
		etiquetaContador.setFont(new Font(Font.DIALOG_INPUT, 13, 12));
		etiquetaContador.setHorizontalAlignment(SwingConstants.CENTER);
		HiloTiempoEnJuego hiloDuracion = new HiloTiempoEnJuego();

		//sacar el numero de jugadores por posicion
		int numeroDefensas = Integer.parseInt(formacion.substring(0, 1));
		int numeroMedios = Integer.parseInt(formacion.substring(2, 3));
		int numeroDelanteros = Integer.parseInt(formacion.substring(4, 5));
		numMaxClickDef = numeroDefensas;
		numMaxClickMed = numeroMedios;
		numMaxClickDel = numeroDelanteros;
		
		System.out.println("Numero defensas: " + numeroDefensas + "\nNumero medios: " + numeroMedios + "\nNumero Delanteros: " + numeroDelanteros);
		
		panelAlineacion.setLayout(new BoxLayout(panelAlineacion, BoxLayout.Y_AXIS));
		
		//implementacion de los paneles de posicion//
		panelDelantero.setLayout(new FlowLayout(FlowLayout.CENTER, 600/numeroDelanteros, 0));
		panelMedio.setLayout(new FlowLayout(FlowLayout.CENTER, 600/numeroMedios, 0));
		panelDefensa.setLayout(new FlowLayout(FlowLayout.CENTER, 600/numeroDefensas, 0));
		
		panelDelantero = crearAlineacion(numeroDelanteros, panelDelantero, 4, formacion);
		panelMedio = crearAlineacion(numeroMedios, panelMedio, 3, formacion);
		panelDefensa = crearAlineacion(numeroDefensas, panelDefensa, 2, formacion);
		panelPortero = crearAlineacion(1, panelPortero, 1, formacion);
		
		//añadir los paneles de las posiciones al panel general//
		panelAlineacion.add(panelDelantero);
		panelAlineacion.add(panelMedio);
		panelAlineacion.add(panelDefensa);
		panelAlineacion.add(panelPortero);
		
		
		//Panel de las barras de quimica y valoracion
		panelQuimiValo.setLayout(new GridLayout(2, 1));
		panelQuimiValo.setForeground(Color.white);
		panelQuimiValo.add(barraValoracion);
		panelQuimiValo.add(barraQumica);
		
		//Configurar etiqeutas de valoracion y qumica//
		etiquetaValoracion.setText("Valoracion: __");
		etiquetaQuimica.setText("Quimica: __");
		etiquetaValoracion.setHorizontalAlignment(SwingConstants.RIGHT);
		etiquetaQuimica.setHorizontalAlignment(SwingConstants.RIGHT);
		etiquetaValoracion.setFont(new Font(Font.DIALOG, 0, 12));
		etiquetaQuimica.setFont(new Font(Font.DIALOG, 0, 12));
		
		
		//configuracion boton de terminar//
		botonTerminar.setText("Finalizar");
		botonTerminar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 10));
		botonTerminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (VentanaSeleccionJugadores.plantilla.size() == 6) {
					hiloDuracion.interrupt();
					VentanaPrincipal.logger.log(Level.FINEST, "Plantilla completa");
					//al finalizar se añade la formacion a la base de datos//
					
					int quimica = VentanaElegirPlantilla.barraQumica.getValue();
					int valoracion = VentanaElegirPlantilla.barraValoracion.getValue();
					int valoraciontotal = quimica + valoracion;
					if(dao.insertarFormacion(VentanaPrincipal.IDusuario, formacion,quimica, valoracion, valoraciontotal, VentanaSeleccionJugadores.plantilla.get(0).getID(), 
							VentanaSeleccionJugadores.plantilla.get(1).getID(), VentanaSeleccionJugadores.plantilla.get(2).getID(), 
							VentanaSeleccionJugadores.plantilla.get(3).getID(), VentanaSeleccionJugadores.plantilla.get(4).getID(),
							VentanaSeleccionJugadores.plantilla.get(5).getID())) {
						VentanaPrincipal.logger.log(Level.FINEST, "Se ha añadido correctamente a la base de datos");
					}
					else {
						VentanaPrincipal.logger.log(Level.WARNING, "No se ha añadido a la base de datos");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Debes completar la plantilla primero");
				}
							
			}
		});
		
		//panel del contador y boton de terminar//
		panelContadorTerminar.setLayout(new GridLayout(2, 2));
		panelContadorTerminar.add(etiquetaContador);
		panelContadorTerminar.add(etiquetaValoracion);
		panelContadorTerminar.add(botonTerminar);
		panelContadorTerminar.add(etiquetaQuimica);
		
		
		//Panel de cabecera//
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
		//añadimos los paneles de cabecera y alineacion a la ventana//
		add(panelCabecera, BorderLayout.NORTH);
		add(panelAlineacion, BorderLayout.CENTER);
		
		
		
		setVisible(true);
		VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana de elegir plantilla");
		hiloDuracion.start();
	}
	
	//Metodo que rellena las lineas de la alineacion con las imagenes de las cartas//
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
