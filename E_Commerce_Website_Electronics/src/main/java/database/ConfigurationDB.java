package database;
import javax.persistence.*;

import model.*;
public class ConfigurationDB {
	public static void insert(Configuration config) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		try {
			em.persist(config);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static void update(Configuration config) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(config);
			trans.commit();
		} catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}
