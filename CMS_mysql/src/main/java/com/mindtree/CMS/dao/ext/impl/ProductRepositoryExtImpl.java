package com.mindtree.CMS.dao.ext.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mindtree.CMS.dao.ext.ProductRepositoryExt;
import com.mindtree.CMS.model.Product;

public class ProductRepositoryExtImpl implements ProductRepositoryExt {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ProductRepositoryExtImpl.class);

	@PersistenceContext
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Product> getProductsByCriteria(String sqlQuery) {
		logger.trace("Going to execute query = " + sqlQuery);
		Query query = entityManager.createQuery(sqlQuery);
		List<Product> products = query.getResultList();
		return products;
	}

}
