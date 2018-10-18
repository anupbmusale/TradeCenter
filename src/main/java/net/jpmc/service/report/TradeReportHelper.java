package net.jpmc.service.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.jpmc.constant.InstructionType;
//import org.apache.commons.collections4.CollectionUtils;
import net.jpmc.model.Instruction;
import net.jpmc.model.TradeReport;
import net.jpmc.util.TradeCenterUtility;

public class TradeReportHelper {
	
	/**
	 * Generate trade report
	 * @param trades
	 */
	public static Map<InstructionType, List<TradeReport>> generateTradeReport(List<Instruction> instructions) {
		Map<InstructionType, List<TradeReport>> tradeReportByInstructionType = new LinkedHashMap<>();
		List<TradeReport> tradeReport = null;
		if (instructions != null && instructions.size() > 0) {
			tradeReport = createReport(instructions);
			Map<InstructionType,List<TradeReport>>  tradeReportByType = tradeReport.stream().collect(Collectors.groupingBy(TradeReport::getInstructionType));
			tradeReportByInstructionType.put(InstructionType.SELL, getIncomingInstructionsReportByEntity(tradeReportByType));
			tradeReportByInstructionType.put(InstructionType.BUY, getOutgoingInstructionsReportByEntity(tradeReportByType));
		} 
		return tradeReportByInstructionType;
	}
	
	/**
	 * Get incoming instruction report
	 * 
	 * @param tradeReportByType
	 * @return
	 */
	private static List<TradeReport> getIncomingInstructionsReportByEntity(Map<InstructionType,List<TradeReport>>  tradeReportByType) {
		List<TradeReport> incomingInstructions =  tradeReportByType.get(InstructionType.SELL);
		Map<String, List<TradeReport>> incomingInstructionsByEntity = incomingInstructions.stream().collect(Collectors.groupingBy(TradeReport :: getEntity));
		return sortTradeReport(sumTradeAmountByEntity(incomingInstructionsByEntity, InstructionType.SELL));
	}
	
	/**
	 * Get outgoing instruction report
	 * 
	 * @param tradeReportByType
	 * @return
	 */
    private static List<TradeReport> getOutgoingInstructionsReportByEntity(Map<InstructionType,List<TradeReport>>  tradeReportByType) {
		List<TradeReport> outgoingInstructions =  tradeReportByType.get(InstructionType.BUY);
		Map<String, List<TradeReport>> outgoingInstructionsByEntity = outgoingInstructions.stream().collect(Collectors.groupingBy(TradeReport :: getEntity));
		return sortTradeReport(sumTradeAmountByEntity(outgoingInstructionsByEntity, InstructionType.BUY));
	}

	/**
	 * Sum trade amount by entity
	 * 
	 * @param instructionsByEntity
	 * @param instructionType
	 * @return
	 */
	private static List<TradeReport> sumTradeAmountByEntity(Map<String, List<TradeReport>> instructionsByEntity, InstructionType instructionType) {
		List<TradeReport> tradeReports = new ArrayList<>();
		instructionsByEntity.entrySet().forEach(entry -> {
			BigDecimal totalAmount = new BigDecimal(0); 
			for (TradeReport tradeReport : entry.getValue()) {
				totalAmount = totalAmount.add(tradeReport.getAmount());
			}
			TradeReport tradeReport = new TradeReport();
			tradeReport.setAmount(totalAmount);
			tradeReport.setEntity(entry.getKey());
			tradeReport.setInstructionType(instructionType);
			tradeReports.add(tradeReport);
		});
		return tradeReports;
	}
    	
	/**
	 * Create trade report
	 * 
	 * @param trades
	 */
	private static List<TradeReport> createReport(List<Instruction> instructions) {
		List<TradeReport> tradeReports = new ArrayList<>(instructions.size());
		instructions.forEach(instruction -> {
			TradeReport tradeReport = new TradeReport();
			tradeReport.setEntity(instruction.getEntity());
			tradeReport.setInstructionType(instruction.getInstructionType());
			tradeReport.setAmount(TradeCenterUtility.convertUnitPriceToTradeAmount(instruction));
			tradeReports.add(tradeReport);
		});
		return tradeReports;
	}
	
	/**
	 * Sort trade by amount
	 * 
	 * @param tradeDtos
	 * @return
	 */
	private static List<TradeReport> sortTradeReport(List<TradeReport> tradeReport) {
		Collections.sort(tradeReport, new SortByAmountComparator());
		return tradeReport;
	}
	
}
