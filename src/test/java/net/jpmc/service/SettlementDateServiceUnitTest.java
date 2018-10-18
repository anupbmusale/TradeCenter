package net.jpmc.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;

import net.jpmc.constant.CurrencyType;
import net.jpmc.service.settlementDate.SettlementDateServiceImpl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.cglib.core.Local;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SettlementDateServiceUnitTest {
	
	@InjectMocks
	SettlementDateServiceImpl  settlementDateService;
	
	@Test
	public void testWorkingDayForOddCurrency() {
		LocalDate expectedDate = LocalDate.of(2018, 10, 21);
		LocalDate workingDate = LocalDate.of(2018, 10, 19);
		LocalDate actualDate = settlementDateService.getWorkingDay(workingDate, CurrencyType.AED);
		assertEquals(expectedDate, actualDate);
	}
	
	@Test
	public void testWorkingDay() {
		LocalDate expectedDate = LocalDate.of(2018, 10, 19);
		LocalDate workingDate = LocalDate.of(2018, 10, 19);
		LocalDate actualDate = settlementDateService.getWorkingDay(workingDate, CurrencyType.USD);
		assertEquals(expectedDate, actualDate);
	}
}
