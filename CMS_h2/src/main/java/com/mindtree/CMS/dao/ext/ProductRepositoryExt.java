package com.mindtree.CMS.dao.ext;

import java.util.List;

import com.mindtree.CMS.model.Product;

public interface ProductRepositoryExt {

	public List<Product> getProductsByCriteria(String sqlQuery);

}
