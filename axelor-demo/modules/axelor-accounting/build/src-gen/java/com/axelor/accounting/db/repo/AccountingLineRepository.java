package com.axelor.accounting.db.repo;

import com.axelor.accounting.db.AccountingLine;
import com.axelor.db.JpaRepository;

public class AccountingLineRepository extends JpaRepository<AccountingLine> {

	public AccountingLineRepository() {
		super(AccountingLine.class);
	}

}

