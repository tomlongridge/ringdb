package tomlongridge.ringdb.service.dao.impl;

import org.springframework.stereotype.Repository;

import tomlongridge.ringdb.service.dao.AbstractDAO;
import tomlongridge.ringdb.service.dao.TowerDAO;
import tomlongridge.ringdb.service.domain.Tower;

@Repository
public class TowerDAOImpl extends AbstractDAO<Tower> implements TowerDAO
{
	public TowerDAOImpl() {
		setClazz(Tower.class);
	}
	
}
