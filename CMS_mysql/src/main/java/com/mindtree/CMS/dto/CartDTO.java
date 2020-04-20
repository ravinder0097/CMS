package com.mindtree.CMS.dto;

import java.util.List;

import com.mindtree.CMS.model.CartProductManager;

import lombok.Data;

@Data
public class CartDTO {

	private long id;

	private List<CartProductManager> cartProduct;

}
