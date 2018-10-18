package net.jpmc.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.jpmc.constant.InstructionType;
import net.jpmc.constant.TradeCenterConstant;
import net.jpmc.dao.TradeCenterDao;
import net.jpmc.mock.InstructionMock;
import net.jpmc.model.TradeReport;
import net.jpmc.service.report.TradeReportServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradeReportServiceUnitTest {

	@InjectMocks
	TradeReportServiceImpl tradeCenterService;

	@Mock
	TradeCenterDao tradeCenterDao;

	/**
	 * Test generate trade report for Sell trade
	 */
	@Test
	public void testGenerateTradeReportForSell() {
		when(tradeCenterDao.getInstructions()).thenReturn(
				InstructionMock.getMockedInstruction());
		Map<InstructionType, List<TradeReport>> tradeReportByInstructionType = tradeCenterService.generateTradeReport();

		for (Entry<InstructionType, List<TradeReport>> entry : tradeReportByInstructionType
				.entrySet()) {
			for (int i = 0; i < entry.getValue().size(); i++) {
				
				if (i == 0 && entry.getValue().get(0).getInstructionType().equals(InstructionType.SELL)) {
					Assert.assertEquals(new BigDecimal(1856380.59).setScale(TradeCenterConstant.TRADE_AMOUNT_SCALE, RoundingMode.HALF_EVEN),
							entry.getValue().get(i).getAmount());
					Assert.assertEquals("JPMC", entry.getValue().get(i).getEntity());
				}
			}
		}
		verify(tradeCenterDao).getInstructions();
	}
	
	/**
	 * Test generate trade report for Buy trade
	 */
	@Test
	public void testGenerateTradeReportForBuy() {
		when(tradeCenterDao.getInstructions()).thenReturn(
				InstructionMock.getMockedInstruction());
		Map<InstructionType, List<TradeReport>> tradeReportByInstructionType = tradeCenterService.generateTradeReport();

		for (Entry<InstructionType, List<TradeReport>> entry : tradeReportByInstructionType
				.entrySet()) {
			for (int i = 0; i < entry.getValue().size(); i++) {
				
				if (i == 0 && entry.getValue().get(0).getInstructionType().equals(InstructionType.BUY)) {
					Assert.assertEquals(new BigDecimal(5282877.60).setScale(TradeCenterConstant.TRADE_AMOUNT_SCALE, RoundingMode.HALF_EVEN),
							entry.getValue().get(i).getAmount());
					Assert.assertEquals("MPHASIS", entry.getValue().get(i).getEntity());
				}
			}
		}
		verify(tradeCenterDao).getInstructions();
	}

}
