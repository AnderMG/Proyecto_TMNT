package ventanas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.FondoEnVentana;

public class VentanaFormacion extends JFrame{
	
	private JPanel contentPane;
	private JPanel panelFormacion = new JPanel();
	private ArrayList<String> formaciones = new ArrayList<>();

	public VentanaFormacion() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 500);
		setTitle("Formacion");
		setLocationRelativeTo( null );
		contentPane = new JPanel();
		contentPane = FondoEnVentana.panelConFondo("terrenoJuego.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Añadimos un label
		JLabel etiquetaIndicacion = new JLabel("Elige una de las siguientes formaciones para iniciar el juego", SwingConstants.CENTER);
		etiquetaIndicacion.setBounds(20, -4, 340, 25);
		etiquetaIndicacion.setForeground(Color.BLACK);
		
		//Añadimos las formaciones
		formaciones.add("3-1-1");
		formaciones.add("2-2-1");
		formaciones.add("2-1-2");
		formaciones.add("1-2-2");
		formaciones.add("1-3-1");
		
		
		//Quitamos 2 formaciones de manera aleatoria y creamos 3 botones con las restantes
		for (int i = 0; i < 2; i++) {
			int p = (int)(Math.floor(Math.random()*(5-i)));
			formaciones.remove(p);
		}
		JButton btnFor1 = new JButton(formaciones.get(0));
		btnFor1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.logger.log(Level.FINE, "Se ha elegido la primera formacion");
				new VentanaElegirPlantilla(btnFor1.getText());
				dispose();
			}
		});
		
		JButton btnFor2 = new JButton(formaciones.get(1));
		btnFor2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.logger.log(Level.FINE, "Se ha elegido la segunda formacion");
				new VentanaElegirPlantilla(btnFor2.getText());
				dispose();
			}
		});
		
		JButton btnFor3 = new JButton(formaciones.get(2));
		btnFor3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.logger.log(Level.FINE, "Se ha elegido la tercera formacion");
				new VentanaElegirPlantilla(btnFor3.getText());
				dispose();
			}
		});
		
		//Creamos el panel y añadimos los botones
		contentPane.add(panelFormacion);
		panelFormacion.setBounds(218, 60, 373, 292);
		panelFormacion.setOpaque(false);
		panelFormacion.setLayout(null);
		panelFormacion.add(etiquetaIndicacion);
		btnFor1.setBounds(25, 65, 329, 33);
		panelFormacion.add(btnFor1);
		btnFor2.setBounds(25, 160, 329, 33);
		panelFormacion.add(btnFor2);
		btnFor3.setBounds(25, 255, 329, 33);
		panelFormacion.add(btnFor3);
		btnFor1.setBackground(Color.GREEN);
		btnFor2.setBackground(Color.GREEN);
		btnFor3.setBackground(Color.GREEN);
		
		add(panelFormacion, BorderLayout.CENTER);
		
		setVisible(true);
		VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana formacion");
	}
}