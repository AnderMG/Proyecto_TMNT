package utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


//Clase hecho con el código de la clase PruebasVariasSwing del repositorio de clase 
public class FondoEnVentana extends JPanel {
	
	private BufferedImage imagenOriginal;
	
	
	public FondoEnVentana( String nombreImagenFondo ) {
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
	
	public static JPanel panelConFondo(String imagen) {
		JPanel panelFondo = new FondoEnVentana(imagen);
		return panelFondo;
	}
}
