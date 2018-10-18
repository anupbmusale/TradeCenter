package net.jpmc.dao;

import java.util.Date;
import java.util.List;

import net.jpmc.mock.InstructionMock;
import net.jpmc.model.Instruction;

public class TradeCenterDaoImpl implements TradeCenterDao {

	/**
	 * This method generate trade report
	 * 
	 * @param settlementDate
	 * @return
	 */
	public List<Instruction> getInstructions() {
		//TODO DB call to generate trade report
	   return InstructionMock.getMockedInstruction();
	}

	/**
	 * This method persist instruction to DB
	 * 
	 * @param trades
	 */
	public void createTrade(List<Instruction> instructions) {
		//TODO DB call to persist trades
	}
	
}
