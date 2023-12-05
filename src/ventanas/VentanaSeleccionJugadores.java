package ventanas;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import clases.JugaCampo;
import clases.Jugador;
import clases.Portero;
import utils.LeerJugadorCampo;
import utils.Quimica;

public class VentanaSeleccionJugadores extends JFrame {
	protected static ArrayList<Portero> listaPorteros = new ArrayList<>();
	protected static ArrayList<JugaCampo> listaDefensas = new ArrayList<>();
	protected static ArrayList<JugaCampo> listaMediocentros = new ArrayList<>();
	protected static ArrayList<JugaCampo> listaDelanteros = new ArrayList<>();
	protected static ArrayList<Jugador> plantilla = new ArrayList<>();
	
	public VentanaSeleccionJugadores(int posicion, JLabel carta, String formacion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 400);
		JPanel panel = new JPanel(new GridLayout(1, 3, 12, 0));	

		
		if (listaPorteros.isEmpty()) {
			listaPorteros = LeerJugadorCampo.leerPorteros("Porteros.txt");
		}
		if (listaDefensas.isEmpty()) {
			listaDefensas = LeerJugadorCampo.leerJugaDefensas("Defensas.txt");

		}
		if (listaMediocentros.isEmpty()) {
			listaMediocentros = LeerJugadorCampo.leerJugaMediocentros("Mediocentros.txt");

		}
		if (listaDelanteros.isEmpty()) {
			listaDelanteros = LeerJugadorCampo.leerJugaDelanteros("Delanteros.txt");

		}
		
		
		switch (posicion) {
		case 1:
			setTitle("Seleccion de porteros");
			for (int i = 0; i < 3; i++) {
				double nrandom = Math.random();
				if (nrandom < (0.09)) {
					nrandom += (0.09);
				}
				Portero portero = listaPorteros.get((int) Math.floor((nrandom*listaPorteros.size())-1));
				String nombre = portero.getNombre();
				
				JLabel etiqueta = new JLabel();
				etiqueta.setBounds(0, 0, 325, 390);
				VentanaElegirPlantilla.SetImageLabel(etiqueta, "src/imagenes/Porteros/" + nombre +".png");
				etiqueta.repaint();
				
				etiqueta.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						plantilla.add(LeerJugadorCampo.listaPorterosTotales.get(portero.getID()-1));
						VentanaElegirPlantilla.SetImageLabel(carta, "src/imagenes/Porteros/" + nombre +".png");
						VentanaElegirPlantilla.numMaxClickPor = 0;
						if(plantilla.size() == 6) {
							VentanaElegirPlantilla.plantillaCompleta = true;
							VentanaElegirPlantilla.barraValoracion.setValue(Quimica.calcularValoracionFormacion(plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.barraQumica.setValue(Quimica.calcularQuimicaFormacion(formacion, plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
						}
						VentanaSeleccionJugadores.this.dispose();
						super.mouseClicked(e);
					}
					
				});
				panel.add(etiqueta);
				listaPorteros.remove(portero);
			}
			break;
		case 2:
			setTitle("Seleccion de defensas");
			for (int i = 0; i < 3; i++) {
				double nrandom = Math.random();
				if (nrandom < (0.05)) {
					nrandom += (0.05);
				}
				JugaCampo defensa = listaDefensas.get((int) Math.floor((nrandom*listaDefensas.size())-1));	
				String nombre = defensa.getNombre();
								
				JLabel etiqueta = new JLabel();
				etiqueta.setBounds(0, 0, 325, 390);
				VentanaElegirPlantilla.SetImageLabel(etiqueta, "src/imagenes/Defensas/" + nombre +".png");
				etiqueta.repaint();
				
				etiqueta.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						plantilla.add(LeerJugadorCampo.listaDefensasTotales.get(defensa.getID()-13));
						VentanaElegirPlantilla.SetImageLabel(carta, "src/imagenes/Defensas/" + nombre +".png");
						VentanaElegirPlantilla.numMaxClickDef -=1;
						if(plantilla.size() == 6) {
							VentanaElegirPlantilla.plantillaCompleta = true;
							VentanaElegirPlantilla.barraValoracion.setValue(Quimica.calcularValoracionFormacion(plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.barraQumica.setValue(Quimica.calcularQuimicaFormacion(formacion, plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
						}
						VentanaSeleccionJugadores.this.dispose();
						super.mouseClicked(e);
					}
					
				});
				panel.add(etiqueta);
				listaDefensas.remove(defensa);
			}
			
			break;
		case 3:
			setTitle("Seleccion de medios");
			for (int i = 0; i < 3; i++) {
				double nrandom = Math.random();
				if (nrandom < (0.05)) {
					nrandom += (0.05);
				}
				JugaCampo medio = listaMediocentros.get((int) Math.floor((nrandom*listaMediocentros.size())-1));
				String nombre = medio.getNombre();
				
				JLabel etiqueta = new JLabel();
				etiqueta.setBounds(0, 0, 325, 390);
				VentanaElegirPlantilla.SetImageLabel(etiqueta, "src/imagenes/Mediocentros/" + nombre +".png");
				etiqueta.repaint();
				
				etiqueta.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						plantilla.add(LeerJugadorCampo.listaMediocentrosTotales.get(medio.getID()-38));
						VentanaElegirPlantilla.SetImageLabel(carta, "src/imagenes/Mediocentros/" + nombre +".png");
						VentanaElegirPlantilla.numMaxClickMed -=1;
						if(plantilla.size() == 6) {
							VentanaElegirPlantilla.plantillaCompleta = true;
							VentanaElegirPlantilla.barraValoracion.setValue(Quimica.calcularValoracionFormacion(plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.barraQumica.setValue(Quimica.calcularQuimicaFormacion(formacion, plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
						}
						VentanaSeleccionJugadores.this.dispose();
						super.mouseClicked(e);
					}
					
				});
				panel.add(etiqueta);
				listaMediocentros.remove(medio);
			}
			break;
		case 4:
			setTitle("Seleccion de delanteros");
			for (int i = 0; i < 3; i++) {
				double nrandom = Math.random();
				if (nrandom < (0.05)) {
					nrandom += (0.05);
				}
				JugaCampo delantero = listaDelanteros.get((int) Math.floor((nrandom*listaDelanteros.size())-1));
				String nombre = delantero.getNombre();
				
				JLabel etiqueta = new JLabel();
				etiqueta.setBounds(0, 0, 325, 390);
				VentanaElegirPlantilla.SetImageLabel(etiqueta, "src/imagenes/Delanteros/" + nombre +".png");
				etiqueta.repaint();
				
				etiqueta.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						plantilla.add(LeerJugadorCampo.listaDelanterosTotales.get(delantero.getID()-(62)));
						VentanaElegirPlantilla.SetImageLabel(carta, "src/imagenes/Delanteros/" + nombre +".png");
						VentanaElegirPlantilla.numMaxClickDel -=1;
						if(plantilla.size() == 6) {
							VentanaElegirPlantilla.plantillaCompleta = true;
							VentanaElegirPlantilla.barraValoracion.setValue(Quimica.calcularValoracionFormacion(plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.barraQumica.setValue(Quimica.calcularQuimicaFormacion(formacion, plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
						}
						VentanaSeleccionJugadores.this.dispose();
						super.mouseClicked(e);
					}
					
				});
				panel.add(etiqueta);
				listaDelanteros.remove(delantero);
			}
			break;			
		default:
			break;
		}
		setLocationRelativeTo( null );
		setResizable(false);
		
		
		add(panel);
		
		setVisible(true);
		
	}
	
}
