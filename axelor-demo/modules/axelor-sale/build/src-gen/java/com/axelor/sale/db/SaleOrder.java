package com.axelor.sale.db;

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
@Table(name = "SALE_SALE_ORDER", indexes = { @Index(columnList = "customer") })
public class SaleOrder extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE_SALE_ORDER_SEQ")
	@SequenceGenerator(name = "SALE_SALE_ORDER_SEQ", sequenceName = "SALE_SALE_ORDER_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Contact customer;

	@Widget(defaultNow = true)
	private LocalDate dateOfOrder = LocalDate.now();

	private LocalDate dateOfPrevInvoicing;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "saleOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SaleOrderLine> saleOrderLine;

	private BigDecimal exTaxTotal = BigDecimal.ZERO;

	private BigDecimal inTaxTotal = BigDecimal.ZERO;

	@Widget(title = "State2")
	@Basic
	@Type(type = "com.axelor.db.hibernate.type.ValueEnumType")
	private StatusEnum2 state2 = StatusEnum2.DRAFT;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public SaleOrder() {
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

	public LocalDate getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(LocalDate dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public LocalDate getDateOfPrevInvoicing() {
		return dateOfPrevInvoicing;
	}

	public void setDateOfPrevInvoicing(LocalDate dateOfPrevInvoicing) {
		this.dateOfPrevInvoicing = dateOfPrevInvoicing;
	}

	public List<SaleOrderLine> getSaleOrderLine() {
		return saleOrderLine;
	}

	public void setSaleOrderLine(List<SaleOrderLine> saleOrderLine) {
		this.saleOrderLine = saleOrderLine;
	}

	/**
	 * Add the given {@link SaleOrderLine} item to the {@code saleOrderLine}.
	 *
	 * <p>
	 * It sets {@code item.saleOrder = this} to ensure the proper relationship.
	 * </p>
	 *
	 * @param item
	 *            the item to add
	 */
	public void addSaleOrderLine(SaleOrderLine item) {
		if (getSaleOrderLine() == null) {
			setSaleOrderLine(new ArrayList<>());
		}
		getSaleOrderLine().add(item);
		item.setSaleOrder(this);
	}

	/**
	 * Remove the given {@link SaleOrderLine} item from the {@code saleOrderLine}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeSaleOrderLine(SaleOrderLine item) {
		if (getSaleOrderLine() == null) {
			return;
		}
		getSaleOrderLine().remove(item);
	}

	/**
	 * Clear the {@code saleOrderLine} collection.
	 *
	 * <p>
	 * If you have to query {@link SaleOrderLine} records in same transaction, make
	 * sure to call {@link javax.persistence.EntityManager#flush() } to avoid
	 * unexpected errors.
	 * </p>
	 */
	public void clearSaleOrderLine() {
		if (getSaleOrderLine() != null) {
			getSaleOrderLine().clear();
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

	public StatusEnum2 getState2() {
		return state2;
	}

	public void setState2(StatusEnum2 state2) {
		this.state2 = state2;
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
		if (!(obj instanceof SaleOrder)) return false;

		final SaleOrder other = (SaleOrder) obj;
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
			.add("dateOfOrder", getDateOfOrder())
			.add("dateOfPrevInvoicing", getDateOfPrevInvoicing())
			.add("exTaxTotal", getExTaxTotal())
			.add("inTaxTotal", getInTaxTotal())
			.add("state2", getState2())
			.omitNullValues()
			.toString();
	}
}
