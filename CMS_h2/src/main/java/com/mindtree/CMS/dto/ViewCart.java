package com.mindtree.CMS.dto;

import java.util.List;

import com.mindtree.CMS.model.CartProductManager;

import lombok.Data;

@Data
public class ViewCart {

	private List<CartProductManager> cartProducts;

	private Long total;

}
