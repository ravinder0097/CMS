package com.mindtree.CMS.service;

import java.util.List;

import com.mindtree.CMS.dto.AddProductToCartDTO;
import com.mindtree.CMS.dto.CartDTO;
import com.mindtree.CMS.dto.UpdateCartDTO;
import com.mindtree.CMS.dto.ViewCart;
import com.mindtree.CMS.exceptions.CartBusinessException;

public interface CartService {

	public List<CartDTO> getAllCarts();

	public ViewCart getCartById(Long cartId);

	public CartDTO addProductToCart(AddProductToCartDTO addProd) throws CartBusinessException;

	public CartDTO removeAllProduct(long cartId);

	public CartDTO UpdateCart(UpdateCartDTO updateCart) throws CartBusinessException;

	public void createDummyUserAndCart();
}
