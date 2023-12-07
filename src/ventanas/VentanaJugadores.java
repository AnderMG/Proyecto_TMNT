package ventanas;

import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import utils.FondoEnVentana;
	

public class VentanaJugadores extends JFrame{

	private JPanel contentPane;
	private JPanel panelJugadores = new JPanel();
	
	public VentanaJugadores() {
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setSize(800, 500);
	setTitle("Jugadores");
	setLocationRelativeTo( null );
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLayout(new BorderLayout());
	
	Object[][] jugadores = {
			{"Mark", "Evans", 1},
			{"Jude", "Sharp", 1},
			{"Axel", "Blaze", 1}
	};
	
	String [] columnas = {"Nombre", "Apellido", "Temporda"};
	
	JTable table = new JTable(jugadores, columnas);
	JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);
	
	
	setVisible(true);
	VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana jugadores");
	}
}
