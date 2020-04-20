package com.mindtree.CMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.CMS.dao.ext.ProductRepositoryExt;
import com.mindtree.CMS.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryExt {

	@Query(value = "SELECT p FROM Product p WHERE p.id = :productId AND p.isDeleted = :isNotDeleted ")
	Product findByProductId(@Param("productId") long productId, @Param("isNotDeleted") boolean isNotDeleted);

}
