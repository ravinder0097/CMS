package com.mindtree.CMS.dto;

import lombok.Data;

@Data
public class ProductDTO {

	private Long id;

	private String name;

	private float price;

	private boolean isDeleted;

}
