package com.indra.formacion.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.indra.formacion.jdbc.ConnectionFactory;

public class TransactionProxy { 
	@Autowired
	private ConnectionFactory connectionFactory;
	private Connection con;
	
	public void init() {
		try {
			con = connectionFactory.createConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			System.err.println("Error abriendo la conexión");
			e.printStackTrace();
		}		
	}
	
	public void join(BaseDao dao) {
		dao.setConexion(con);
		dao.setAutoCommit(false);
	}
	
	public void commit() throws SQLException {
		con.commit();
	}

	public void rollback() throws SQLException {
		con.rollback();
	}

	public void cerrarConexion() throws SQLException {
		con.close();
	}

	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

}
