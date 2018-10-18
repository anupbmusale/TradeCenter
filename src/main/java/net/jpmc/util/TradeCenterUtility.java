package net.jpmc.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import net.jpmc.constant.TradeCenterConstant;
import net.jpmc.model.Instruction;

public class TradeCenterUtility {

	/**
	 * Covert unit price to trade amount. PricePerUnit*Units*AgreedFx
	 * 
	 * @param trade
	 * @return
	 */
	public static BigDecimal convertUnitPriceToTradeAmount (Instruction instruction) {
		return instruction.getPricePerUnit().multiply(new BigDecimal(instruction.getUnits())).multiply(instruction.getAgreedFx())
				.setScale(TradeCenterConstant.TRADE_AMOUNT_SCALE, RoundingMode.HALF_EVEN); 
	}
	
	/**
	 * Convert Date to LocalDate
	 * 
	 * @param date
	 * @return
	 */
	
	public static LocalDate convertDateToLocalDate(Date date) {
		Instant instant = Instant.ofEpochMilli(date.getTime()); 
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
		return localDateTime.toLocalDate();
	}
	
	/**
	 * Convert LocalDate to Date
	 *  
	 * @param localDate
	 * @return
	 */
	public static Date convertLocalDateToDate(LocalDate localDate) {
		 return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
