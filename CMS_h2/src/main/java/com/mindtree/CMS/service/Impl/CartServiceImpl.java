package com.mindtree.CMS.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mindtree.CMS.dao.CartRepository;
import com.mindtree.CMS.dao.UserRepository;
import com.mindtree.CMS.dto.AddProductToCartDTO;
import com.mindtree.CMS.dto.CartDTO;
import com.mindtree.CMS.dto.CartProductManagerDTO;
import com.mindtree.CMS.dto.UpdateCartDTO;
import com.mindtree.CMS.dto.ViewCart;
import com.mindtree.CMS.exceptions.CartBusinessException;
import com.mindtree.CMS.mapper.CartMapper;
import com.mindtree.CMS.model.Cart;
import com.mindtree.CMS.model.CartProductManager;
import com.mindtree.CMS.model.Product;
import com.mindtree.CMS.model.User;
import com.mindtree.CMS.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartMapper mapper;

	@Autowired
	private UserRepository u;

	@Override
	public List<CartDTO> getAllCarts() {
		List<Cart> cartList = cartRepository.findAll(false);
		for (Cart cart : cartList) {
			cart.setCartProduct(removeDeleted(cart.getCartProduct()));
		}
		List<CartDTO> cartDTOList = mapper.mapAsListDTO(cartList);
		return cartDTOList;
	}

	@Override
	public ViewCart getCartById(Long cartId) {
		Cart cart = cartRepository.findByCartId(cartId, false);
		ViewCart viewCart = new ViewCart();
		viewCart.setCartProducts(cart.getCartProduct());
		Long price = 0l;
		for (CartProductManager obj : cart.getCartProduct()) {
			price = price + obj.getQuantity() * obj.getProductId().getPrice();
		}
		viewCart.setTotal(price);
		return viewCart;
	}

	@Override
	public CartDTO addProductToCart(AddProductToCartDTO addProd) throws CartBusinessException {
		Cart cart = cartRepository.findByCartId(addProd.getCartId(), false);
		cart.setCartProduct(removeDeleted(cart.getCartProduct()));
		List<CartProductManager> cartProds = cart.getCartProduct();
		for (Long productId : addProd.getProductID()) {
			if (!isAlreadyThere(cartProds, productId)) {
				CartProductManager prod = new CartProductManager();
				Product p = new Product();
				p.setId(productId);
				prod.setProductId(p);
				prod.setDeleted(false);
				prod.setQuantity(1l);
				prod.setCartId(cart);
				cartProds.add(prod);
			}
		}
		try {
			cart = cartRepository.saveAndFlush(cart);
		} catch (Exception e) {
			logger.trace(e.getLocalizedMessage());
			throw new CartBusinessException(e);
		}
		CartDTO cartDTO = mapper.map(cart);
		return cartDTO;
	}

	/**
	 * Checks, if the product is already there in the cart or not. If its already
	 * there then just increases the count and returns true else false
	 * 
	 * @param products
	 * @param productId
	 * @return isThere
	 */
	private boolean isAlreadyThere(List<CartProductManager> products, long productId) {

		boolean isThere = false;
		if (CollectionUtils.isEmpty(products)) {
			return isThere;
		}
		for (CartProductManager product : products) {
			if (product.isDeleted() == false && product.getProductId().getId() == productId) {
				product.setQuantity(product.getQuantity() + 1);
				isThere = true;
				break;
			}
		}
		return isThere;
	}

	@Override
	public CartDTO removeAllProduct(long cartId) {
		Cart cart = cartRepository.findByCartId(cartId, false);
		for (CartProductManager iterable_element : cart.getCartProduct()) {
			iterable_element.setDeleted(true);
		}
		cart = cartRepository.saveAndFlush(cart);
		cart.setCartProduct(removeDeleted(cart.getCartProduct()));
		CartDTO cartDTO = mapper.map(cart);
		return cartDTO;
	}

	@Override
	@Transactional
	public CartDTO UpdateCart(UpdateCartDTO updateCart) throws CartBusinessException {
		Cart cart = cartRepository.findByCartId(updateCart.getCartId(), false);
		cart.setCartProduct(removeDeleted(cart.getCartProduct()));
		List<CartProductManager> cartProdManagerList = cart.getCartProduct();
		List<CartProductManagerDTO> cartProdManagerDTOList = updateCart.getCartProdManagerList();
		for (CartProductManagerDTO cartProductManagerDTO : cartProdManagerDTOList) {
			for (CartProductManager obj : cartProdManagerList) {
				if (cartProductManagerDTO.getId() == obj.getId()) {
					if (cartProductManagerDTO.getQuantity() < 0) {
						logger.trace("Product Quanitity Cannot be Zero");
						throw new CartBusinessException("Product Quanitity Cannot be Zero");
					}
					if (cartProductManagerDTO.getQuantity() == 0) {
						obj.setDeleted(true);
					} else {
						obj.setQuantity(cartProductManagerDTO.getQuantity());
					}
				}
			}
		}
		cart = cartRepository.saveAndFlush(cart);
		CartDTO cartDTO = mapper.map(cart);
		return cartDTO;
	}

	/**
	 * Removes all the deleted products from the cart
	 * 
	 * @param cartProdManagerList
	 * @return result
	 */
	private List<CartProductManager> removeDeleted(List<CartProductManager> cartProdManagerList) {
		List<CartProductManager> result = new ArrayList<>();
		cartProdManagerList.forEach(obj -> {
			if (obj.isDeleted() == false) {
				result.add(obj);
			}
		});
		return result;
	}

	@Override
	public void createDummyUserAndCart() {
		Cart cart = new Cart();
		cart.setDeleted(false);
		User user = new User();
		user.setName("User One");
		user.setCart(cart);
		user.setDeleted(false);
		u.save(user);
	}

}
