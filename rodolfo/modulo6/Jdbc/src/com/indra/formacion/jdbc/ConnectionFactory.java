package com.indra.formacion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static final String URL_BD = "jdbc:mysql://localhost/test";
	public static final String USUARIO_BD = "root";
	public static final String CLAVE_BD = "";
	protected Connection con;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error cargando el driver");
			e.printStackTrace();
		}
	}
	
	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection(URL_BD, USUARIO_BD, CLAVE_BD);
	}
}
