package com.man.urlshortner.service;

public interface CrudService<T> {

	public T create(T obj);

	public T update(T obj, int id);

	public T delete(int id);

	public T get(int id);

}
