package org.integrallis.bookstore.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.integrallis.bookstore.domain.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Data access object (DAO) for domain model class Book.
 * 
 * @see org.javatunes.domain.Book
 */
public class BookDAO extends HibernateDaoSupport {

	// property constants
	public static final String ISBN = "isbn";
	public static final String TITLE = "title";
	// ...

	private static Logger logger = Logger.getLogger(BookDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Book transientInstance) {
		logger.debug("saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			logger.debug("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	public void delete(Book persistentInstance) {
		logger.debug("deleting Book instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	public Book findById(Long id) {
		logger.debug("getting Book instance with id: " + id);
		try {
			Book instance = (Book) getHibernateTemplate().get(Book.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Book> findByPropertyIgnoreCase(String property, Object value) {
		try {
			String queryString = "FROM Book AS b WHERE lower(b." + property
					+ ") = lower(?)";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Book> findByPropertyLike(String property, Object value) {
		try {
			String queryString = "FROM Book AS b WHERE " + property
					+ " LIKE '%" + value + "%'";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public static BookDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BookDAO) ctx.getBean("BookDAO");
	}

}