package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Invoice;
import model.User;
public class InvoiceDB {
	public static void insert(Invoice invoice) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(invoice);
			trans.commit();
		} catch(NoResultException e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	
	public static void update(Invoice invoice) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(invoice);
			trans.commit();
		}catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public static List<Invoice> getUserInvoices(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT inv FROM Invoice inv "
						+ "WHERE inv.user.userId = :userId";
		TypedQuery<Invoice> q = em.createQuery(qString, Invoice.class);
		q.setParameter("userId", user.getUserId());
		
		try {
			List<Invoice> invoices = q.getResultList();
			return invoices;
		} catch(NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static List<Invoice> getInvoices() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT inv FROM Invoice inv";
		TypedQuery<Invoice> q = em.createQuery(qString, Invoice.class);
		
		try {
			List<Invoice> invoices = q.getResultList();
			return invoices;
		} catch(NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public static Invoice getInvoiceById(Long invoiceId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT inv FROM Invoice inv "
						+ "WHERE inv.invoiceId = :invoiceId";
		TypedQuery<Invoice> q = em.createQuery(qString, Invoice.class);
		q.setParameter("invoiceId", invoiceId);
		
		try {
			Invoice invoice = q.getSingleResult();
			return invoice;
		} catch(NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
}
