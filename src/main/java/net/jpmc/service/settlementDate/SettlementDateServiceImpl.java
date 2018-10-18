package net.jpmc.service.settlementDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import net.jpmc.constant.CurrencyType;
import net.jpmc.constant.TradeCenterConstant;
import net.jpmc.util.TradeCenterUtility;

public class SettlementDateServiceImpl implements SettlementDateService {

	/**
	 * This method return working day
	 * 
	 * @param settlementDate
	 * @param currency
	 * @return
	 */
	public Date getWorkingDay(Date settlementDate, CurrencyType currencyType) {
		Date workingDay = null;
		LocalDate nextWorkingDay = null;
		try {
			LocalDate localSettlementDate = TradeCenterUtility
					.convertDateToLocalDate(settlementDate);

			if (isWorkingDay(localSettlementDate, currencyType.getCode())) {
				return settlementDate;
			}

			if (isOddCurrency(currencyType.getCode())) {
				nextWorkingDay = getNextWorkingDay(DayOfWeek.FRIDAY,
						DayOfWeek.SATURDAY, localSettlementDate);
			} else {
				nextWorkingDay = getNextWorkingDay(DayOfWeek.SATURDAY,
						DayOfWeek.SUNDAY, localSettlementDate);
			}

			return TradeCenterUtility.convertLocalDateToDate(nextWorkingDay);
		} catch (Exception ex) {
			System.out.println("Exception while calculating working day");
		}
		return workingDay;
	}

	/**
	 * Get the current day.
	 * 
	 * @param settlementDate
	 * @return
	 */
	private DayOfWeek getCurrentDay(LocalDate settlementDate) {

		return settlementDate.getDayOfWeek();
	}

	/**
	 * Add the days.
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	private LocalDate addDays(LocalDate date, int days) {

		return date.plusDays(days);

	}

	/**
	 * Get next working day
	 * 
	 * @param day1
	 * @param day2
	 * @param date
	 * @return
	 */
	private LocalDate getNextWorkingDay(DayOfWeek day1, DayOfWeek day2,
			LocalDate date) {

		LocalDate settlementDate = null;

		DayOfWeek currentDay = getCurrentDay(date);

		if (currentDay == day1) {
			settlementDate = addDays(date, 2);
		} else if (currentDay == day2) {
			settlementDate = addDays(date, 1);
		}

		return settlementDate;
	}

	/**
	 * Checks if settlementDate is working day.
	 * 
	 * @param settlementDate
	 * @param currency
	 * @return
	 */
	private boolean isWorkingDay(LocalDate settlementDate, String currency) {

		boolean isWorkingDay = false;

		DayOfWeek currentDay = getCurrentDay(settlementDate);

		if (isOddCurrency(currency)) {
			isWorkingDay = isWorkingDay(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY,
					currentDay);

		} else {
			isWorkingDay = isWorkingDay(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY,
					currentDay);
		}

		return isWorkingDay;
	}

	/**
	 * Checks if is working day.
	 * 
	 * @param weekend1
	 * @param weekend2
	 * @param currentDay
	 * @return
	 */
	private boolean isWorkingDay(DayOfWeek weekend1, DayOfWeek weekend2,
			DayOfWeek currentDay) {

		return !(currentDay.equals(weekend1) || currentDay.equals(weekend2));

	}

	/**
	 * Checks if it is odd currency.
	 * 
	 * @param currency
	 * @return
	 */
	private boolean isOddCurrency(String currency) {
		return Arrays.asList(TradeCenterConstant.ODD_CURRENCIES).stream()
				.anyMatch(oddCurrency -> oddCurrency.equals(currency));
	}

}
