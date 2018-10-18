package net.jpmc.service.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.jpmc.constant.InstructionType;
import net.jpmc.model.TradeReport;

public interface TradeReportService {
	
	/**
	 * This method generate trade report in descending order of amount 
	 * 
	 * @param settlementDate
	 * @return
	 */
	public Map<InstructionType, List<TradeReport>> generateTradeReport();
	
}
