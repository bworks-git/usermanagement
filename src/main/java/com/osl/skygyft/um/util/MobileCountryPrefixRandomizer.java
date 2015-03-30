package com.osl.skygyft.um.util;

import org.apache.commons.lang.math.RandomUtils;

import io.github.benas.jpopulator.api.Randomizer;

public class MobileCountryPrefixRandomizer implements Randomizer<String> {


	@Override
	public String getRandomValue() {
		int int_ = RandomUtils.nextInt(99);
		return "+" + String.valueOf(int_);
	}


}
