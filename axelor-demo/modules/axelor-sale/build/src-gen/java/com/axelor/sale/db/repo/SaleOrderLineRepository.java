package com.axelor.sale.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.sale.db.SaleOrderLine;

public class SaleOrderLineRepository extends JpaRepository<SaleOrderLine> {

	public SaleOrderLineRepository() {
		super(SaleOrderLine.class);
	}

}

