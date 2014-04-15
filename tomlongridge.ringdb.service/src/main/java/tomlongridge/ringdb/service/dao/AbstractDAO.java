package tomlongridge.ringdb.service.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
public abstract class AbstractDAO<T> implements DAO<T>
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(long id)
	{
		return (T) getSessionFactory().getCurrentSession().get(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> retrieveAll()
	{
		final Query query = getSessionFactory().getCurrentSession().createQuery("FROM " + clazz.getSimpleName());
		return (List<T>) query.list();
	}
	
	@Override
	public T save(T t)
	{
		getSessionFactory().getCurrentSession().saveOrUpdate(t);
		return t;
	}
	
	public void setClazz(Class<T> clazz)
	{
		this.clazz = clazz;
	}

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


}
