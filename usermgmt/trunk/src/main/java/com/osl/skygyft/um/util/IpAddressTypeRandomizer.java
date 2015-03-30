package com.osl.skygyft.um.util;

import io.github.benas.jpopulator.api.Randomizer;

import com.osl.skygyft.um.domain.IpAddress;

public class IpAddressTypeRandomizer implements Randomizer<IpAddress> {

	private IpAddressHolder ipAddressHolder;
	

	public IpAddressTypeRandomizer(IpAddressHolder ipAddressHolder2) {
		this.ipAddressHolder = ipAddressHolder2;
	}

	@Override
	public IpAddress getRandomValue() {
		IpAddress ipAddress = new IpAddress(ipAddressHolder.getIpAddress());
		return ipAddress;
	}

}