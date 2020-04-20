package com.mindtree.CMS.mapper;

import java.util.List;

import com.mindtree.CMS.dto.CartDTO;
import com.mindtree.CMS.dto.ViewCart;
import com.mindtree.CMS.model.Cart;

public interface CartMapper {

	Cart map(CartDTO cartDTO);

	CartDTO map(Cart cart);

	List<Cart> mapAsList(List<CartDTO> cartDTOList);

	List<CartDTO> mapAsListDTO(List<Cart> cartList);

	ViewCart mapAsView(Cart cart);
}
