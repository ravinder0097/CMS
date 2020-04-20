package com.mindtree.CMS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.CMS.dao.ext.BookRepositoryExt;
import com.mindtree.CMS.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryExt {

	@Query(value = "SELECT b FROM Book b WHERE b.isDeleted = :isNotDeleted ")
	List<Book> findAll(@Param("isNotDeleted") boolean isNotDeleted);

	@Query(value = "SELECT b FROM Book b WHERE b.id = :bookId AND b.isDeleted = :isNotDeleted ")
	Book findByBookId(@Param("bookId") long bookId, @Param("isNotDeleted") boolean isNotDeleted);

}
