package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conection {
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/israel_fes_aragon"; 
																				// de Datos
	public static final String USERNAME = "root"; 
													
	public static final String PASSWORD = "5627519983"; 
															
	
	PreparedStatement ps;
	ResultSet rs;

	public static void main(String[] args) {
		conection conection = new conection();
		conection.ActionPerformed();
	}

	
	public static Connection getConection() {
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
																					// mandan los datos
			JOptionPane.showMessageDialog(null, "Conexion exitosa");

		} catch (Exception e) {

			System.out.println("fallo");
		}
		return con;
	}

	private void ActionPerformed() {

		Connection con = null;

		try {

			con = getConection();
			ps = con.prepareStatement("SELECT * FROM persona WHERE telefono = 5627519983");
			
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Nombre de usuario: " + rs.getString(1) + ", Carrera: " + rs.getString(2)
						+ ", Numero de cuenta: " + rs.getInt(3) + ", Direccion: " + rs.getString(4) + ", Telefono: "
						+ rs.getString(5) + ", Email: " + rs.getString(6) + ", Password: " + rs.getString(7)
						+ ", Fecha de registro " + rs.getDate(8) + ", Permisos: " + rs.getInt(9));

			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		try {
			rs.close();
			ps.close();
                        con.close();
		} catch (SQLException e) {
			
                        e.printStackTrace();
		}

	}

}
