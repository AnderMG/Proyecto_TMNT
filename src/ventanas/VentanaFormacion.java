package ventanas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaFormacion extends JFrame{
	private JPanel panelFormacion = new JPanel();
	private ArrayList<String> formaciones = new ArrayList<>();

	public VentanaFormacion() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(800, 500);
		setLayout(new BorderLayout());
		setTitle("Formacion");
		
		//Añadimos un label
		JLabel etiquetaIndicacion = new JLabel("Elige una de las siguientes formaciones para iniciar el juego", SwingConstants.CENTER);
		add(etiquetaIndicacion, BorderLayout.NORTH);
		
		//Añadimos las formaciones
		formaciones.add("3-1-1");
		formaciones.add("2-2-1");
		formaciones.add("2-1-2");
		formaciones.add("1-2-2");
		formaciones.add("1-3-1");
		setLocationRelativeTo( null );
		
		//Quitamos 2 formaciones de manera aleatoria y creamos 3 botones con las restantes
		for (int i = 0; i < 2; i++) {
			int p = (int)(Math.floor(Math.random()*(5-i)));
			formaciones.remove(p);
		}
		JButton btnFor1 = new JButton(formaciones.get(0));
		btnFor1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaElegirPlantilla(btnFor1.getText());
				dispose();
			}
		});
		
		JButton btnFor2 = new JButton(formaciones.get(1));
		btnFor2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaElegirPlantilla(btnFor2.getText());
				dispose();
			}
		});
		
		JButton btnFor3 = new JButton(formaciones.get(2));
		btnFor3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaElegirPlantilla(btnFor3.getText());
				dispose();
			}
		});
		
		//Creamos el panel y añadimos los botones
		panelFormacion.setLayout(new GridLayout(3, 1, 0, 10));
		panelFormacion.add(btnFor1);
		panelFormacion.add(btnFor2);
		panelFormacion.add(btnFor3);
		
		add(panelFormacion, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
}
