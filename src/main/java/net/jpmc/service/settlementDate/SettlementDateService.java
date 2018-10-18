package net.jpmc.service.settlementDate;

import java.util.Date;

import net.jpmc.constant.CurrencyType;

public interface SettlementDateService {
	/*
	 * This method get working day based on currency
	 * 
	 */
	public Date getWorkingDay(Date settlementDate, CurrencyType currencyType);
}
