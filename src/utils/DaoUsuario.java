package utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.Usuario;
import conexion.Conexion;

public class DaoUsuario {

	Conexion cx;
	
	public DaoUsuario() {
		cx = new Conexion();
	}
	
	public boolean insertarUsuario(Usuario usuario) {
		PreparedStatement ps = null;
		try {
			ps=cx.conectar().prepareStatement("INSERT INTO usuario VALUES(null,?,?,?,null)");
			ps.setString(1, usuario.getNombreUsuario());
			ps.setString(2, usuario.getPassword());
			ps.setString(3, usuario.getNombreReal());
			ps.setInt(4, usuario.getEdad());
			ps.executeUpdate();
			cx.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
