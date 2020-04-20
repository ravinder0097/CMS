package com.mindtree.CMS.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.CMS.commonUtils.ProductQueryBuilder;
import com.mindtree.CMS.dao.ProductRepository;
import com.mindtree.CMS.dto.FilterProductCreteria;
import com.mindtree.CMS.model.Product;
import com.mindtree.CMS.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	private ProductQueryBuilder productQueryBuilder = new ProductQueryBuilder();

	@Override
	public List<Product> getProductsByCriteria(FilterProductCreteria criteria) {
		productQueryBuilder.build(criteria);
		return productRepository.getProductsByCriteria(productQueryBuilder.getQuery());
	}

	@Override
	public Product getProduct(Long productId) {
		return productRepository.findByProductId(productId, false);
	}

}
