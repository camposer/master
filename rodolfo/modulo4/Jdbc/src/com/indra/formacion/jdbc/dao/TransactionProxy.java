package com.indra.formacion.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionProxy {
	private Connection con;
	
	public TransactionProxy() {
		try {
			con = DriverManager.getConnection(BaseDao.URL_BD, BaseDao.USUARIO_BD, BaseDao.CLAVE_BD);
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
}
