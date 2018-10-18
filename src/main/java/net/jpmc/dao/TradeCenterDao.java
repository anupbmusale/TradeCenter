package net.jpmc.dao;

import java.util.Date;
import java.util.List;

import net.jpmc.model.Instruction;

public interface TradeCenterDao {
	/**
	 * This method generate trade report for particular date
	 * 
	 * @param settlementDate
	 * @return
	 */
	public List<Instruction> getInstructionsByDate(Date settlementDate);
	
	/**
	 * This method generate trade report for date range
	 * 
	 * @param fromSettlementDate
	 * @param toSettlementDate
	 * @return
	 */
	
	/**
	 * This method persist trade batch to DB
	 * 
	 * @param trades
	 */
	public void createTrade(List<Instruction> instructions);

}
