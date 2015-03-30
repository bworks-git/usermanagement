package com.osl.skygyft.um.util;

import io.github.benas.jpopulator.api.Randomizer;

public class NullRandomizer implements Randomizer<Object> {
	

	@Override
	public Object getRandomValue() {
		return null;
	}

}
