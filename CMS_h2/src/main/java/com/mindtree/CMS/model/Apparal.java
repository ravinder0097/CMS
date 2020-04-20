package com.mindtree.CMS.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Apparal extends Product {

	@Column(name = "TYPE")
	private String type;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "DESIGN")
	private String design;

	// json ignore

	@JsonIgnore
	private List<CartProductManager> cartProduct;

}
