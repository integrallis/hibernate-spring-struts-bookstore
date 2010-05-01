package org.integrallis.bookstore.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Book implements Serializable {
	private Long id;
	private String isbn;
	private String title;
	private Date publishedOn;
	private Double price;
	private int version = -1;

	private Set<String> authors = new HashSet<String>();
	private Set<Inventory> inventoryRecords = new HashSet<Inventory>();

	public Book() {
	}

	public Book(String isbn, String title, Date publishedOn, Double price) {
		this.isbn = isbn;
		this.title = title;
		this.publishedOn = publishedOn;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishedOn() {
		return publishedOn;
	}

	public void setPublishedOn(Date publishedOn) {
		this.publishedOn = publishedOn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}

	@SuppressWarnings("unused")
	private void setVersion(int version) {
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	public Set<String> getAuthors() {
		return authors;
	}

	public Set<Inventory> getInventoryRecords() {
		return inventoryRecords;
	}

	public void setInventoryRecords(Set<Inventory> inventoryRecords) {
		this.inventoryRecords = inventoryRecords;
	}

	public void addInventoryRecord(Store store, int quantity) {
		Inventory inventory = new Inventory(store, quantity);
		addInventoryRecord(inventory);
	}

	public void addInventoryRecord(Inventory inventory) {
		inventory.setBook(this);
		getInventoryRecords().add(inventory);
	}

	/*
	 * Implementation of equals using Business Key Equality
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		// short circuits
		if (object == null)
			return false;
		if (this == object)
			return true;
		if (!(object instanceof Book))
			return false;
		final Book book = (Book) object;

		return new EqualsBuilder().append(isbn, book.getIsbn()).isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		// pick a hard-coded, randomly chosen, non-zero, odd number
		// ideally different for each class
		return new HashCodeBuilder(17, 37).append(isbn).toHashCode();
	}

	/*
	 * A good toString makes testing/debugging much easier
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("isbn", isbn)
				.append("title", title).append("publishedOn", publishedOn)
				.append("price", price).toString();
	}

	private static final long serialVersionUID = 6735585700907591120L;
}
