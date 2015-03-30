package com.osl.skygyft.um.util;

import io.github.benas.jpopulator.randomizers.GenericStringRandomizer;

import java.util.ResourceBundle;

public class FirstNameRandomizer extends GenericStringRandomizer {
	
	private PersonVo person;

	public FirstNameRandomizer(PersonVo person) {
		super(ResourceBundle.getBundle("random/data/data").getString("firstNames").split(","));
		this.person = person;
	}

	@Override
	public String getRandomValue() {
		String firstName = super.getRandomValue();
		person.setFirstName(firstName);
		return firstName;
	}

}
