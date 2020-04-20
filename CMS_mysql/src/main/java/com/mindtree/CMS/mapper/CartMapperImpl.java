package com.mindtree.CMS.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mindtree.CMS.dto.CartDTO;
import com.mindtree.CMS.dto.ViewCart;
import com.mindtree.CMS.model.Cart;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class CartMapperImpl implements CartMapper {

	private MapperFacade mapper;

	public CartMapperImpl() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		this.mapper = mapperFactory.getMapperFacade();
	}

	@Override
	public Cart map(CartDTO cartDTO) {
		return mapper.map(cartDTO, Cart.class);
	}

	@Override
	public CartDTO map(Cart cart) {
		return mapper.map(cart, CartDTO.class);
	}

	@Override
	public List<Cart> mapAsList(List<CartDTO> cartDTOList) {
		return mapper.mapAsList(cartDTOList, Cart.class);
	}

	@Override
	public List<CartDTO> mapAsListDTO(List<Cart> cartList) {
		return mapper.mapAsList(cartList, CartDTO.class);
	}

	@Override
	public ViewCart mapAsView(Cart cart) {
		return mapper.map(cart, ViewCart.class);
	}

}
