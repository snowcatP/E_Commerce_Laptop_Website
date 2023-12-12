package database;
import java.util.*;

import javax.persistence.*;

import model.*;
public class UserDB {
	public static void insert(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}			
	}
	
	public static void update(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		}catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public static void delete(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user));
			trans.commit();
		}catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}
	}

	public static List<User> getUsers(){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u from User u ";
		TypedQuery<User> q = em.createQuery(qString, User.class);
		
		List<User> users;
		try {
			users = q.getResultList();
			return users;
		} catch (NoResultException e) {
			System.out.print(e);
			return null;
		} finally {
			em.close();
		}
	}
	
	public static User getUser(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT u from User u "
						+ "WHERE u.email = :email";
		TypedQuery<User> q = em.createQuery(qString, User.class);
		q.setParameter("email", email);
		
		try {
			User user = q.getSingleResult();
			return user;
		} catch (NoResultException e) {
			System.out.print(e);
			return null;
		} finally {
			em.close();
		}
	}
	
}

