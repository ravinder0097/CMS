package com.mindtree.CMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.CMS.model.Book;
import com.mindtree.CMS.service.BookService;

import io.swagger.annotations.ApiOperation;
import lombok.NonNull;

@RestController
@RequestMapping(value = "Book")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	@ApiOperation(value = "Gets All the Available Book Details")
	public List<Book> getAllBook() {
		logger.trace("Entering in getAllBooks");
		return bookService.getAllBooks();
	}

	@RequestMapping(value = "/getBook", method = RequestMethod.GET)
	@ApiOperation(value = "Gets Book by given id")
	public Book getBook(@RequestParam(required = true) long bookId) {
		logger.trace("Entering in getBook");
		return bookService.getBook(bookId);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ApiOperation(value = "Create book")
	public Book create(@RequestBody(required = true) @NonNull Book book) {
		logger.trace("Entering in create");
		return bookService.create(book);
	}

}
