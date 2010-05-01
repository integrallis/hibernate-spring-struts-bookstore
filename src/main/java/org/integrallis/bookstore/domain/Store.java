package org.integrallis.bookstore.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Store implements Serializable {
	private Long id;
	private String nickName;
	private Address address;

	// private String street1;
	// private String street2;
	// private String city;
	// private String state;
	// private String zipCode;

	public Store() {
	}

	public Store(String nickName, String street1, String city, String state,
			String zipCode) {
		super();
		this.nickName = nickName;
		// this.street1 = street1;
		// this.city = city;
		// this.state = state;
		// this.zipCode = zipCode;
		this.address = new Address(street1, null, city, state, zipCode);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	// public String getStreet1() {
	// return street1;
	// }
	//
	// public void setStreet1(String street1) {
	// this.street1 = street1;
	// }
	//
	// public String getStreet2() {
	// return street2;
	// }
	//
	// public void setStreet2(String street2) {
	// this.street2 = street2;
	// }
	//
	// public String getCity() {
	// return city;
	// }
	//
	// public void setCity(String city) {
	// this.city = city;
	// }
	//
	// public String getState() {
	// return state;
	// }
	//
	// public void setState(String state) {
	// this.state = state;
	// }
	//
	// public String getZipCode() {
	// return zipCode;
	// }
	//
	// public void setZipCode(String zipCode) {
	// this.zipCode = zipCode;
	// }

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
		if (!(object instanceof Store))
			return false;
		final Store store = (Store) object;

		return new EqualsBuilder().append(nickName, store.getNickName())
				.isEquals();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		// pick a hard-coded, randomly chosen, non-zero, odd number
		// ideally different for each class
		return new HashCodeBuilder(17, 37).append(nickName).toHashCode();
	}

	/*
	 * A good toString makes testing/debugging much easier
	 * 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("nickName",
				nickName)
		// .append("street1", street1).append("street2", street2)
				// .append("city", city).append("state",
				// state).append("zipCode",
				// zipCode)
				.toString();
	}

	private static final long serialVersionUID = -8237158199291131908L;
}
