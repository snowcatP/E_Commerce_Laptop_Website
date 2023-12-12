package database;
import javax.persistence.*;

import java.security.NoSuchAlgorithmException;
import java.util.*;
import model.*;
import util.PasswordUtil;
public class UserAccountDB {
	public static void insert(UserAccount user_acc) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans  = em.getTransaction();
		trans.begin();
		try {
			em.persist(user_acc);
			trans.commit();
		}catch(Exception e){
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}			
	}
	
	public static void update(UserAccount user_acc) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user_acc);
			trans.commit();
		}catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public static void delete(UserAccount user_acc) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(user_acc));
			trans.commit();
		}catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public static User getUser(String username, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT ua.user FROM UserAccount ua "
						+ "WHERE ua.userName = :username and ua.passWord = :password";
		TypedQuery<User> q = em.createQuery(qString, User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		
		try {
			User user = q.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static UserAccount getUserAccount(String username) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT ua FROM UserAccount ua "
						+ "WHERE ua.userName = :username";
		TypedQuery<UserAccount> q = em.createQuery(qString, UserAccount.class);
		q.setParameter("username", username);
		
		try {
			UserAccount user_acc = q.getSingleResult();
			return user_acc;
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static UserAccount checkemailExists(String email) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT ua FROM UserAccount ua "
						+ "WHERE ua.userName = :email";
		TypedQuery<UserAccount> q = em.createQuery(qString, UserAccount.class);
		q.setParameter("email", email);
		try {
			UserAccount user_acc = q.getSingleResult();
			return user_acc;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
		
		
	}
	
	public static boolean emailExists(String email) {  
		UserAccount ua= checkemailExists(email); 
		return ua != null;
	 }
	
	public static UserAccount checkLogin(String username, String password) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT ua FROM UserAccount ua "
						+ "WHERE ua.userName = :username and ua.passWord = :password";
		TypedQuery<UserAccount> q = em.createQuery(qString, UserAccount.class);
		
		
		String hashedPassword = PasswordUtil.hashPassword(password);
		q.setParameter("username", username);
		q.setParameter("password", hashedPassword);
		
		try {
			UserAccount user_acc = q.getSingleResult();
			return user_acc;
		}
		catch(NoResultException e){
			return null;
		}
		finally {
			em.close();
		}
	}
	
}
