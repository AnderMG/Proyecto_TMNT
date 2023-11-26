package ventanas;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VentanaSeleccionJugadores extends JFrame {

	
	
	public VentanaSeleccionJugadores(int posicion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 400);
		switch (posicion) {
		case 1:
			setTitle("Seleccion de porteros");
			break;
		case 2:
			setTitle("Seleccion de defensas");
			break;
		case 3:
			setTitle("Seleccion de medios");
			break;
		case 4:
			setTitle("Seleccion de delanteros");
			break;			
		default:
			break;
		}
		setLocationRelativeTo( null );
		
		
		JLabel foto = new JLabel();
		foto.setBounds(0, 0, 70, 115);
		
		ImageIcon image = new ImageIcon("src/imagenes/Defensas/Aitor.jpg");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
		foto.setIcon(icon);
		foto.repaint();
		
		add(foto);
		
		
		setVisible(true);
		
	}
	
}
