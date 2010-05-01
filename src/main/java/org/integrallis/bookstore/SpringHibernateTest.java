package org.integrallis.bookstore;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.integrallis.bookstore.domain.Book;
import org.integrallis.bookstore.service.BookService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringHibernateTest {
	private static Logger logger = Logger.getLogger(SpringHibernateTest.class);

	public static void main(String[] args) {

		/* 1. Load the Spring bean configuration and create a bean factory */
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				"applicationContext.xml"));

		/* 2. Create instance of BookService */
		BookService service = (BookService) beanFactory.getBean("bookService");

		/* 3. Retrieve all books with a title containing the words "Beginning" */
		List<Book> javaBooks = service.getBooksWithTitleLike("Beginning");

		for (Iterator<Book> iterator = javaBooks.iterator(); iterator.hasNext();) {
			Book book = (Book) iterator.next();
			logger.info("retrieved Book " + book);
		}

	}
}