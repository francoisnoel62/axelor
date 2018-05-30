package com.axelor.accounting.db.repo;

import com.axelor.accounting.db.Accounting;
import com.axelor.db.JpaRepository;

public class AccountingRepository extends JpaRepository<Accounting> {

	public AccountingRepository() {
		super(Accounting.class);
	}

}

