package net.jpmc.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

import net.jpmc.constant.CurrencyType;
import net.jpmc.constant.InstructionType;

public class Instruction implements Serializable {

	private static final long serialVersionUID = 7007329903645417459L;
	private String entity;
	private InstructionType instructionType;
	private BigDecimal agreedFx;
	private CurrencyType currencyType;
	private Date instructionDate;
	private LocalDate settlementDate;
	private BigInteger units;
	private BigDecimal pricePerUnit;
	
	public CurrencyType getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public InstructionType getInstructionType() {
		return instructionType;
	}
	public void setInstructionType(InstructionType instructionType) {
		this.instructionType = instructionType;
	}
	public BigDecimal getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}
	public Date getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	public LocalDate getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}
	public BigInteger getUnits() {
		return units;
	}
	public void setUnits(BigInteger units) {
		this.units = units;
	}
	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
