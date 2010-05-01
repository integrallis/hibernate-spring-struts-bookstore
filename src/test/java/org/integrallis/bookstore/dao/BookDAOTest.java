package org.integrallis.bookstore.dao;

import static org.integrallis.bookstore.dao.BookDAO.TITLE;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.integrallis.bookstore.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class BookDAOTest {
	private static Logger logger = Logger.getLogger(BookDAOTest.class);
	
	@Autowired
    private BookDAO bookDAO;
	
	@Test
	public void testGetAllBooksLike() {
		List<Book> books = bookDAO.findByPropertyLike(TITLE, "Beginning");
		for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
			Book book = (Book) iterator.next();
			logger.info("retrieved Book " + book);
			assertTrue(book.getTitle().contains("Beginning"));
		}
	}
    
    
}
