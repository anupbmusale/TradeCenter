package net.jpmc.factory.dao;

import net.jpmc.constant.TradeCenterConstant;
import net.jpmc.dao.TradeCenterDao;
import net.jpmc.dao.TradeCenterDaoImpl;

public class DaoFactoryImpl implements Daofactory {

	@Override
	public TradeCenterDao createDaoImpl(String daoRefKey) {
		TradeCenterDao tradeCenterDao = null;
		if (TradeCenterConstant.DAO_REF_KEY.equalsIgnoreCase(daoRefKey)) {
			tradeCenterDao = new TradeCenterDaoImpl();
		}
		return tradeCenterDao;
	}

}
