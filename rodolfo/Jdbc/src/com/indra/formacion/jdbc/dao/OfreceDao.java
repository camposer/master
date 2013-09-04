package com.indra.formacion.jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.indra.formacion.jdbc.model.Libreria;
import com.indra.formacion.jdbc.model.Libro;
import com.indra.formacion.jdbc.model.Ofrece;

public class OfreceDao extends BaseDao implements IOfreceDao {

	@Override
	public void agregar(Ofrece ofrece) throws SQLException {
		if (autoCommit)
			abrirConexion();
		
		String sql = "INSERT INTO ofrece(libro_id, libreria_id, precio) VALUES(?, ?, ?)";

		PreparedStatement pstmt = con.prepareStatement(sql,
				PreparedStatement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, ofrece.getLibro().getId());
		pstmt.setInt(2, ofrece.getLibreria().getId());
		pstmt.setFloat(3, ofrece.getPrecio());

		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if (rs.next())
			ofrece.setId(rs.getInt(1));

		if (autoCommit)
			cerrarConexion();
	}

	@Override
	public void modificar(Ofrece obj) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Integer clave) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Ofrece obtener(Integer clave) throws SQLException {
		if (autoCommit)
			abrirConexion();
		
		Ofrece ofrece = null;

		String sql = "SELECT l.id AS libro_id, l.titulo, l.autor, l.precio AS libro_precio, "
				+ "o.precio ofrece_precio, libr.id AS libreria_id, libr.cif, libr.nombre, "
				+ "o.id AS ofrece_id, libr.direccion "
				+ "FROM ofrece o "
				+ "INNER JOIN libro l ON l.id = o.libro_id "
				+ "INNER JOIN libreria libr ON libr.id = o.libreria_id "
				+ "WHERE o.id = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, clave);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Libro libro = new Libro(rs.getString("titulo"),
					rs.getString("autor"), rs.getFloat("libro_precio"));
			libro.setId(rs.getInt("libro_id"));

			Libreria libreria = new Libreria(rs.getString("cif"),
					rs.getString("nombre"), rs.getString("direccion"));
			libreria.setId(rs.getInt("libreria_id"));

			ofrece = new Ofrece(libro, libreria, rs.getFloat("ofrece_precio"));
			ofrece.setId(rs.getInt("ofrece_id"));
		}

		if (autoCommit)
			cerrarConexion();
		
		return ofrece;
	}

	@Override
	public List<Ofrece> obtenerTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(new OfreceDao().obtener(1));
	}
}
