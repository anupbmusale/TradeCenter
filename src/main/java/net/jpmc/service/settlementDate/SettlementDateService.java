package net.jpmc.service.settlementDate;

import java.time.LocalDate;

import net.jpmc.constant.CurrencyType;

public interface SettlementDateService {
	/*
	 * This method get working day based on currency
	 * 
	 */
	public LocalDate getWorkingDay(LocalDate settlementDate, CurrencyType currencyType);
}
