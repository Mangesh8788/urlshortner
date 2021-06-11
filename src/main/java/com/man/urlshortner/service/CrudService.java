package com.man.urlshortner.service;

public interface CrudService<T> {

	public String create(T obj);

	public String update(T obj, int id);

	public String delete(int id);

	public T get(int id);

}
