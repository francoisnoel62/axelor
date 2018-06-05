package com.axelor.invoice.db;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.db.annotations.Widget;
import com.axelor.product.db.Product;
import com.google.common.base.MoreObjects;

@Entity
@Cacheable
@Table(name = "INVOICE_INVOICE_LINE", indexes = { @Index(columnList = "invoice"), @Index(columnList = "product") })
public class InvoiceLine extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVOICE_INVOICE_LINE_SEQ")
	@SequenceGenerator(name = "INVOICE_INVOICE_LINE_SEQ", sequenceName = "INVOICE_INVOICE_LINE_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Invoice invoice;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Product product;

	private String description;

	private BigDecimal qty = new BigDecimal("1");

	private BigDecimal exTaxPrice = BigDecimal.ZERO;

	private BigDecimal exSubTotal = BigDecimal.ZERO;

	private BigDecimal tax = new BigDecimal("0.2");

	private BigDecimal inSubTotal = BigDecimal.ZERO;

	private String accountingAccount;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public InvoiceLine() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getQty() {
		return qty == null ? BigDecimal.ZERO : qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public BigDecimal getExTaxPrice() {
		return exTaxPrice == null ? BigDecimal.ZERO : exTaxPrice;
	}

	public void setExTaxPrice(BigDecimal exTaxPrice) {
		this.exTaxPrice = exTaxPrice;
	}

	public BigDecimal getExSubTotal() {
		return exSubTotal == null ? BigDecimal.ZERO : exSubTotal;
	}

	public void setExSubTotal(BigDecimal exSubTotal) {
		this.exSubTotal = exSubTotal;
	}

	public BigDecimal getTax() {
		return tax == null ? BigDecimal.ZERO : tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getInSubTotal() {
		return inSubTotal == null ? BigDecimal.ZERO : inSubTotal;
	}

	public void setInSubTotal(BigDecimal inSubTotal) {
		this.inSubTotal = inSubTotal;
	}

	public String getAccountingAccount() {
		return accountingAccount;
	}

	public void setAccountingAccount(String accountingAccount) {
		this.accountingAccount = accountingAccount;
	}

	public String getAttrs() {
		return attrs;
	}

	public void setAttrs(String attrs) {
		this.attrs = attrs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (!(obj instanceof InvoiceLine)) return false;

		final InvoiceLine other = (InvoiceLine) obj;
		if (this.getId() != null || other.getId() != null) {
			return Objects.equals(this.getId(), other.getId());
		}

		return false;
	}

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("id", getId())
			.add("description", getDescription())
			.add("qty", getQty())
			.add("exTaxPrice", getExTaxPrice())
			.add("exSubTotal", getExSubTotal())
			.add("tax", getTax())
			.add("inSubTotal", getInSubTotal())
			.add("accountingAccount", getAccountingAccount())
			.omitNullValues()
			.toString();
	}
}
