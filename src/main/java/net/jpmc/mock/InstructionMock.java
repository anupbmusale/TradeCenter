package net.jpmc.mock;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.jpmc.constant.CurrencyType;
import net.jpmc.constant.InstructionType;
import net.jpmc.model.Instruction;

public class InstructionMock {
	
	public static List<Instruction> getMockedInstruction() {
		List<Instruction> instructions = new ArrayList<>();

		instructions.add(getInstruction("HDFC", InstructionType.BUY, new BigDecimal(0.05), CurrencyType.AED, new Date(), new Date(2018, 10, 18),
				new BigInteger("12345"), new BigDecimal(50.30)));
		instructions.add(getInstruction("STERLITE", InstructionType.SELL, new BigDecimal(3), CurrencyType.SER, new Date(), new Date(2018, 10, 18),
				new BigInteger("8456"), new BigDecimal(20.30)));
		instructions.add(getInstruction("JPMC", InstructionType.BUY, new BigDecimal(0.05), CurrencyType.USD, new Date(), new Date(2018, 10, 18),
				new BigInteger("3456"), new BigDecimal(30.30)));
		instructions.add(getInstruction("MPHASIS", InstructionType.SELL, new BigDecimal(3), CurrencyType.SER, new Date(), new Date(2018, 10, 19),
				new BigInteger("456"), new BigDecimal(40.30)));
		instructions.add(getInstruction("STERLITE", InstructionType.BUY, new BigDecimal(0.05), CurrencyType.AED, new Date(), new Date(2018, 10, 20),
				new BigInteger("123456"), new BigDecimal(50.30)));
		instructions.add(getInstruction("JPMC", InstructionType.SELL, new BigDecimal(0.05), CurrencyType.USD, new Date(), new Date(2018, 10, 18),
				new BigInteger("3456"), new BigDecimal(70.30)));
		instructions.add(getInstruction("STERLITE", InstructionType.BUY, new BigDecimal(3), CurrencyType.SER, new Date(), new Date(2018, 10, 19),
				new BigInteger("3456"), new BigDecimal(80.30)));
		instructions.add(getInstruction("JPMC", InstructionType.SELL, new BigDecimal(.1), CurrencyType.AED, new Date(), new Date(2018, 10, 18),
				new BigInteger("23456"), new BigDecimal(500.30)));
		instructions.add(getInstruction("STERLITE", InstructionType.BUY, new BigDecimal(0.05), CurrencyType.USD, new Date(), new Date(2018, 10, 20),
				new BigInteger("12356"), new BigDecimal(900.30)));
		instructions.add(getInstruction("JPMC", InstructionType.SELL, new BigDecimal(0.05), CurrencyType.AED, new Date(), new Date(2018, 10, 18),
				new BigInteger("12345"), new BigDecimal(100.30)));
		instructions.add(getInstruction("STERLITE", InstructionType.BUY, new BigDecimal(0.05), CurrencyType.SER, new Date(), new Date(2018, 10, 19),
				new BigInteger("12356"), new BigDecimal(200.30)));
		instructions.add(getInstruction("JPMC", InstructionType.SELL, new BigDecimal(0.08), CurrencyType.AED, new Date(), new Date(2018, 10, 17),
				new BigInteger("12456"), new BigDecimal(300.30)));
		instructions.add(getInstruction("MPHASIS", InstructionType.SELL, new BigDecimal(0.02), CurrencyType.AED, new Date(), new Date(2018, 10, 21),
				new BigInteger("12346"), new BigDecimal(700.30)));
		instructions.add(getInstruction("STERLITE", InstructionType.BUY, new BigDecimal(0.15), CurrencyType.SER, new Date(), new Date(2018, 10, 20),
				new BigInteger("12456"), new BigDecimal(400.30)));
		instructions.add(getInstruction("JPMC", InstructionType.SELL, new BigDecimal(0.25), CurrencyType.AED, new Date(), new Date(2018, 10, 19),
				new BigInteger("12346"), new BigDecimal(100.30)));
		instructions.add(getInstruction("STERLITE", InstructionType.BUY, new BigDecimal(0.35), CurrencyType.USD, new Date(), new Date(2018, 10, 21),
				new BigInteger("72356"), new BigDecimal(100.30)));
		instructions.add(getInstruction("MPHASIS", InstructionType.BUY, new BigDecimal(0.75), CurrencyType.SER, new Date(), new Date(2018, 10, 19),
				new BigInteger("23456"), new BigDecimal(300.30)));
	
		return instructions;
	}
	
	private static Instruction getInstruction(String entityName, InstructionType instructionType, BigDecimal agreedFx, 
			CurrencyType currencyType, Date instructionDate, Date settlementDate, BigInteger units, BigDecimal pricePerUnit) {
		Instruction instruction = new Instruction();
		instruction.setEntity(entityName);
		instruction.setInstructionType(instructionType);;
		instruction.setAgreedFx(agreedFx);
		instruction.setCurrencyType(currencyType);
		instruction.setInstructionDate(instructionDate);
		instruction.setSettlementDate(settlementDate);
		instruction.setUnits(units);
		instruction.setPricePerUnit(pricePerUnit);
        return instruction;
	}
}
