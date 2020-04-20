package com.mindtree.CMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.CMS.dao.ext.UserRepositoryExt;
import com.mindtree.CMS.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryExt {

	@Query(value = "SELECT u FROM User u WHERE u.isDeleted = :isNotDeleted ")
	List<User> findAll(@Param("isNotDeleted") boolean isNotDeleted);

	@Query(value = "SELECT u FROM User u WHERE u.id = :userId AND u.isDeleted = :isNotDeleted ")
	User findByUserId(@Param("userId") long userId, @Param("isNotDeleted") boolean isNotDeleted);

}
