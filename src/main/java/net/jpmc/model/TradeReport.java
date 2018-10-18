package net.jpmc.model;

import java.io.Serializable;
import java.math.BigDecimal;

import net.jpmc.constant.InstructionType;

public class TradeReport implements Serializable {
	
	private static final long serialVersionUID = 7499968755383116021L;
	private BigDecimal amount;
	private InstructionType instructionType;
	private String entity;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public InstructionType getInstructionType() {
		return instructionType;
	}
	public void setInstructionType(InstructionType instructionType) {
		this.instructionType = instructionType;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	@Override
	public String toString() {
		return "TradeReport [amount=" + amount + ", instructionType="
				+ instructionType + ", entity=" + entity + "]";
	}
}
