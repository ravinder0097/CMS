package com.mindtree.CMS.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Book extends Product implements Comparable<Apparal> {

	@Column(name = "GENRE")
	private String genre;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "PUBLICATIONS")
	private String publications;

	// json ignore

	@JsonIgnore
	private List<CartProductManager> cartProduct;

	@Override
	public int compareTo(Apparal o) {
		if (o.getId() == this.getId()) {
			return 1;
		} else {
			return 0;
		}
	}

}
