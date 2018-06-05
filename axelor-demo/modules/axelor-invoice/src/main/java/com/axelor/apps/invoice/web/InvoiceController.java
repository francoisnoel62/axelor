package com.axelor.apps.invoice.web;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.axelor.apps.invoice.service.InvoiceService;
import com.axelor.inject.Beans;
import com.axelor.invoice.db.Invoice;
import com.axelor.meta.schema.actions.ActionView;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.axelor.sale.db.SaleOrder;
import com.axelor.sale.db.StatusEnum2;
import com.axelor.sale.db.repo.SaleOrderRepository;
import com.google.inject.Inject;

public class InvoiceController {
	
	@Inject
	protected InvoiceService invSer;

	public void calculateExTaxTotalPrice(ActionRequest req, ActionResponse res) {

		// On recupere le contexte de la vue
		Invoice invoice = req.getContext().asType(Invoice.class);

		// On utilise la mathode necessaire du service sur le contexte recupéré
		BigDecimal exTaxPrice = invSer.calculateExTaxTotalPrice(invoice);

		// On renvoie le resultat du traitement a travers la reponse
		res.setValue("exTaxTotal", exTaxPrice);

	}

	public void calculateInTaxTotalPrice(ActionRequest req, ActionResponse res) {

		// On recupere le contexte de la vue
		Invoice invoice = req.getContext().asType(Invoice.class);

		// On utilise la mathode necessaire du service sur le contexte recupéré
		BigDecimal inTaxPrice = invSer.calculateInTaxTotalPrice(invoice);

		// On renvoie le resultat du traitement a travers la reponse
		res.setValue("inTaxTotal", inTaxPrice);

	}

	public void copySaleOrderToInvoice(ActionRequest req, ActionResponse res) {
		SaleOrder sale = req.getContext().asType(SaleOrder.class);

		// On utilise la mathode necessaire du service sur le contexte recupéré
		Invoice invoice = invSer.cpyFromSaleToInvoice(sale);	
		
		//On recupere l'ID de la facture pour l'afficher dans le champ correspondant sur sale
		res.setValue("invoice", invoice);

		// On renvoie le resultat du traitement a travers la reponse
		res.setView(ActionView.define("Invoice").model("com.axelor.invoice.db.Invoice").add("form", "invoice-form")
				.add("grid", "invoice-grid").context("_showRecord", String.valueOf(invoice.getId())).map());
	}
	
	public void invoiceAllLateSaleOrder(ActionRequest req, ActionResponse res) {
		List<SaleOrder> lateSO =  Beans.get(SaleOrderRepository.class).all().filter("self.dateOfPrevInvoicing < :dateNow AND self.invoice is null AND self.state2 != :status").bind("dateNow", LocalDate.now()).bind("status", StatusEnum2.DRAFT.getValue()).fetch();
		
		invSer.toInvoiceLateSaleOrder(lateSO);
	}
	

}
