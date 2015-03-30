package com.osl.skygyft.um.util;

import io.github.benas.jpopulator.api.Randomizer;

import java.util.Random;

public class IpAddressRandomizer implements Randomizer<String> {


	private IpAddressHolder ipAddressHolder;

	public IpAddressRandomizer(IpAddressHolder ipAddressHolder) {
		this.ipAddressHolder = ipAddressHolder;
	}

	@Override
	public String getRandomValue() {
		Random r = new Random();
		String ipAddress = r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256)
				+ "." + r.nextInt(256);
		ipAddressHolder.setIpAddress(ipAddress);
		return ipAddress;
	}

}
