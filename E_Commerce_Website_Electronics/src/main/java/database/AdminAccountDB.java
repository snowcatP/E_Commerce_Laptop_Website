package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Admin;
import model.AdminAccount;

public class AdminAccountDB {
	public static void insert(AdminAccount admin_acc) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(admin_acc);
			trans.commit();
		} catch(Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static AdminAccount checkLogin(String username, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT aa FROM AdminAccount aa "
						+ "WHERE aa.userName = :username and aa.passWord = :password";
		TypedQuery<AdminAccount> q = em.createQuery(qString, AdminAccount.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		
		try {
			AdminAccount admin_acc = q.getSingleResult();
			return admin_acc;
		} catch(NoResultException e){
			return null;
		} finally {
			em.close();
		}
	}
	
	public static AdminAccount checkPassword(AdminAccount admin_acc, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT aa FROM AdminAccount aa "
						+ "WHERE aa.userName = :username and aa.passWord = :password";
		TypedQuery<AdminAccount> q = em.createQuery(qString, AdminAccount.class);
		q.setParameter("username", admin_acc.getUserName());
		q.setParameter("password", password);
		
		try {
			AdminAccount ac = q.getSingleResult();
			return ac;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static AdminAccount getAdminAccount(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT aa FROM AdminAccount aa "
						+ "WHERE aa.userName = :email";
		TypedQuery<AdminAccount> q = em.createQuery(qString, AdminAccount.class);
		q.setParameter("email", email);
		
		try {
			AdminAccount ac = q.getSingleResult();
			return ac;
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static void update(AdminAccount admin_acc) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(admin_acc);
			trans.commit();
		} catch(Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void delete(AdminAccount admin_acc) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(admin_acc));
			trans.commit();
		} catch(Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}
