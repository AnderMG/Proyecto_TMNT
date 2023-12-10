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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import utils.CargarJugadores;
import utils.FondoEnVentana;
	

public class VentanaJugadores extends JFrame{

	private JPanel contentPane;
	private DefaultTableModel modelo;
	private JTable tabla;
	private Thread hiloScroll;
	
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
	
	//modelo de datos, no es editable//
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
	
	//Renderizado de la tabla//
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
    
    JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
    
	setVisible(true);
	VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana jugadores");
	iniciarHiloScroll(verticalBar);
	
	addWindowListener(new WindowAdapter() {

		@Override
		public void windowClosed(WindowEvent e) {
			hiloScroll.interrupt();
			super.windowClosed(e);
		}
		
	});
	
	}
//Metodo para iniciar/definir el hilo//
	private void iniciarHiloScroll(JScrollBar scb) {
		hiloScroll = new Thread(new Runnable() {
	    	@Override
			public void run() {	
				try {
					while (true) {	
						int posAct = scb.getValue();
						int altIncremento = VentanaJugadores.this.size().height-500;
				    	
						if (posAct < (962-altIncremento)) {
							scb.setValue(posAct+1);		
							Thread.sleep(35);
						}else {
							scb.setValue(scb.getMinimum());
							Thread.sleep(2000);
						}
					}
				}catch(InterruptedException e){
					VentanaPrincipal.logger.log(Level.FINEST, "Hilo de ventana de juagdores interrupido");
				}			
			}
	    });
		hiloScroll.start();
}}