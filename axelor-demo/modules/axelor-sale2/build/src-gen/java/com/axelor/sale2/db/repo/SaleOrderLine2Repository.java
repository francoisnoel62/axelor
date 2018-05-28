package com.axelor.sale2.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.sale2.db.SaleOrderLine2;

public class SaleOrderLine2Repository extends JpaRepository<SaleOrderLine2> {

	public SaleOrderLine2Repository() {
		super(SaleOrderLine2.class);
	}

}

