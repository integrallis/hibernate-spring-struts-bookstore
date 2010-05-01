package org.integrallis.bookstore.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ElectronicBook extends Book implements Serializable {

	private String url;
	private String fileType;

	public ElectronicBook() {
	}

	public ElectronicBook(String isbn, String title, Date publishedOn,
			Double price, String url, String fileType) {
		super(isbn, title, publishedOn, price);
		this.url = url;
		this.fileType = fileType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String toString() {
		return new ToStringBuilder(this).append(super.toString()).append("url",
				url).append("fileType", fileType).toString();
	}

	private static final long serialVersionUID = 7806672602051270221L;
}
