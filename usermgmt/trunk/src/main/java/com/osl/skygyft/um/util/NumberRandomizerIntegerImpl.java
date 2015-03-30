package com.osl.skygyft.um.util;

import org.apache.commons.lang.math.RandomUtils;

import io.github.benas.jpopulator.api.Randomizer;

public class NumberRandomizerIntegerImpl implements Randomizer<Integer> {

	private int max;

	public NumberRandomizerIntegerImpl(int max) {
		this.max = max;
	}

	@Override
	public Integer getRandomValue() {
		int int_ = RandomUtils.nextInt(max);
		return int_;
	}


}
