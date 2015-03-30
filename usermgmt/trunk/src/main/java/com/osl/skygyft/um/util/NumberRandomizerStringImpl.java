package com.osl.skygyft.um.util;

import org.apache.commons.lang.math.RandomUtils;

import io.github.benas.jpopulator.api.Randomizer;

public class NumberRandomizerStringImpl implements Randomizer<String> {

	private int max;

	public NumberRandomizerStringImpl(int max) {
		this.max = max;
	}

	@Override
	public String getRandomValue() {
		int int_ = RandomUtils.nextInt(max);
		return String.valueOf(int_);
	}


}
