package com.mindtree.CMS.service;

import java.util.List;

import com.mindtree.CMS.model.Book;

public interface BookService {

	public List<Book> getAllBooks();

	public Book getBook(Long bookId);

	public Book create(Book book);

}
