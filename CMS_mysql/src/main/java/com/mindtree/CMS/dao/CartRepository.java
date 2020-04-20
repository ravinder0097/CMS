package com.mindtree.CMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.CMS.dao.ext.CartRepositoryExt;
import com.mindtree.CMS.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>, CartRepositoryExt {

	@Query(value = "SELECT c FROM Cart c WHERE c.isDeleted = :isNotDeleted ")
	List<Cart> findAll(@Param("isNotDeleted") boolean isNotDeleted);

	@Query(value = "SELECT c FROM Cart c WHERE c.id = :cartId AND c.isDeleted = :isNotDeleted ")
	Cart findByCartId(@Param("cartId") long cartId, @Param("isNotDeleted") boolean isNotDeleted);

}
