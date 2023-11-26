package ventanas;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		setResizable(false);
		
		JPanel panel = new JPanel(new GridLayout(1, 3, 30, 0));
		
		//Imagenes de prueba hasta implementar la funcion final
		JLabel foto = new JLabel();
		foto.setBounds(0, 0, 325, 390);
		
		ImageIcon image = new ImageIcon("src/imagenes/Defensas/Aitor.jpg");
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT));
		foto.setIcon(icon);
		foto.repaint();
		
		JLabel foto1 = new JLabel();
		foto1.setBounds(0, 0, 325, 390);
		
		ImageIcon image1 = new ImageIcon("src/imagenes/Defensas/Gabi.jpg");
		Icon icon1 = new ImageIcon(image1.getImage().getScaledInstance(foto1.getWidth(), foto1.getHeight(), Image.SCALE_DEFAULT));
		foto1.setIcon(icon1);
		foto1.repaint();
		
		JLabel foto2 = new JLabel();
		foto2.setBounds(0, 0, 325, 390);
		
		ImageIcon image2 = new ImageIcon("src/imagenes/Defensas/Goldie.jpg");
		Icon icon2 = new ImageIcon(image2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT));
		foto2.setIcon(icon2);
		foto2.repaint();
		
		panel.add(foto);
		panel.add(foto1);
		panel.add(foto2);
		
		add(panel);
		
		setVisible(true);
		
	}
	
}
