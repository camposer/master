package com.indra.formacion.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.indra.formacion.jdbc.ConnectionFactory;

public abstract class BaseDao {
	// TODO: Resolver cómo sería sin autowired
	protected ConnectionFactory connectionFactory; 
	protected boolean autoCommit;
	protected Connection con;
	
	public BaseDao() {
		this.autoCommit = true;
	}
	
	protected void abrirConexion() throws SQLException {
		con = connectionFactory.createConnection();
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

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	
}
