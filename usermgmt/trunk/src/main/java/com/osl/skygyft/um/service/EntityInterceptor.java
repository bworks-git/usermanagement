package com.osl.skygyft.um.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.domain.AuditTrial;

@Service
public class EntityInterceptor extends EmptyInterceptor implements ApplicationContextAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6156738120546808016L;

	private Set<Object> inserts = new HashSet<Object>();
	private Map<Object, String> updates = new HashMap<Object, String>();
	private Set<Object> deletes = new HashSet<Object>();

	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;
	
	@Autowired
	AuditTrialService auditTrialService;
	
	@Autowired
	AuditActionService auditActionService;

	@Autowired
	UserService userService;

	@Autowired
	UserDAO userDAO;

	private static ApplicationContext APP_CTX;
	
	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, org.hibernate.type.Type[] types) {

		if (entity instanceof IAuditLog) {
			deletes.add(entity);
		}
	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, org.hibernate.type.Type[] types) {

		if (entity instanceof IAuditLog) {
			String desc = "changed from " + previousState.toString() + " --> " + currentState.toString();
			updates.put(entity, desc);
		}
		return false;
	}

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, org.hibernate.type.Type[] types) {

		if (entity instanceof IAuditLog) {
			inserts.add(entity);
		}
		return false;
	}

	// called before commit into database
	public void preFlush(Iterator iterator) {
	}

	// called after committed into database
	public void postFlush(Iterator iterator) {
		try {

			for (Iterator it = inserts.iterator(); it.hasNext();) {
				final IAuditLog entity = (IAuditLog) it.next();
				System.out.println("postFlush - insert");

				final Session session = entityManager().unwrap(Session.class);
				session.doWork(new Work() {

					@Override
					public void execute(Connection connection)
							throws SQLException {
						AuditLogUtil.LogIt("Saved", entity, connection,
								session.getSessionFactory());
					}
				});
			}

			for (Iterator it = updates.keySet().iterator(); it.hasNext();) {
				final IAuditLog entity = (IAuditLog) it.next();

				User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				Set<com.osl.skygyft.um.domain.User> set = userDAO().findUserByLoginId(user.getUsername());
				com.osl.skygyft.um.domain.User user_ = set.iterator().next();
				
				AuditTrial auditTrial = new AuditTrial();
				auditTrial.setDescription(updates.get(entity));
				auditTrial.setDateAdded(Calendar.getInstance());
				auditTrial.setIpAddress("-");
				auditTrial.setSuccesFailureFlag(true);
				auditTrial.setUserAgent("-");
				auditTrial.setUserTypeFlag(true);
				auditTrial.setUser(user_);
				auditTrialService.saveAuditTrial(auditTrial);
			}

			for (Iterator it = deletes.iterator(); it.hasNext();) {
				final IAuditLog entity = (IAuditLog) it.next();

				final Session session = entityManager().unwrap(Session.class);
				session.doWork(new Work() {

					@Override
					public void execute(Connection connection)
							throws SQLException {
						AuditLogUtil.LogIt("Deleted", entity, connection,
								session.getSessionFactory());
					}
				});
			}

		} finally {
			inserts.clear();
			updates.clear();
			deletes.clear();
		}
	}
	
	@Override
	public Boolean isTransient(Object entity) {
		return null;
	}

	@Override
	public Object instantiate(String entityName, EntityMode entityMode, Serializable id) {
		return null;
	}


	@Override
	public String getEntityName(Object object) {
		return null;
	}

	@Override
	public Object getEntity(String entityName, Serializable id) {
		return null;
	}

	@Override
	public void afterTransactionBegin(Transaction tx) {
	}

	@Override
	public void afterTransactionCompletion(Transaction tx) {
	}

	@Override
	public void beforeTransactionCompletion(Transaction tx) {
	}

	@Override
	public String onPrepareStatement(String sql) {
		return sql;
	}

	@Override
	public void onCollectionRemove(Object collection, Serializable key) throws CallbackException {
	}

	@Override
	public void onCollectionRecreate(Object collection, Serializable key) throws CallbackException {
	}

	@Override
	public void onCollectionUpdate(Object collection, Serializable key) throws CallbackException {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		APP_CTX = applicationContext;
	}

	private EntityManager entityManager() {
		if(entityManager == null) {
			AutowireCapableBeanFactory fact = APP_CTX.getAutowireCapableBeanFactory();
			fact.autowireBean(this);
		}
		return entityManager;
	}
	
	private UserDAO userDAO() {
		if(entityManager == null) {
			AutowireCapableBeanFactory fact = APP_CTX.getAutowireCapableBeanFactory();
			fact.autowireBean(this);
		}
		return userDAO;
	}
}
