package org.integrallis.bookstore.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Inventory implements Serializable {
	private Long id;
	private Book book;

	private Store store;
	private Integer quantity;

	public Inventory() {
	}

	public Inventory(Store store, int quantity) {
		setStore(store);
		setQuantity(quantity);
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public boolean equals(Object object) {
		// short circuits
		if (object == null)
			return false;
		if (this == object)
			return true;
		if (!(object instanceof Inventory))
			return false;
		final Inventory inventory = (Inventory) object;

		return new EqualsBuilder().append(book, inventory.getBook()).append(
				store, inventory.getStore()).isEquals();
	}

	public int hashcode() {
		return new HashCodeBuilder(19, 23).append(book).append(store)
				.toHashCode();
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Store getStore() {
		return store;
	}

	private static final long serialVersionUID = 759669800916879019L;
}
