package com.axelor.product.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.db.Query;
import com.axelor.product.db.Product;

public class ProductRepository extends JpaRepository<Product> {

	public ProductRepository() {
		super(Product.class);
	}

	public Product findByName(String name) {
		return Query.of(Product.class)
				.filter("self.name = :name")
				.bind("name", name)
				.fetchOne();
	}

}

