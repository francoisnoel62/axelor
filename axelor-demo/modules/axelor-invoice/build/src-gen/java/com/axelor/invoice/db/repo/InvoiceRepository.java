package com.axelor.invoice.db.repo;

import com.axelor.db.JpaRepository;
import com.axelor.invoice.db.Invoice;

public class InvoiceRepository extends JpaRepository<Invoice> {

	public InvoiceRepository() {
		super(Invoice.class);
	}

}

