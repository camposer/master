package com.indra.formacion.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {
	public static final String URL_BD = "jdbc:mysql://localhost/test";
	public static final String USUARIO_BD = "root";
	public static final String CLAVE_BD = "";
	protected Connection con;
	protected boolean autoCommit;
	
	public BaseDao() {
		this.autoCommit = true;
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error cargando el driver");
			e.printStackTrace();
		}
	}
	
	protected void abrirConexion() throws SQLException {
		// Cómo inyecto esto?
		con = DriverManager.getConnection(URL_BD, USUARIO_BD, CLAVE_BD);
	}

	protected void cerrarConexion() throws SQLException {
		con.close();
	}
	
	public Connection getConexion() {
		return con;
	}

	public void setConexion(Connection con) {
		this.con = con;
	}

	public boolean isAutoCommit() {
		return autoCommit;
	}

	public void setAutoCommit(boolean autoCommit) {
		this.autoCommit = autoCommit;
	}

}
