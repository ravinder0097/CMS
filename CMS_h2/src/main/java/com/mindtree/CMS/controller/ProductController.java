package com.mindtree.CMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.CMS.dto.FilterProductCreteria;
import com.mindtree.CMS.model.Product;
import com.mindtree.CMS.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	@ApiOperation(value = "Gets All the Available Product Details")
	public List<Product> getAllProduct(FilterProductCreteria criteria) {
		logger.trace("Entering getAllProduct");
		return productService.getProductsByCriteria(criteria);
	}

	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	@ApiOperation(value = "Gets Product by given id")
	public Product getProduct(@RequestParam(required = true) long productId) {
		logger.trace("Entering getProduct");
		return productService.getProduct(productId);
	}

}
