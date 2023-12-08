package ventanas;

import java.awt.BorderLayout;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Usuario;
import utils.FondoEnVentana;
import utils.HiloTiempoEnJuego;
import utils.Quimica;


public class VentanaPrincipal {
	protected static boolean iniciadoSesion = false;
	protected static Logger logger;
	
	public static void main(String[] args) { 
		//Creamos el logger	
		try {
			logger = Logger.getLogger("ventanas.VentanaPrincipal");
			Handler h = new FileHandler("LoggerVentanas.xml", true);
			logger.addHandler(h);
			logger.setLevel(Level.FINEST);
			h.setLevel(Level.FINEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Creamos la venta
		JFrame ventanaPrincipal = new JFrame();
		ventanaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaPrincipal.setSize(1000, 700);
		ventanaPrincipal.setTitle("FutDraft Eleven");
		ventanaPrincipal.setLocationRelativeTo( null );
		
		//Botones de salida
		JButton btnSalir = new JButton();
		btnSalir.setText("Jugadores");
		btnSalir.setOpaque(false);
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.FINE, "Se ha pulsado el boton jugadores");
				new VentanaJugadores();
			}
		});
		//Boton que inicia el juego
		JButton btnJugar = new JButton();
		btnJugar.setText("¡Jugar!");
		btnJugar.setOpaque(false);
		btnJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.FINE, "Se ha pulsado el boton jugar");
					if (iniciadoSesion) {
						logger.log(Level.FINE, "El inicio de sesion era correcto, se ha iniciado el juego");
						new VentanaFormacion();
						ventanaPrincipal.dispose();
					}else {
						logger.log(Level.FINE, "El inicio de sesion era incorrecto o nulo, no se ha podido inicar");
						JOptionPane.showMessageDialog(null, "Inicia sesion antes de empezar a jugar");
					}
					
			}
		});
		//Se debe inciar sesion con una cuenta registrada para poder acceder al juego
		JButton btnIniciarSesion = new JButton();
		btnIniciarSesion.setText("Iniciar sesion");
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logger.log(Level.FINE, "Se ha pulsado boton inicio de sesion");
				new Login();
			}
		});
		
		
		
		//Creamos los paneles
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 3, 10, 0));
		panelBotones.add(btnSalir);
		panelBotones.add(btnIniciarSesion);
		panelBotones.add(btnJugar);
		
		JPanel panelFondo = FondoEnVentana.panelConFondo("fondoPrincipal.jpg");
		panelFondo.setLayout(new BorderLayout());
		panelFondo.add(panelBotones, BorderLayout.SOUTH);
		
		
		//Ainadimos el panel a la ventana
		ventanaPrincipal.add(panelFondo, BorderLayout.CENTER);
		
		ventanaPrincipal.setVisible(true);
		logger.log(Level.FINEST, "Se ha iniciado la ventana principal");
	}
}
