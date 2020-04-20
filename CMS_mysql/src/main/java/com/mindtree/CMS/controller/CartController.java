package com.mindtree.CMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.CMS.dto.AddProductToCartDTO;
import com.mindtree.CMS.dto.CartDTO;
import com.mindtree.CMS.dto.UpdateCartDTO;
import com.mindtree.CMS.dto.ViewCart;
import com.mindtree.CMS.exceptions.CartBusinessException;
import com.mindtree.CMS.service.CartService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "cart")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	@ApiOperation(value = "Gets All the Available User Details")
	public List<CartDTO> getAllCart() {
		logger.trace("Entering getAllCart");
		return cartService.getAllCarts();
	}

	@RequestMapping(value = "/viewCart", method = RequestMethod.GET)
	@ApiOperation(value = "Gets Cart by given id")
	public ViewCart getCartById(@RequestParam(required = true) long cartId) {
		logger.trace("Entering getCartById");
		return cartService.getCartById(cartId);
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	@ApiOperation(value = "Add Product to Cart", notes = "It consumes the cart id and the list of products **only that are available(one can check that by Product/overview).")
	public CartDTO addProduct(@RequestBody(required = true) AddProductToCartDTO addProd) throws CartBusinessException {
		logger.trace("Entering addProduct");
		return cartService.addProductToCart(addProd);
	}

	@RequestMapping(value = "/removeAllProduct", method = RequestMethod.POST)
	@ApiOperation(value = "Remove all the product for the Cart")
	public CartDTO removeAllProduct(@RequestParam(required = true) long cartId) {
		logger.trace("Entering removeAllProduct");
		return cartService.removeAllProduct(cartId);
	}

	@RequestMapping(value = "/updateCart", method = RequestMethod.POST)
	@ApiOperation(value = "Update all the products in the cart", notes = "It consumes the cart id and the list of CartProductManager which inlcudes id, productId, quantity(updated one). Also, only the products which are already there will be accepted as to update(one can check that by /cart/viewCart or cart/overview)")
	public CartDTO UpdateCart(@RequestBody(required = true) UpdateCartDTO updateCart) throws CartBusinessException {
		logger.trace("Entering UpdateCart");
		return cartService.UpdateCart(updateCart);
	}

	@RequestMapping(value = "/setDataBase", method = RequestMethod.POST)
	@ApiOperation(value = "Creates the dummy User cart associated to it")
	public void dosd() {
		logger.trace("Entering UpdateCart");
		cartService.createDummyUserAndCart();
	}

}
