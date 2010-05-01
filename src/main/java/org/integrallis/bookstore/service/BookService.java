package org.integrallis.bookstore.service;

import static org.integrallis.bookstore.dao.BookDAO.TITLE;

import java.util.List;

import org.integrallis.bookstore.dao.BookDAO;
import org.integrallis.bookstore.domain.Book;

public class BookService {
	private BookDAO BookDAO;

	public BookDAO getBookDAO() {
		return BookDAO;
	}

	public void setBookDAO(BookDAO BookDAO) {
		this.BookDAO = BookDAO;
	}

	public void addBook(Book item) {
		BookDAO.save(item);
	}

	public Book findBookById(Long id) {
		return BookDAO.findById(id);
	}

	public void deleteBook(Book item) {
		BookDAO.delete(item);
	}

	public List<Book> getBooksWithTitleLike(String title) {
		return BookDAO.findByPropertyLike(TITLE, title);
	}
}