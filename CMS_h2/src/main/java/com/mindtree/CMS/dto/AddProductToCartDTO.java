package com.mindtree.CMS.dto;

import java.util.List;

import lombok.Data;

@Data
public class AddProductToCartDTO {

	private long cartId;

	private List<Long> productID;

}
