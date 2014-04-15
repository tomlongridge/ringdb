package tomlongridge.ringdb.service.dao.impl;

import org.springframework.stereotype.Repository;

import tomlongridge.ringdb.service.dao.AbstractDAO;
import tomlongridge.ringdb.service.dao.CountryDAO;
import tomlongridge.ringdb.service.domain.Country;

@Repository
public class CountryDAOImpl extends AbstractDAO<Country> implements CountryDAO
{
	public CountryDAOImpl()
	{
		setClazz(Country.class);
	}
	
}
