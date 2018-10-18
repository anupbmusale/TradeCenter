package net.jpmc.service.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.jpmc.constant.InstructionType;
import net.jpmc.dao.TradeCenterDao;
import net.jpmc.model.Instruction;
import net.jpmc.model.TradeReport;

/**
 * This class generate report
 */
public class TradeReportServiceImpl implements TradeReportService {
	
	private TradeCenterDao tradeCenterDao;
	
	public TradeReportServiceImpl(TradeCenterDao tradeCenterDao) {
		this.tradeCenterDao = tradeCenterDao;
	}

	/**
	 * This method generate trade report by instruction type for date
	 * 
	 * @param settlementDate
	 * @return
	 */
	public Map<InstructionType, List<TradeReport>> generateTradeReport() {
		Map<InstructionType, List<TradeReport>> tradeReport = null;
		try {
			List<Instruction> instructions = tradeCenterDao.getInstructions();
			tradeReport = TradeReportHelper.generateTradeReport(instructions);
		} catch (Exception e) {
			System.out.println("Exception while generating report");
		}
		return tradeReport;
	}
}
