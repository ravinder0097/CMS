package com.mindtree.CMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.CMS.dao.ext.ApparalRepositoryExt;
import com.mindtree.CMS.model.Apparal;

@Repository
public interface ApparalRepository extends JpaRepository<Apparal, Long>, ApparalRepositoryExt {

	@Query(value = "SELECT a FROM Apparal a WHERE a.isDeleted = :isNotDeleted ")
	List<Apparal> findAll(@Param("isNotDeleted") boolean isNotDeleted);

	@Query(value = "SELECT a FROM Apparal a WHERE a.id = :apparalId AND a.isDeleted = :isNotDeleted ")
	Apparal findByApparalId(@Param("apparalId") long apparalId, @Param("isNotDeleted") boolean isNotDeleted);

}
