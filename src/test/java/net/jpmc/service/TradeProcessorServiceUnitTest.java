package net.jpmc.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Date;

import net.jpmc.constant.CurrencyType;
import net.jpmc.dao.TradeCenterDao;
import net.jpmc.mock.InstructionMock;
import net.jpmc.service.settlementDate.SettlementDateService;
import net.jpmc.service.tradeProcessor.TradeProcessorServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradeProcessorServiceUnitTest {
	
   @InjectMocks
   private TradeProcessorServiceImpl tradeProcessorService;
   @Mock
   private SettlementDateService settlementDateService;
   @Mock
   private TradeCenterDao tradeCenterDao; 
   
   @Test
   public void testProcessInstruction() {
	   Mockito.doNothing().when(tradeCenterDao).createTrade(InstructionMock.getMockedInstruction());
	   LocalDate settlementDate = LocalDate.of(2018, 10, 18);
	   when(settlementDateService.getWorkingDay(settlementDate, CurrencyType.USD)).thenReturn(settlementDate);
	   tradeProcessorService.processInstruction(InstructionMock.getMockedInstruction());
   }
}
