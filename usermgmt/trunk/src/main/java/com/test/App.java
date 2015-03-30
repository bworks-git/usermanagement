package com.test;


import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.service.AuditTrialHelperService;
import com.osl.skygyft.um.service.UserHelperService;


@Component
public class App {
	

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = null;
    	try {
    		ctx = new ClassPathXmlApplicationContext(
        			"spring_config/um-properties-context.xml",
        			"spring_config/um-dao-context2.xml",
        			"spring_config/um-jpa-vendor-context.xml",
        			"spring_config/um-transaction-context2.xml",
        			"spring_config/um-service-context.xml",
        			"spring_config/um-misc-context.xml"
        			);
    		
//    		populateUsers(ctx);
//    		populateUserRoles(ctx);
//    		populateAuditTrails(ctx);
//    		testIpAddressType(ctx);
    		testSqlInjection(ctx);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ctx != null)
				ctx.close();
		}
    }

	private static void testSqlInjection(ClassPathXmlApplicationContext ctx) {
		AuditTrialHelperService auditTrialHelperService = ctx.getBean(AuditTrialHelperService.class);
		auditTrialHelperService.testSqlInjection();
	}

	private static void testIpAddressType(ClassPathXmlApplicationContext ctx) {
		AuditTrialHelperService auditTrialHelperService = ctx.getBean(AuditTrialHelperService.class);
		auditTrialHelperService.testIpAddressType();
	}

	private static void populateAuditTrails(ClassPathXmlApplicationContext ctx) {
		AuditTrialHelperService auditTrialHelperService = ctx.getBean(AuditTrialHelperService.class);
		auditTrialHelperService.populateAuditTrial();
	}

	private static void populateUserRoles(ClassPathXmlApplicationContext ctx) {
		UserHelperService userHelperService = ctx.getBean(UserHelperService.class);
		userHelperService.populateUserRoles();
	}

	private static void populateUsers(ClassPathXmlApplicationContext ctx) throws Exception {
		UserHelperService userHelperService = ctx.getBean(UserHelperService.class);
		userHelperService.populateUsers();
	}

}
