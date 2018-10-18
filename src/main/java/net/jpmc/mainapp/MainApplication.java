package net.jpmc.mainapp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.jpmc.constant.InstructionType;
import net.jpmc.dao.TradeCenterDaoImpl;
import net.jpmc.model.TradeReport;
import net.jpmc.service.report.TradeReportService;
import net.jpmc.service.report.TradeReportServiceImpl;

public class MainApplication {
	public static void main(String []args) {
		TradeReportService  tradeCenterService = new TradeReportServiceImpl(new TradeCenterDaoImpl());
		Map<InstructionType, List<TradeReport>> tradeReportByInstructionType = tradeCenterService.generateTradeReport();
		for (Entry<InstructionType, List<TradeReport>> entry : tradeReportByInstructionType.entrySet()) {
			displayReport(entry.getKey(), (List<TradeReport>)entry.getValue());
		}		
	}
	
	/**
	 * This method display trades in descending order of amount
	 * 
	 * @param tradeDtos
	 */
	private static void displayReport(InstructionType instructionType, List<TradeReport> tradeReport) {
		
		System.out.println("Report of instruction type: " + instructionType.getCode());
		
		tradeReport.forEach(report -> {
			System.out.println("Entity: " + report.getEntity() + ", " + "InstructionType: " + report.getInstructionType().getCode() 
					+ ", " + "Amount: " + report.getAmount());
		});
	}
}

