package edu.hoang.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.hoang.entity.Product;

public interface ProductDAO extends JpaRepository<Product,Integer> {
	@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategory(String cid);
	
}
