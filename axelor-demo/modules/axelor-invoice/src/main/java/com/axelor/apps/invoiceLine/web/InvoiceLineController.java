package com.axelor.apps.invoiceLine.web;

import java.math.BigDecimal;

import com.axelor.apps.invoiceLine.service.InvoiceLineService;
import com.axelor.inject.Beans;
import com.axelor.invoice.db.InvoiceLine;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class InvoiceLineController {
	


	public void setDescriptionFromProduct(ActionRequest req, ActionResponse res) {
		
		// On recupere le contexte de la vue de là où l'on se trouve
		InvoiceLine invLine = req.getContext().asType(InvoiceLine.class);
		
		//On recupere le service que l'on a besoin pour recup la desc du produit
		InvoiceLineService invLineServ = Beans.get(InvoiceLineService.class);
				
		//On recup la desc du produit grace au service
		String prodDesc = invLineServ.setProductDescription(invLine);

		//On "set" la desc du produit dans la vue "invoice line"
		res.setValue("description", prodDesc);

	}

	public void setExTaxPriceFromProduct(ActionRequest req, ActionResponse res) {

		InvoiceLine invLine = req.getContext().asType(InvoiceLine.class);

		InvoiceLineService invLineServ = Beans.get(InvoiceLineService.class);

		BigDecimal exTaxPrice = invLineServ.setProductExTaxPrice(invLine);

		res.setValue("exTaxPrice", exTaxPrice);

	}

	public void setExSubTotal(ActionRequest req, ActionResponse res) {
		
		InvoiceLine invLine = req.getContext().asType(InvoiceLine.class);

		InvoiceLineService invLineServ = Beans.get(InvoiceLineService.class);

		BigDecimal exSubTotal = invLineServ.setExSubTotalPrice(invLine);

		res.setValue("exSubTotal", exSubTotal);

	}

	public void setInSubTotal(ActionRequest req, ActionResponse res) {
		
		InvoiceLine invLine = req.getContext().asType(InvoiceLine.class);

		InvoiceLineService invLineServ = Beans.get(InvoiceLineService.class);

		BigDecimal inSubTotal = invLineServ.setInSubTotalPrice(invLine);

		res.setValue("inSubTotal", inSubTotal);

	}
	
	public void setFromProductAccountingAccount(ActionRequest req, ActionResponse res) {

		InvoiceLine invLine = req.getContext().asType(InvoiceLine.class);

		InvoiceLineService invLineServ = Beans.get(InvoiceLineService.class);

		String accountingAccount = invLineServ.setProductAccountingAccount(invLine);

		res.setValue("accountingAccount", accountingAccount);

	}

}
