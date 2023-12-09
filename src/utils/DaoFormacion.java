package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import conexion.Conexion;

public class DaoFormacion {

	Conexion cx;
	
	public DaoFormacion() {
		cx = new Conexion();
	}
	
	public boolean insertarFormacion(int usuario, String formacion, int quimica, int valoracion, int valoraciontotal, int jugador1, int jugador2, int jugador3,
									int jugador4, int jugador5, int jugador6) {
		PreparedStatement ps = null;
		try {
			ps=cx.conectar().prepareStatement("INSERT INTO formacion VALUES(null,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, usuario);
			ps.setString(2, formacion);
			ps.setInt(3, quimica);
			ps.setInt(4, valoracion);
			ps.setInt(5, valoraciontotal);
			ps.setInt(6, jugador1);
			ps.setInt(7, jugador2);
			ps.setInt(8, jugador3);
			ps.setInt(9, jugador4);
			ps.setInt(10, jugador5);
			ps.setInt(11, jugador6);
			
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
