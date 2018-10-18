package net.jpmc.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.jpmc.constant.InstructionType;
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
	 * Test generate trade report
	 */
	@Test
	public void testGenerateTradeReport() {
		when(tradeCenterDao.getInstructionsByDate(new Date())).thenReturn(
				InstructionMock.getMockedInstruction());
		Map<InstructionType, List<TradeReport>> tradeReportByInstructionType = tradeCenterService
				.generateTradeReport(new Date(2018, 10, 18));

		for (Entry<InstructionType, List<TradeReport>> entry : tradeReportByInstructionType
				.entrySet()) {
			for (int i = 0; i < entry.getValue().size(); i++) {
				if (i == 0) {
					entry.getValue().get(0).getAmount();
					Assert.assertEquals(1856380.59, entry.getValue().get(i).getAmount().doubleValue());
					Assert.assertEquals("JPMC", entry.getValue().get(i).getEntity());
				}
			}
		}
		verify(tradeCenterDao).getInstructionsByDate(new Date());
	}
}
