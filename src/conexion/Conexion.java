package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.MetodosProperties;

public class Conexion {

		Connection cx=null;
		
		public	Connection conectar() {
			try {
				Class.forName("org.sqlite.JDBC");
				cx=DriverManager.getConnection("jdbc:sqlite:" + MetodosProperties.lecturaProperties("nombre.bd"));
				System.out.println("Conexion aceptada");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Conexion no aceptada");
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println("Conexion no aceptada");
			}
			return cx;
		}
		
		public void desconectar() {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void main(String [] args) {
			
			Conexion cx=new Conexion();
			cx.conectar();
		}
}
