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
		Map<InstructionType, List<TradeReport>> tradeReportByInstructionType = tradeCenterService.generateTradeReport(new Date());
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
		
				/*
				 * Report of instruction type: S
		Entity: JPMC, InstructionType: S, Amount: 1856380.59
		Entity: STERLITE, InstructionType: S, Amount: 514970.40
		Entity: MPHASIS, InstructionType: S, Amount: 228048.48
		Report of instruction type: B
		Entity: MPHASIS, InstructionType: B, Amount: 5282877.60
		Entity: STERLITE, InstructionType: B, Amount: 5110970.82
		Entity: HDFC, InstructionType: B, Amount: 31047.67
		Entity: JPMC, InstructionType: B, Amount: 5235.84
		 */
		
	}
}

