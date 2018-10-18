package net.jpmc.service.report;

import java.util.Comparator;

import net.jpmc.model.TradeReport;

public class SortByAmountComparator implements Comparator<TradeReport> {

	@Override
	public int compare(TradeReport o1, TradeReport o2) {
		return o2.getAmount().compareTo(o1.getAmount());
	}

}
