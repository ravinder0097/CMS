package com.mindtree.CMS.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.CMS.dao.BookRepository;
import com.mindtree.CMS.enums.Category;
import com.mindtree.CMS.model.Book;
import com.mindtree.CMS.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll(false);
	}

	public Book getBook(Long bookId) {
		return bookRepository.findByBookId(bookId, false);
	}

	public Book create(Book book) {
		book.setCategory(Category.BOOK);
		book.setDeleted(false);
		book = bookRepository.save(book);
		return book;
	}

}
