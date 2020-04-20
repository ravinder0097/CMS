package com.mindtree.CMS.service;

import java.util.List;

import com.mindtree.CMS.dto.FilterProductCreteria;
import com.mindtree.CMS.model.Product;

public interface ProductService {

	public List<Product> getProductsByCriteria(FilterProductCreteria creteria);

	public Product getProduct(Long productId);

}
