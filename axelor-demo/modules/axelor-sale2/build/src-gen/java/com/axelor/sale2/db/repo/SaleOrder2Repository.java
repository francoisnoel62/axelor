package com.axelor.sale2.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.sale2.db.SaleOrder2;

public class SaleOrder2Repository extends JpaRepository<SaleOrder2> {

	public SaleOrder2Repository() {
		super(SaleOrder2.class);
	}

}

