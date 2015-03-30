package com.osl.skygyft.um.util;

import io.github.benas.jpopulator.api.Populator;
import io.github.benas.jpopulator.impl.PopulatorBuilder;

import java.util.Calendar;

import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.IpAddress;
import com.osl.skygyft.um.domain.User;

public class BeanPopulator {

	
	public static void main(String a[]) {
		User user = populateUser();
		System.out.println(user);
	}

	public static User populateUser() {
		PersonVo person = new PersonVo();
		NullRandomizer nullRandomizer = new NullRandomizer();
		
		Populator userPopulator = new PopulatorBuilder()
								.registerRandomizer(User.class, String.class, "firstName", new FirstNameRandomizer(person))
								.registerRandomizer(User.class, String.class, "lastName", new LastNameRandomizer(person))
								.registerRandomizer(User.class, String.class, "EMail", new EmailRandomizer(person))
								.registerRandomizer(User.class, String.class, "mobile", new NumberRandomizerStringImpl(999999999))
								.registerRandomizer(User.class, Integer.class, "entityId", new NumberRandomizerIntegerImpl(999999999))
								.registerRandomizer(User.class, String.class, "mobCountryPrefix", new MobileCountryPrefixRandomizer())
								.registerRandomizer(User.class, String.class, "userRole", nullRandomizer)
								.registerRandomizer(User.class, String.class, "permissionNegative", nullRandomizer)
								.registerRandomizer(User.class, String.class, "permissionPositive", nullRandomizer)
								.build();
		User user = userPopulator.populateBean(User.class);
		return user;
	}
	
	public static AuditTrial populateAuditTrial() {
		IpAddressHolder ipAddressHolder = new IpAddressHolder();
		Populator atPopulator = new PopulatorBuilder()
								.registerRandomizer(AuditTrial.class, String.class, "ipAddress", new IpAddressRandomizer(ipAddressHolder))
								.registerRandomizer(AuditTrial.class, IpAddress.class, "ipAddress2", new IpAddressTypeRandomizer(ipAddressHolder))
								.registerRandomizer(AuditTrial.class, Calendar.class, "dateAdded", new PastCalendarRandomizer())
								.build();
		AuditTrial at = atPopulator.populateBean(AuditTrial.class);
		return at;
	}
}
