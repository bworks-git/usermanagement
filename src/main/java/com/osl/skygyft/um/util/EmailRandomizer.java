package com.osl.skygyft.um.util;

import io.github.benas.jpopulator.api.Randomizer;

import java.util.Random;
import java.util.ResourceBundle;

public class EmailRandomizer implements Randomizer<String> {

    private final Random random = new Random();

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("random/data/data");

    private final String[] emailServers = resourceBundle.getString("email.servers").split(",");
    private final String[] emailDomains = resourceBundle.getString("email.domains").split(",");
    
    private PersonVo person;
    
    public EmailRandomizer(PersonVo person) {
		this.person = person;
	}

    @Override
    public String getRandomValue() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(person.getFirstName())
                .append(".")
                .append(person.getLastName())
                .append("@")
                .append(emailServers[random.nextInt(emailServers.length)])
                .append(".")
                .append(emailDomains[random.nextInt(emailDomains.length)]);
        return stringBuilder.toString();
    }

}
