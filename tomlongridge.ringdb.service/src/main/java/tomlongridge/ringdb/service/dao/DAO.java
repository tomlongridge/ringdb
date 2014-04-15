package tomlongridge.ringdb.service.dao;

import java.util.List;

public interface DAO<T>
{
	T retrieve(long id);
	List<T> retrieveAll();
	T save(T t);
}
