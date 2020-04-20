package com.mindtree.CMS.dto;

import java.util.List;

import lombok.Data;

@Data
public class UpdateCartDTO {

	private Long cartId;
	private List<CartProductManagerDTO> cartProdManagerList;

}
