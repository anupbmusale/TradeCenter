package net.jpmc.service;

import static org.junit.Assert.*;

import java.util.Date;

import net.jpmc.constant.CurrencyType;
import net.jpmc.service.settlementDate.SettlementDateServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SettlementDateServiceUnitTest {
	
	@InjectMocks
	SettlementDateServiceImpl  settlementDateService;
	
	@Test
	public void testWorkingDayForOddCurrency() {
		Date workingDate = new Date(2018, 21, 10);
		Date actualDate = settlementDateService.getWorkingDay(new Date(2018, 19, 10), CurrencyType.AED);
		assertEquals(workingDate, actualDate);
	}
	
	@Test
	public void testWorkingDay() {
		Date workingDate = new Date(2018, 19, 10);
		Date actualDate = settlementDateService.getWorkingDay(new Date(2018, 19, 10), CurrencyType.USD);
		assertEquals(workingDate, actualDate);
	}
}
