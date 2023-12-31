package ventanas;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;import java.util.Comparator;
import java.util.Random;
import java.util.logging.Level;

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
import utils.MetodosProperties;
import utils.Quimica;

import utils.DaoFormacion;

public class VentanaSeleccionJugadores extends JFrame {
	protected static ArrayList<Portero> listaPorteros = new ArrayList<>();
	protected static ArrayList<JugaCampo> listaDefensas = new ArrayList<>();
	protected static ArrayList<JugaCampo> listaMediocentros = new ArrayList<>();
	protected static ArrayList<JugaCampo> listaDelanteros = new ArrayList<>();
	protected static ArrayList<Jugador> plantilla = new ArrayList<>();
	
	public VentanaSeleccionJugadores(int posicion, JLabel carta, String formacion) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(1000, 400);
		JPanel panel = new JPanel(new GridLayout(1, 3, 0, 0));	

		//Nos aseguramos de que las listas tengan el tamaño/contenido adecuado//
		if (listaPorteros.isEmpty()) {
			listaPorteros = LeerJugadorCampo.leerPorteros(MetodosProperties.lecturaProperties("FicPor"));
			if (listaPorteros.size() > 12) {
				for (int i = listaPorteros.size()-1; i>11; i--) {
					listaPorteros.remove(i);
				}
			}
		}
		if (listaDefensas.isEmpty()) {
			listaDefensas = LeerJugadorCampo.leerJugaDefensas(MetodosProperties.lecturaProperties("FicDef"));
			if (listaDefensas.size() > 24) {
				for (int i = listaDefensas.size()-1; i>23; i--) {
					listaDefensas.remove(i);
				}
			}
		}
		if (listaMediocentros.isEmpty()) {
			listaMediocentros = LeerJugadorCampo.leerJugaMediocentros(MetodosProperties.lecturaProperties("FicMed"));
			if (listaMediocentros.size() > 24) {
				for (int i = listaMediocentros.size()-1; i>23; i--) {
					listaMediocentros.remove(i);
				}
			}
		}
		if (listaDelanteros.isEmpty()) {
			listaDelanteros = LeerJugadorCampo.leerJugaDelanteros(MetodosProperties.lecturaProperties("FicDel"));
			if (listaDelanteros.size() > 23) {
				for (int i = listaDelanteros.size()-1; i>22; i--) {
					listaDelanteros.remove(i);
				}
			}
		}
		
		Comparator<Jugador> compararID = (j1, j2) -> {
			return Integer.compare(j1.getID(), j2.getID());
		};
				
		
		//4 casos en base a la posicion que se quiere elegir//
		//se escogen 3 jugadores de la lista de los jugadores de dicha posicion//
		//en base al jugador elegido se cambio la carta de la plantilla con la imagen del jugador elegido//
		//si este jugador completa la plantilla (6 jugadores), se añade la valoracion y la quimica //
		switch (posicion) {
		case 1:
			setTitle("Seleccion de porteros");
			VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana de seleccionar porteros");
			for (int i = 0; i < 3; i++) {
				Random random = new Random();
				int r = random.nextInt(listaPorteros.size());
				Portero portero = listaPorteros.get(r);
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
							Collections.sort(plantilla, compararID);
							VentanaElegirPlantilla.plantillaCompleta = true;
							VentanaElegirPlantilla.barraValoracion.setValue(Quimica.calcularValoracionFormacion(plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.barraQumica.setValue(Quimica.calcularQuimicaFormacion(formacion, plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.etiquetaValoracion.setText("Valoracion: " + VentanaElegirPlantilla.barraValoracion.getValue());
							VentanaElegirPlantilla.etiquetaQuimica.setText("Quimica: " + VentanaElegirPlantilla.barraQumica.getValue());						
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
			VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana de seleccionar defensas");
			for (int i = 0; i < 3; i++) {
				Random random = new Random();
				int r = random.nextInt(listaDefensas.size());
				JugaCampo defensa = listaDefensas.get(r);	
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
							Collections.sort(plantilla, compararID);
							VentanaElegirPlantilla.plantillaCompleta = true;
							VentanaElegirPlantilla.barraValoracion.setValue(Quimica.calcularValoracionFormacion(plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.barraQumica.setValue(Quimica.calcularQuimicaFormacion(formacion, plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.etiquetaValoracion.setText("Valoracion: " + VentanaElegirPlantilla.barraValoracion.getValue());
							VentanaElegirPlantilla.etiquetaQuimica.setText("Quimica: " + VentanaElegirPlantilla.barraQumica.getValue());							
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
			VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana de seleccionar medios");
			for (int i = 0; i < 3; i++) {
				Random random = new Random();
				int r = random.nextInt(listaMediocentros.size());
				JugaCampo medio = listaMediocentros.get(r);
				String nombre = medio.getNombre();
				
				JLabel etiqueta = new JLabel();
				etiqueta.setBounds(0, 0, 325, 390);
				VentanaElegirPlantilla.SetImageLabel(etiqueta, "src/imagenes/Mediocentros/" + nombre +".png");
				etiqueta.repaint();
				
				etiqueta.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						plantilla.add(LeerJugadorCampo.listaMediocentrosTotales.get(medio.getID()-37));
						VentanaElegirPlantilla.SetImageLabel(carta, "src/imagenes/Mediocentros/" + nombre +".png");
						VentanaElegirPlantilla.numMaxClickMed -=1;
						if(plantilla.size() == 6) {
							Collections.sort(plantilla, compararID);
							VentanaElegirPlantilla.plantillaCompleta = true;
							VentanaElegirPlantilla.barraValoracion.setValue(Quimica.calcularValoracionFormacion(plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.barraQumica.setValue(Quimica.calcularQuimicaFormacion(formacion, plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.etiquetaValoracion.setText("Valoracion: " + VentanaElegirPlantilla.barraValoracion.getValue());
							VentanaElegirPlantilla.etiquetaQuimica.setText("Quimica: " + VentanaElegirPlantilla.barraQumica.getValue());
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
			VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana de seleccionar delanteros");
			for (int i = 0; i < 3; i++) {
				Random random = new Random();
				int r = random.nextInt(listaDelanteros.size());
				JugaCampo delantero = listaDelanteros.get(r);
				String nombre = delantero.getNombre();
				
				JLabel etiqueta = new JLabel();
				etiqueta.setBounds(0, 0, 325, 390);
				VentanaElegirPlantilla.SetImageLabel(etiqueta, "src/imagenes/Delanteros/" + nombre +".png");
				etiqueta.repaint();
				
				etiqueta.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						plantilla.add(LeerJugadorCampo.listaDelanterosTotales.get(delantero.getID()-(61)));
						VentanaElegirPlantilla.SetImageLabel(carta, "src/imagenes/Delanteros/" + nombre +".png");
						VentanaElegirPlantilla.numMaxClickDel -=1;
						if(plantilla.size() == 6) {
							Collections.sort(plantilla, compararID);
							VentanaElegirPlantilla.plantillaCompleta = true;
							VentanaElegirPlantilla.barraValoracion.setValue(Quimica.calcularValoracionFormacion(plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.barraQumica.setValue(Quimica.calcularQuimicaFormacion(formacion, plantilla.get(0), plantilla.get(1), plantilla.get(2), plantilla.get(3), plantilla.get(4), plantilla.get(5)));
							VentanaElegirPlantilla.etiquetaValoracion.setText("Valoracion: " + VentanaElegirPlantilla.barraValoracion.getValue());
							VentanaElegirPlantilla.etiquetaQuimica.setText("Quimica: " + VentanaElegirPlantilla.barraQumica.getValue());
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
