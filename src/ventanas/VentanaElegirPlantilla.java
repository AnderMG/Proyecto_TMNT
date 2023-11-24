package ventanas;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.HiloTiempoEnJuego;

public class VentanaElegirPlantilla extends JFrame{
	JPanel panelAlineacion = new JPanel();
	JPanel panelPortero = new JPanel();
	JPanel panelDefensa = new JPanel();
	JPanel panelMedio = new JPanel();
	JPanel panelDelantero = new JPanel();
	ImageIcon icon = new ImageIcon("/imagenes/JugadorSinElegir.jpg");
	JLabel labelIcono = new JLabel();

	public VentanaElegirPlantilla(String formacion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 500);
		setTitle("Plantilla " + formacion);
		setLocationRelativeTo( null );
		labelIcono.setBounds(0, 0, 50, 50);
		
		SetImageLabel(labelIcono, "src/imagenes/fondo.jpg");
		
		HiloTiempoEnJuego hiloDuracion = new HiloTiempoEnJuego();
		
		int numeroDefensas = Integer.parseInt(formacion.substring(0, 1));
		int numeroMedios = Integer.parseInt(formacion.substring(2, 3));
		int numeroDelanteros = Integer.parseInt(formacion.substring(4, 5));
		
		System.out.println("Numero defensas: " + numeroDefensas + "\nNumero medios: " + numeroMedios + "\nNumero Delanteros: " + numeroDelanteros);
		
		
//		panelAlineacion.setLayout(new GridBagLayout());
//		
//		panelDelantero = crearAlineacion(numeroDelanteros, panelDelantero);
//		
//		
//		panelAlineacion.add(panelDelantero);
		
		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				hiloDuracion.interrupt();
				System.out.println("Se ha finalizado el juego");
				super.windowClosed(e);
			}
			
		});
//		add(panelAlineacion);
		
		
		add(labelIcono);
		
		add(new JLabel("HOLA"));
		setVisible(true);
		hiloDuracion.start();
	}
	
//	public JPanel crearAlineacion (int nJugadoresPosicion, JPanel panelPosicion) {
//		labelIcono.setIcon(icon);
//		for (int i = 0; i < nJugadoresPosicion; i++) {
//			panelPosicion.add(labelIcono);
//		}
//		return panelPosicion;
//	}
	
	public void SetImageLabel (JLabel etiqueta, String ruta) {
		ImageIcon image = new ImageIcon(ruta);
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(etiqueta.getWidth(), etiqueta.getHeight(), Image.SCALE_DEFAULT));
		etiqueta.setIcon(icon);
		repaint();
	}
	
}
