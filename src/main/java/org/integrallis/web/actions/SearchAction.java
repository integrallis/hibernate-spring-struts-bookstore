package org.integrallis.web.actions;

import java.util.List;

import org.integrallis.bookstore.domain.Book;
import org.integrallis.bookstore.service.BookService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.Conversion;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

@SuppressWarnings("serial")
@Conversion()
public class SearchAction extends ActionSupport {
    
    private String searchTerm;
    private List<Book> books;
    
    private BookService bookService;

    public String execute() throws Exception {
    	setBooks(bookService.getBooksWithTitleLike(getSearchTerm()));
        return SUCCESS;
    }
    
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public BookService getBookService() {
		return bookService;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
    @RequiredStringValidator(message = "Title Search:", trim = true)
    public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }
    public String getSearchTerm() { return this.searchTerm; }
}
