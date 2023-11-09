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

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Usuario;


public class VentanaPrincipal {
	private JFrame ventanaPrincipal;
<<<<<<< HEAD
	private static boolean iniciadoSesion = false;	

	private static JPanel panelConFondo() {
		JPanel panelFondo = new JPanelConFondo( "fondo.jpg" );
=======
	private static boolean iniciadoSesion = false;
	
	public static JPanel panelConFondo(String imagen) {
		JPanel panelFondo = new JPanelConFondo(imagen);
>>>>>>> 1ace73345b45f522644a9588cc0e2a1068bfc2b0
		return panelFondo;
	}
	
	public static void main(String[] args) {
		
		//Creamos la venta
		JFrame ventanaPrincipal = new JFrame();
		ventanaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventanaPrincipal.setSize(1000, 700);
		ventanaPrincipal.setTitle("FutDraft Eleven");
		ventanaPrincipal.setLocationRelativeTo( null );
		
		
		//Botones de salida, jugar e iniciar sesion
		JButton btnSalir = new JButton();
		btnSalir.setText("Salir");
		btnSalir.setOpaque(false);
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.dispose();
				
			}
		});
		
		JButton btnJugar = new JButton();
		btnJugar.setText("¡Jugar!");
		btnJugar.setOpaque(false);
		btnJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					if (iniciadoSesion) {
						new VentanaFormacion();
						ventanaPrincipal.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Inicia sesion antes de empezar a jugar");
					}
					
			}
		});
		JButton btnIniciarSesion = new JButton();
		btnIniciarSesion.setText("Iniciar sesion");
		btnIniciarSesion.setOpaque(false);
		btnIniciarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				iniciadoSesion = true;
				new Login();
			}
		});
		
		
		
		//Creamos los paneles
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1, 3, 10, 0));
		panelBotones.add(btnSalir);
		panelBotones.add(btnIniciarSesion);
		panelBotones.add(btnJugar);
		
		JPanel panelFondo = panelConFondo("fondo.jpg");
		panelFondo.setLayout(new BorderLayout());
		panelFondo.add(panelBotones, BorderLayout.SOUTH);
		
		
		
		
		//Ainadimos el panel a la ventana
		ventanaPrincipal.add(panelFondo, BorderLayout.CENTER);
		
		ventanaPrincipal.setVisible(true);
	}
}

//Clase Fondo de pantalla
@SuppressWarnings("serial")
class JPanelConFondo extends JPanel {

	private BufferedImage imagenOriginal;
	public JPanelConFondo( String nombreImagenFondo ) {
        URL imgURL = getClass().getResource("/imagenes/" + nombreImagenFondo);
        try {
        	imagenOriginal = ImageIO.read( imgURL );
        } catch (IOException e) {
        }
	}

	protected void paintComponent(Graphics g) {
		Rectangle espacio = g.getClipBounds();  // espacio de dibujado del panel
		// setBounds( espacio );
		//super.paintComponent(g);  en vez de esto...
		Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
		// Código para que el dibujado se reescale al área disponible
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
		// Dibujado
		g2.drawImage(imagenOriginal, 0, 0, (int)espacio.getWidth(), (int)espacio.getHeight(), null);
	}

}
