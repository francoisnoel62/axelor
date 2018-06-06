package com.axelor.product.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.db.Query;
import com.axelor.product.db.ProductFamily;

public class ProductFamilyRepository extends JpaRepository<ProductFamily> {

	public ProductFamilyRepository() {
		super(ProductFamily.class);
	}

	public ProductFamily findByName(String name) {
		return Query.of(ProductFamily.class)
				.filter("self.name = :name")
				.bind("name", name)
				.fetchOne();
	}

}

