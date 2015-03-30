package com.osl.skygyft.um.service;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.osl.skygyft.um.domain.AuditTrial;

public class AuditLogUtil {

	public static void LogIt(String action,
		     IAuditLog entity, Connection conn, SessionFactory sessionFactory ){
		 
		     Session tempSession = sessionFactory.openSession();
		 
		     try {
		 
			AuditTrial auditRecord = new AuditTrial();
			tempSession.save(auditRecord);
			tempSession.flush();
		 
		     } finally {	
			tempSession.close();		
		     }		
		  }
}
