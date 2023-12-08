package ventanas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import clases.Jugador;
import clases.Posicion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import utils.CargarJugadores;
import utils.FondoEnVentana;
	

public class VentanaJugadores extends JFrame{

	private JPanel contentPane;
	private JPanel panelJugadores = new JPanel();
	private DefaultTableModel modelo;
	private JTable tabla;
	
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
	
	
	String [] columnas = {"Nombre", "Apellido", "Temporda", "Afinidad", "Media"};
	
	modelo = new DefaultTableModel(columnas, 0) {

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

		@Override
		public Object getValueAt(int row, int column) {
			return super.getValueAt(row, column);
		}
		
	};
	//añadir al modelo el mapa de jugadores//
	HashMap<Posicion, ArrayList<Jugador>> mapaVentanaJugadores = CargarJugadores.CargarMapaJugadores();
	Posicion posi = null;
	for (ArrayList<Jugador> p : mapaVentanaJugadores.values()) {
		for (Jugador j: p){
			if (posi != j.getPosicion()) {
				modelo.addRow(new Object[] {j.getPosicion()+"S", "", "", "", "", ""});
				posi = j.getPosicion();
				modelo.addRow(new Object[] {j.getNombre(), j.getApellido(), j.getTemporada(), j.getElemento(), j.getMedia()});
			}else {
				modelo.addRow(new Object[] {j.getNombre(), j.getApellido(), j.getTemporada(), j.getElemento(), j.getMedia()});
			}
		}
	};
	
	tabla = new JTable(modelo);
	tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if("".equals(modelo.getValueAt(row, 3))) {
				c.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
				c.setBackground(Color.orange);
			}else {
				c.setBackground(Color.white);
			}
			return c;
		}
		
		
	});
	
	JScrollPane scrollPane = new JScrollPane(tabla);
    add(scrollPane, BorderLayout.CENTER);
    

	setVisible(true);
	VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana jugadores");
	iniciarHiloScroll(scrollPane);
	
	addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosed(WindowEvent e) {
			super.windowClosed(e);
		}
		
	});
	
	}

	private void iniciarHiloScroll(JScrollPane sc) {
		Thread hiloScroll = new Thread(new Runnable() {
	    	@Override
			public void run() {	
				try {
					while (true) {	
						int posAct = sc.getVerticalScrollBar().getValue();
				    	int posMax = sc.getVerticalScrollBar().getMaximum(); 
				    	
						if (posAct < posMax) {
							sc.getVerticalScrollBar().setValue(posAct+1);		
							Thread.sleep(35);
						}else {
							sc.getVerticalScrollBar().setValue(sc.getVerticalScrollBar().getMinimum());
							Thread.sleep(1500);
						}
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}			
			}
	    });
		hiloScroll.start();
}}