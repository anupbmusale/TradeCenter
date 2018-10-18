package net.jpmc.service.tradeProcessor;

import java.util.List;
import java.util.stream.Collectors;

import net.jpmc.dao.TradeCenterDao;
import net.jpmc.model.Instruction;
import net.jpmc.service.settlementDate.SettlementDateService;


public class TradeProcessorServiceImpl implements TradeProcessorService {

	private SettlementDateService settlementDateService;
	private TradeCenterDao tradeCenterDao;
	
	public TradeProcessorServiceImpl(SettlementDateService settlementDateService, TradeCenterDao tradeCenterDao) {
		this.settlementDateService = settlementDateService;
		this.tradeCenterDao = tradeCenterDao;
	}
	
	/**
	 * This method process instructions 
	 * 
	 * @param instructions
	 */
	
	@Override
	public void processInstruction(List<Instruction> instructions) {
		try {
			List<Instruction> modInstructions = instructions.stream().collect(Collectors.toList());
			modInstructions.forEach(modInstruction -> {
				modInstruction.setSettlementDate(settlementDateService.getWorkingDay(modInstruction.getSettlementDate(), modInstruction.getCurrencyType()));
			});
			tradeCenterDao.createTrade(modInstructions);
		} catch (Exception e) {
			System.out.println("Exception while processing instructions");
		}
	}
	
}
