package com.axelor.invoice.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.invoice.db.InvoiceLine;

public class InvoiceLineRepository extends JpaRepository<InvoiceLine> {

	public InvoiceLineRepository() {
		super(InvoiceLine.class);
	}

}

