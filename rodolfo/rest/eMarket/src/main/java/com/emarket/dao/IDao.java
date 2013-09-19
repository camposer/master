package com.emarket.dao;

import java.util.List;

public interface IDao<T, K> {
	public void agregar(T obj);
	public void modificar(T obj);
	public void remover(K key);
	public T obtener(K key);
	public List<T> obtenerTodos();
}
