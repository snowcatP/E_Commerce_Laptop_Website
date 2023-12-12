package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Admin;
import model.AdminAccount;
import model.User;

public class AdminDB {
	public static void insert(Admin admin) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		try {
			em.persist(admin);
			trans.commit();
		} catch(Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}	
		
	}
	
	public static void update(Admin admin) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(admin);
			trans.commit();
		} catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static List<Admin> getEmployees(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT a from Admin a ";
		TypedQuery<Admin> q = em.createQuery(qString, Admin.class);
		
		List<Admin> admins;
		try {
			admins = q.getResultList();
			return admins;
		} catch (NoResultException e) {
			System.out.print(e);
			return null;
		} finally {
			em.close();
		}
	}
	
	public static Admin getEmployee(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT a from Admin a "
						+ "WHERE a.email = :email";
		TypedQuery<Admin> q = em.createQuery(qString, Admin.class);
		q.setParameter("email", email);
		try {
			Admin admin = q.getSingleResult();
			return admin;
		} catch (NoResultException e) {
			System.out.print(e);
			return null;
		} finally {
			em.close();
		}
	}
	
	public static void delete(Admin admin) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(admin));
			trans.commit();
		} catch(Exception e){
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}	
	}
	
}
