package com.osl.skygyft.um.util;

import io.github.benas.jpopulator.randomizers.GenericStringRandomizer;

import java.util.ResourceBundle;

public class LastNameRandomizer extends GenericStringRandomizer {

	private PersonVo person;

	public LastNameRandomizer(PersonVo person) {
		super(ResourceBundle.getBundle("random/data/data").getString("lastNames").split(","));
		this.person = person;
	}

	@Override
	public String getRandomValue() {
		String lastName = super.getRandomValue();
		person.setLastName(lastName);
		return lastName;
	}

}
