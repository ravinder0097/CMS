package com.mindtree.CMS.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@Column(name = "IS_DELETED")
	@Where(clause = "isDeleted = '0'")
	private boolean isDeleted;
}
