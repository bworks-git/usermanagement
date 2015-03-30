package com.osl.skygyft.um.util;

import static java.util.GregorianCalendar.*;
import io.github.benas.jpopulator.api.Randomizer;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PastCalendarRandomizer implements Randomizer<Calendar> {

	@Override
	public Calendar getRandomValue() {
		GregorianCalendar gc = new GregorianCalendar();
		int year = randBetween(2013, 2014);
		gc.set(YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(DAY_OF_YEAR));
		gc.set(DAY_OF_YEAR, dayOfYear);
		return gc;

	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
