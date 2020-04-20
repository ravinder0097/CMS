package com.mindtree.CMS.commonUtils;

import org.springframework.util.StringUtils;

import com.mindtree.CMS.dto.FilterProductCreteria;
import com.mindtree.CMS.enums.Category;

public class ProductQueryBuilder {

	private String queryString;

	public String getQuery() {
		return this.queryString;
	}

	public void build(FilterProductCreteria criteria) {
		queryString = "SELECT p FROM Product p Where p.isDeleted = false";
		this.addId(criteria).addCategory(criteria).addName(criteria);
	}

	private ProductQueryBuilder addId(FilterProductCreteria criteria) {
		if (criteria.getId() != null) {
			queryString = queryString + " AND p.id = " + criteria.getId();
		}
		return this;
	}

	private ProductQueryBuilder addCategory(FilterProductCreteria criteria) {
		if (criteria.getCategory() != null)
			if (criteria.getCategory().equals(Category.BOOK)) {
				queryString = queryString + " AND p.category = " + Category.BOOK.ordinal() + "";
			} else {
				queryString = queryString + " AND p.category = " + Category.APPARAL.ordinal() + "";
			}
		return this;
	}

	private ProductQueryBuilder addName(FilterProductCreteria criteria) {
		if (!StringUtils.isEmpty(criteria.getName())) {
			queryString = queryString + " AND p.name like '%" + criteria.getName() + "%'";
		}
		return this;
	}
}
