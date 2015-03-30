package com.osl.skygyft.um.service;

import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osl.skygyft.um.dao.AuditActionDAO;
import com.osl.skygyft.um.dao.AuditTrialDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.util.BeanPopulator;

@Service
public class AuditTrialHelperServiceImpl implements AuditTrialHelperService {

	@Autowired
	AuditTrialDAO auditTrialDAO;
	
	@Autowired
	AuditActionDAO auditActionDAO;
	
	@Autowired
	UserDAO userDAO;
	
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public void populateAuditTrial() {
		Session session = userDAO.getEntityManager().unwrap(Session.class);
		List<User> users = session.createCriteria(User.class).setMaxResults(1000).list();
		List<AuditAction> auditActions = session.createCriteria(AuditAction.class).list();
		
		int count = 0;
		for(int i = 0; i < 100000; i++) {
			AuditTrial auditTrial = BeanPopulator.populateAuditTrial();
			
			User user = getRandUser(users);
			auditTrial.setUser(user);
			
			AuditAction auditAction = getRandAuditAction(auditActions);
			auditTrial.setAuditAction(auditAction);
			
			session.save(auditTrial);
			if (++count % 100 == 0) {
				session.flush();
				session.clear();
			}
		}
	}


	private AuditAction getRandAuditAction(List<AuditAction> auditActions) {
		int rand = RandomUtils.nextInt(auditActions.size() - 1);
		return auditActions.get(rand);
	}


	private User getRandUser(List<User> users) {
		int rand = RandomUtils.nextInt(1000 - 1);
		return users.get(rand);
	}


	@SuppressWarnings("unused")
	@Override
	@Transactional
	public void testIpAddressType() {
		Session session = userDAO.getEntityManager().unwrap(Session.class);
		
		AuditTrial auditTrial = (AuditTrial) session.createCriteria(AuditTrial.class).add(Restrictions.eq("id", 1)).uniqueResult();
		System.out.println(auditTrial);
		
		String ipSegment1 = auditTrial.getIpSegment1();
		String ipSegment2 = auditTrial.getIpSegment2();
		String ipSegment3 = auditTrial.getIpSegment3();
		String ipSegment4 = auditTrial.getIpSegment4();
		System.out.println();
	}
	
	@Override
	@Transactional
	public void testSqlInjection() {
		Session session = userDAO.getEntityManager().unwrap(Session.class);
		
		AuditAction auditAction = (AuditAction) session.get(AuditAction.class, '1');
		auditAction = (AuditAction) session.createCriteria(AuditAction.class).add(Restrictions.eq("action", ";update audit_action set action='------' where id=1;")).uniqueResult();
		System.out.println(auditAction);
	}

}
