package net.jpmc.factory.dao;

import net.jpmc.dao.TradeCenterDao;

public interface Daofactory {

	public TradeCenterDao createDaoImpl(String daoRefKey);
}
