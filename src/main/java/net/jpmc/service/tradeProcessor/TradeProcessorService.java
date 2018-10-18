package net.jpmc.service.tradeProcessor;

import java.util.List;

import net.jpmc.model.Instruction;

public interface TradeProcessorService {
	
	/**
	 * This method process instructions
	 * 
	 * @param instructions
	 */
	public void processInstruction(List<Instruction> instructions);

}
