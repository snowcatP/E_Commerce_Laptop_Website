package database;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import model.*;

public class CartDB {
	public static void insert(Cart cart) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(cart);
			trans.commit();
		} catch(NoResultException e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	
	public static Cart getCart(User user) {
		Cart cart = user.getCart();
		return cart;
	}
	
	public static void update(Cart cart) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(cart);
			trans.commit();
		}catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}
	}
}
