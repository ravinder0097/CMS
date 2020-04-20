package com.mindtree.CMS.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;
import org.springframework.util.comparator.Comparators;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mindtree.CMS.enums.Category;

import lombok.Data;

@NamedQuery(name = "getAllProducts", query = "SELECT p FROM Product p WHERE p.id = :productId AND p.isDeleted = :isNotDeleted")

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Product extends Comparators {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private Long price;

	@Column(name = "CATEGORY")
	private Category category;

	@JsonBackReference
	@OneToMany(mappedBy = "productId")
	private List<CartProductManager> cartProduct;

	@Column(name = "IS_DELETED")
	@Where(clause = "isDeleted = '0'")
	private boolean isDeleted;

}
