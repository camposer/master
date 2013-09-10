package com.indra.formacion.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.indra.formacion.jdbc.model.Libreria;

public class LibreriaDao extends BaseDao implements ILibreriaDao {

	@Override
	public void agregar(Libreria obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Libreria obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer clave) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Libreria obtener(Integer clave) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libreria> obtenerTodos() throws SQLException {
		if (autoCommit)
			abrirConexion();
		
		List<Libreria> librerias = new LinkedList<Libreria>();
		
		String sql = "SELECT * FROM libreria";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Libreria l = new Libreria(rs.getString("cif"), rs.getString("nombre"), rs.getString("direccion"));
			l.setId(rs.getInt("id"));
			
			librerias.add(l);
		}
		
		if (autoCommit)
			cerrarConexion();
		
		return librerias;
	}


}
