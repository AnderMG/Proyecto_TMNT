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
			{"Mark", "Evans", 1, "Portero", "Montañia", 94},
			{"Darren", "Lachance", 2, "Portero", "Bosque", 88},
			{"Dvalin", null, 2, "Portero", "Fuego", 87},
			{"Gigi", "Blasi", 3, "Portero", "Aire", 87},
			{"Hector", "Helio", 3, "Portero", "Montañia", 92},
			{"Joseph", "King", 1, "Portero", "Fuego", 85},
			{"Lars", "Luceafar", 3, "Portero", "Montañia", 90},
			{"Nero", null, 1, "Portero", "Aire", 88},
			{"Preston", "Princeton", 4, "Portero", "Bosque", 83},
			{"Quentin", "Cinquedea", 4, "Portero", "Fuego", 89},
			{"Terry", "Archibald", 6, "Portero", "Aire", 91},
			{"Thomas", "Feldt", 1, "Portero", "Bosque", 75},
			{"Aitor", "Cazador", 4, "Defensa", "Bosque", 86},
			{"Archer", "Hawkins", 3, "Defensa", "Aire", 84},
			{"Ares", null, 1, "Defensa", "Montañia", 80},
			{"Bilal", "Kalil", 3, "Defensa", "Bosque", 85},
			{"Bobby", "Shearer", 1, "Defensa", "Bosque", 83},
			{"Franck", "Foreman", 6, "Defensa", "Fuego", 83},
			{"Gabriel", "Garcia", 4, "Defensa", "Bosque", 89},
			{"Hurley", "Kane", 2, "Defensa", "Aire", 84},
			{"Jack", "Wallside", 1, "Defensa", "Montañia", 86},
			{"JP", "Lapin", 4, "Defensa", "Montañia", 84},
			{"Keenan", "Sharpe", 6, "Defensa", "Montañia", 86},
			{"Kiburn", null, 2, "Defensa", "Fuego", 84},
			{"Lephiel", null, 3, "Defensa", "Montañia", 85},
			{"Paul", "Peabody", 4, "Defensa", "Aire", 76},
			{"Scotty", "Banyan", 2, "Defensa", "Bosque", 82},
			{"Sor", null, 5, "Defensa", "Aire", 82},
			{"Subaru", "Honda", 6, "Defensa", "Fuego", 82},
			{"Tiago", "Torres", 3, "Defensa", "Fuego", 88},
			{"Tod", "Iron", 1, "Defensa", "Fuego", 77},
			{"Tina", "Verdure", 6, "Defensa", "Bosque", 90},
			{"Wanli", "Chancheng", 4, "Defensa", "Montañia", 83},
			{"Zippy", "Lerner", 6, "Defensa", "Aire", 82},
			{"Iggie", "Loo", 4, "Defensa", "Aire", 85},
			{"Goldie", "Lemmon", 5, "Defensa", "Fuego", 91},
			{"Jude", "Sharp", 1, "Medio", "Aire", 93},
			{"Ade", "Kebe", 4, "Medio", "Aire", 83},
			{"Arion", "Sherwind", 4, "Medio", "Aire", 93},
			{"Asuto", "Inamori", 1, "Medio", "Fuego", 90},
			{"Bay", "Laurel", 4, "Medio", "Montañia", 89},
			{"Byron", "Love", 1, "Medio", "Bosque", 92},
			{"Caleb", "Stonewall", 2, "Medio", "Fuego", 88},
			{"Cerise", "Blossom", 6, "Medio", "Aire", 82},
			{"Changsu", "Choi", 3, "Medio", "Fuego", 87},
			{"Circulus", "Rugu", 6, "Medio", "Fuego", 91},
			{"Cronus", "Fourseasons", 4, "Medio", "Fuego", 89},
			{"Desmodus", "Drakul", 5, "Medio", "Montañia", 90},
			{"Erik", "Eagle", 1, "Medio", "Bosque", 90},
			{"Fei", "Rune", 5, "Medio", "Bosque", 90},
			{"Harrold", "Houdini", 4, "Medio", "Bosque", 88},
			{"Hidetoshi", "Nakata", 3, "Medio", "Montañia", 93},
			{"Julien", "Rosseau", 3, "Medio", "Montañia", 84},
			{"Nathan", "Swift", 1, "Medio", "Aire", 90},
			{"Nosaka", "Yuuma", 1, "Medio", "Montañia", 92},
			{"Paolo", "Bianchi", 3, "Medio", "Bosque", 93},
			{"Riccardo", "Di Rigo", 4, "Medio", "Bosque", 92},
			{"Ryoma", "Nishiki", 4, "Medio", "Montañia", 86},
			{"Sol", "Daystar", 4, "Medio", "Fuego", 93},
			{"Victoria", "Vanguard", 2, "Medio", "Aire", 83},
			{"Axel", "Blaze", 1, "Delantero", "Fuego", 93}
			
	};
	
	String [] columnas = {"Nombre", "Apellido", "Temporda", "Posicion", "Afinidad", "Media"};
	
	JTable table = new JTable(jugadores, columnas);
	JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane, BorderLayout.CENTER);
	
	
	setVisible(true);
	VentanaPrincipal.logger.log(Level.FINEST, "Se ha abierto la ventana jugadores");
	}
}
