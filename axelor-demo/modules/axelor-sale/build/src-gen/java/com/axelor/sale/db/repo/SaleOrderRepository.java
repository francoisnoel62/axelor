package com.axelor.sale.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.sale.db.SaleOrder;

public class SaleOrderRepository extends JpaRepository<SaleOrder> {

	public SaleOrderRepository() {
		super(SaleOrder.class);
	}

}

