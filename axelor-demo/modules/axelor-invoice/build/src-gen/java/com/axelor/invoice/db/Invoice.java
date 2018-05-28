package com.axelor.invoice.db;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.axelor.auth.db.AuditableModel;
import com.axelor.contact.db.Contact;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Cacheable
@Table(name = "INVOICE_INVOICE", indexes = { @Index(columnList = "customer") })
public class Invoice extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVOICE_INVOICE_SEQ")
	@SequenceGenerator(name = "INVOICE_INVOICE_SEQ", sequenceName = "INVOICE_INVOICE_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Contact customer;

	@Widget(defaultNow = true)
	private LocalDate dateOfInvoice = LocalDate.now();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<InvoiceLine> invoiceLine;

	private BigDecimal exTaxTotal = BigDecimal.ZERO;

	private BigDecimal inTaxTotal = BigDecimal.ZERO;

	private String accountingCodeCustomer;

	@Widget(title = "State")
	@Basic
	@Type(type = "com.axelor.db.hibernate.type.ValueEnumType")
	private StatusEnum state = StatusEnum.DRAFT;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Invoice() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Contact getCustomer() {
		return customer;
	}

	public void setCustomer(Contact customer) {
		this.customer = customer;
	}

	public LocalDate getDateOfInvoice() {
		return dateOfInvoice;
	}

	public void setDateOfInvoice(LocalDate dateOfInvoice) {
		this.dateOfInvoice = dateOfInvoice;
	}

	public List<InvoiceLine> getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(List<InvoiceLine> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	/**
	 * Add the given {@link InvoiceLine} item to the {@code invoiceLine}.
	 *
	 * <p>
	 * It sets {@code item.invoice = this} to ensure the proper relationship.
	 * </p>
	 *
	 * @param item
	 *            the item to add
	 */
	public void addInvoiceLine(InvoiceLine item) {
		if (getInvoiceLine() == null) {
			setInvoiceLine(new ArrayList<>());
		}
		getInvoiceLine().add(item);
		item.setInvoice(this);
	}

	/**
	 * Remove the given {@link InvoiceLine} item from the {@code invoiceLine}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeInvoiceLine(InvoiceLine item) {
		if (getInvoiceLine() == null) {
			return;
		}
		getInvoiceLine().remove(item);
	}

	/**
	 * Clear the {@code invoiceLine} collection.
	 *
	 * <p>
	 * If you have to query {@link InvoiceLine} records in same transaction, make
	 * sure to call {@link javax.persistence.EntityManager#flush() } to avoid
	 * unexpected errors.
	 * </p>
	 */
	public void clearInvoiceLine() {
		if (getInvoiceLine() != null) {
			getInvoiceLine().clear();
		}
	}

	public BigDecimal getExTaxTotal() {
		return exTaxTotal == null ? BigDecimal.ZERO : exTaxTotal;
	}

	public void setExTaxTotal(BigDecimal exTaxTotal) {
		this.exTaxTotal = exTaxTotal;
	}

	public BigDecimal getInTaxTotal() {
		return inTaxTotal == null ? BigDecimal.ZERO : inTaxTotal;
	}

	public void setInTaxTotal(BigDecimal inTaxTotal) {
		this.inTaxTotal = inTaxTotal;
	}

	public String getAccountingCodeCustomer() {
		return accountingCodeCustomer;
	}

	public void setAccountingCodeCustomer(String accountingCodeCustomer) {
		this.accountingCodeCustomer = accountingCodeCustomer;
	}

	public StatusEnum getState() {
		return state;
	}

	public void setState(StatusEnum state) {
		this.state = state;
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
		if (!(obj instanceof Invoice)) return false;

		final Invoice other = (Invoice) obj;
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
			.add("dateOfInvoice", getDateOfInvoice())
			.add("exTaxTotal", getExTaxTotal())
			.add("inTaxTotal", getInTaxTotal())
			.add("accountingCodeCustomer", getAccountingCodeCustomer())
			.add("state", getState())
			.omitNullValues()
			.toString();
	}
}
