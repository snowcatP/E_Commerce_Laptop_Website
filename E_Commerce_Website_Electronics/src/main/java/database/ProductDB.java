package database;
import java.util.List;

import javax.persistence.*;

import model.*;

public class ProductDB {
	public static void insert(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(product);
			trans.commit();
		} catch(NoResultException e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	
	public static void update(Product p) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(p);
			trans.commit();
		}catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public static void delete(Product p) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.remove(em.merge(p));
			trans.commit();
		}catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}finally {
			em.close();
		}
	}
	
	public static List<Product> getAscPricedProducts(int indexPage) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();

	    try {
	    	 // Create a query to retrieve 16 products with the highest prices
	        String jpql = "SELECT p FROM Product p ORDER BY p.price ASC";
	        int pageSize = 9;
	        int offset = (indexPage - 1) * pageSize;
	        Query query = em.createQuery(jpql);
	        query.setFirstResult(offset);
	        query.setMaxResults(pageSize);
	        

	        // Execute the query and return the result list
	        List<Product> products = query.getResultList();


	        return products;
	    } finally {
	        em.close();
	    }
	}
	
	public static List<Product> getDescPricedProducts(int indexPage) {
	    EntityManager em = DBUtil.getEmFactory().createEntityManager();

	    try {
	    	 // Create a query to retrieve 16 products with the highest prices
	        String jpql = "SELECT p FROM Product p ORDER BY p.price DESC";
	        int pageSize = 9;
	        int offset = (indexPage - 1) * pageSize;
	        Query query = em.createQuery(jpql);
	        query.setFirstResult(offset);
	        query.setMaxResults(pageSize);
	        

	        // Execute the query and return the result list
	        List<Product> products = query.getResultList();


	        return products;
	    } finally {
	        em.close();
	    }
	}
	
	public static List<Product> getProductByIndexPage(int indexPage) {
	    EntityManager em = DBUtil.getEmFactory().createEntityManager();

	    try {
	        // JPQL query for pagination
	        String jpql = "SELECT p FROM Product p ORDER BY p.productId";
	        
	        int pageSize = 9;
	        int offset = (indexPage - 1) * pageSize;

	        Query query = em.createQuery(jpql);
	        query.setFirstResult(offset);
	        query.setMaxResults(pageSize);

	        // Execute the query and return the result list
	        List<Product> products = query.getResultList();

	        return products;
	    } finally {
	        em.close();
	    }
	}

	
	public static int countProducts() {
	    EntityManager em = DBUtil.getEmFactory().createEntityManager();

	    try {
	        // Create a query to count the number of products
	        String jpql = "SELECT COUNT(p) FROM Product p";
	        Query query = em.createQuery(jpql);

	        // Execute the query and return the result
	        long count = (long) query.getSingleResult();

	        return (int)count;
	    } finally {
	        em.close();
	    }
	}

	public static List<Product> get16HighPricedProducts() {
	    EntityManager em = DBUtil.getEmFactory().createEntityManager();

	    try {
	    	 // Create a query to retrieve 16 products with the highest prices
	        String jpql = "SELECT p FROM Product p ORDER BY p.price DESC";
	        Query query = em.createQuery(jpql);
	        query.setMaxResults(16);

	        // Execute the query and return the result list
	        List<Product> products = query.getResultList();


	        return products;
	    } finally {
	        em.close();
	    }
	}
	
	public static List<Product> getTop6HighQuantityProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            // Create a query to retrieve 6 products with the highest quantities
            String jpql = "SELECT p FROM Product p ORDER BY p.quantity DESC";
            Query query = em.createQuery(jpql);
            query.setMaxResults(6);

            // Execute the query and return the result list
            List<Product> products = query.getResultList();

            return products;
        } finally {
            em.close();
        }
    }
	
	public static List<Product> get3HighPricedProducts() {
	    EntityManager em = DBUtil.getEmFactory().createEntityManager();

	    try {
	    	 // Create a query to retrieve 16 products with the highest prices
	        String jpql = "SELECT p FROM Product p ORDER BY p.price DESC";
	        Query query = em.createQuery(jpql);
	        query.setMaxResults(3);

	        // Execute the query and return the result list
	        List<Product> products = query.getResultList();


	        return products;
	    } finally {
	        em.close();
	    }
	}
	
	public static List<Product> getAllProducts() {
	    EntityManager em = DBUtil.getEmFactory().createEntityManager();

	    try {
	    	 // Create a query to retrieve 16 products with the highest prices
	        String jpql = "SELECT p FROM Product p";
	        Query query = em.createQuery(jpql);

	        // Execute the query and return the result list
	        List<Product> products = query.getResultList();


	        return products;
	    } finally {
	        em.close();
	    }
	}
	
	public static Product getProductById(Long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT p FROM Product p WHERE p.productId = :productId";
        TypedQuery<Product> query = em.createQuery(jpql, Product.class);
        query.setParameter("productId", productId);

        try {
            Product pd = query.getSingleResult();
        	
            return pd;
        } catch (NoResultException e) {
            // Handle exceptions (e.g., if no result is found or other errors)
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
	
	public static List<Product> get4RelatedProductsByCategory(Long productId) {
	    EntityManager em = DBUtil.getEmFactory().createEntityManager();

	    try {
	        // Retrieve the category of the specified product
	        String categoryQuery = "SELECT p.category FROM Product p WHERE p.productId = :productId";
	        Query categoryQueryObj = em.createQuery(categoryQuery);
	        categoryQueryObj.setParameter("productId", productId);
	        String productCategory = (String) categoryQueryObj.getSingleResult();

	        // Create a query to retrieve 4 products with the same category
	        String jpql = "SELECT p FROM Product p WHERE p.category = :category AND p.productId != :productId";
	        Query query = em.createQuery(jpql);
	        query.setParameter("category", productCategory);
	        query.setParameter("productId", productId);
	        query.setMaxResults(4);

	        // Execute the query and return the result list
	        List<Product> relatedProducts = query.getResultList();

	        return relatedProducts;
	    } finally {
	        em.close();
	    }
	}

	public static List<Product> getAllRelatedProductsByCategory(Long productId) {
	    EntityManager em = DBUtil.getEmFactory().createEntityManager();

	    try {
	        // Retrieve the category of the specified product
	        String categoryQuery = "SELECT p.category FROM Product p WHERE p.productId = :productId";
	        Query categoryQueryObj = em.createQuery(categoryQuery);
	        categoryQueryObj.setParameter("productId", productId);
	        String productCategory = (String) categoryQueryObj.getSingleResult();

	        // Create a query to retrieve 4 products with the same category
	        String jpql = "SELECT p FROM Product p WHERE p.category = :category AND p.productId != :productId";
	        Query query = em.createQuery(jpql);
	        query.setParameter("category", productCategory);
	        query.setParameter("productId", productId);

	        // Execute the query and return the result list
	        List<Product> relatedProducts = query.getResultList();

	        return relatedProducts;
	    } finally {
	        em.close();
	    }
	}
	
	public static List<Product> getProductsByPriceRange(double minPrice, double maxPrice,int indexPage) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            // Create a query to retrieve products within the specified price range
            String jpql = "SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice";
            int pageSize = 9;
	        int offset = (indexPage - 1) * pageSize;
            Query query = em.createQuery(jpql);
            query.setFirstResult(offset);
	        query.setMaxResults(pageSize);
            query.setParameter("minPrice", minPrice);
            query.setParameter("maxPrice", maxPrice);

            // Execute the query and return the result list
            List<Product> products = query.getResultList();

            return products;
        } finally {
            em.close();
        }
    }
	
	public static List<Product> getProductsByBrand(String brand,int indexPage) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            // Create a query to retrieve products with the specified brand
            String jpql = "SELECT p FROM Product p WHERE p.brand = :brand";
            int pageSize = 9;
	        int offset = (indexPage - 1) * pageSize;

	        Query query = em.createQuery(jpql);
	        query.setFirstResult(offset);
	        query.setMaxResults(pageSize);
            query.setParameter("brand", brand);

            // Execute the query and return the result list
            List<Product> products = query.getResultList();

            return products;
        } finally {
            em.close();
        }
    }
	
	public static List<Product> getProductsByCategory(String category,int indexPage) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            // Create a query to retrieve products with the specified brand
            String jpql = "SELECT p FROM Product p WHERE p.category = :category";
            int pageSize = 9;
	        int offset = (indexPage - 1) * pageSize;

	        Query query = em.createQuery(jpql);
	        query.setFirstResult(offset);
	        query.setMaxResults(pageSize);
            query.setParameter("category", category);

            // Execute the query and return the result list
            List<Product> products = query.getResultList();

            return products;
        } finally {
            em.close();
        }
    }
	
	public static void updateProductById(Long productId, Product updatedProduct) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();

        try {
            // Retrieve the product by ID
            Product existingProduct = em.find(Product.class, productId);

            // Check if the product exists
            if (existingProduct != null) {
                // Update the fields of the existing product with the values from the updated product
                existingProduct.setNameProd(updatedProduct.getNameProd());
                existingProduct.setCategory(updatedProduct.getCategory());
                existingProduct.setDescription(updatedProduct.getDescription());
                existingProduct.setPrice(updatedProduct.getPrice());
                existingProduct.setQuantity(updatedProduct.getQuantity());
                existingProduct.setImage1(updatedProduct.getImage1());
                existingProduct.setImage2(updatedProduct.getImage2());
                existingProduct.setImage3(updatedProduct.getImage3());
                existingProduct.setImage4(updatedProduct.getImage4());
                existingProduct.setBrand(updatedProduct.getBrand());
                existingProduct.setConfiguration(updatedProduct.getConfiguration());

                // Merge the updated product into the persistence context
                em.merge(existingProduct);
                trans.commit();
            } else {
                // Handle the case where the product with the given ID is not found
                System.out.println("Product with ID " + productId + " not found.");
                trans.rollback();
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static void deleteProductById(Long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();

        try {
            // Retrieve the product by ID
            Product existingProduct = em.find(Product.class, productId);

            // Check if the product exists
            if (existingProduct != null) {
                // Remove the product from the persistence context
                em.remove(existingProduct);
                trans.commit();
            } else {
                // Handle the case where the product with the given ID is not found
                System.out.println("Product with ID " + productId + " not found.");
                trans.rollback();
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }
	
	public static List<Product> getProductsByName(String nameProd, int indexPage) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        try {
            // Create a query to retrieve products by nameProd
            String jpql = "SELECT p FROM Product p WHERE LOWER(p.nameProd) LIKE LOWER(:nameProd)";
            int pageSize = 9;
            int offset = (indexPage - 1) * pageSize;

            Query query = em.createQuery(jpql);
            query.setParameter("nameProd", "%" + nameProd + "%");
            query.setFirstResult(offset);
            query.setMaxResults(pageSize);

            // Execute the query and return the result list
            List<Product> products = query.getResultList();

            return products;
        } finally {
            em.close();
        }
    }
}
