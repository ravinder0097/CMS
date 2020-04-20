package com.mindtree.CMS.dto;

import com.mindtree.CMS.enums.Category;

import lombok.Data;

@Data
public class FilterProductCreteria {

	private Long id;

	private String name;

	private Category category;

}
