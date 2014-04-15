package tomlongridge.ringdb.service.dao.impl;

import org.springframework.stereotype.Repository;

import tomlongridge.ringdb.service.dao.AbstractDAO;
import tomlongridge.ringdb.service.dao.CountyDAO;
import tomlongridge.ringdb.service.domain.County;

@Repository
public class CountyDAOImpl extends AbstractDAO<County> implements CountyDAO
{
	public CountyDAOImpl() {
		setClazz(County.class);
	}
	
}
