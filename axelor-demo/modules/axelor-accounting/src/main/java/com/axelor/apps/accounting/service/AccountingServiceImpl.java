package com.axelor.apps.accounting.service;

import java.math.BigDecimal;
import java.util.List;

import com.axelor.accounting.db.Accounting;
import com.axelor.accounting.db.AccountingLine;
import com.axelor.accounting.db.repo.AccountingRepository;
import com.axelor.i18n.I18n;
import com.axelor.inject.Beans;
import com.axelor.invoice.db.Invoice;
import com.axelor.invoice.db.InvoiceLine;
import com.google.inject.persist.Transactional;

public class AccountingServiceImpl implements AccountingService {

	@Override
	@Transactional(rollbackOn={Exception.class})
	
	public Accounting createAccountingAccountFromInvoice(Invoice inv) throws Exception {
		Accounting acc = new Accounting();
		acc.setDateOfAccounting(inv.getDateOfInvoice());
		acc.setCustomer(inv.getCustomer());
		
						
		List<InvoiceLine> accountingLine = inv.getInvoiceLine();
		
		for (InvoiceLine invLine : accountingLine) {
			createAccountingLine(acc, invLine);
		}
		
		AccountingLine accLine = new AccountingLine();
		accLine.setAccountingAccount(inv.getAccountingCodeCustomer());
		accLine.setDebit(inv.getInTaxTotal());
		acc.addAccountingLine(accLine);
		
		
		BigDecimal total = BigDecimal.ZERO;
		for (AccountingLine accLine1 : acc.getAccountingLine()) {
			total = total.add(accLine1.getCredit());
		}
		if(!total.equals(inv.getInTaxTotal())){
			throw new Exception(I18n.get("credit != debit"));
		}
		
		Beans.get(AccountingRepository.class).save(acc);//Persistance de la nouvelle ecriture comptable créée

		
		return acc;
	}

	private void createAccountingLine(Accounting acc, InvoiceLine invLine) {
		AccountingLine accLine = new AccountingLine();
		accLine.setAccountingAccount(invLine.getAccountingAccount());
		accLine.setCredit(invLine.getInSubTotal());
		acc.addAccountingLine(accLine);
	}
	
	


}
