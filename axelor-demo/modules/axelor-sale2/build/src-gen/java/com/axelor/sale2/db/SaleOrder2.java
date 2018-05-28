package com.axelor.sale2.db;

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
@Table(name = "SALE2_SALE_ORDER2", indexes = { @Index(columnList = "customer") })
public class SaleOrder2 extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SALE2_SALE_ORDER2_SEQ")
	@SequenceGenerator(name = "SALE2_SALE_ORDER2_SEQ", sequenceName = "SALE2_SALE_ORDER2_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Contact customer;

	@Widget(defaultNow = true)
	private LocalDate dateOfOrder = LocalDate.now();

	private LocalDate dateOfPrevInvoicing;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "saleOrder2", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SaleOrderLine2> saleOrderLine2;

	private BigDecimal exTaxTotal = BigDecimal.ZERO;

	private BigDecimal inTaxTotal = BigDecimal.ZERO;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public SaleOrder2() {
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

	public List<SaleOrderLine2> getSaleOrderLine2() {
		return saleOrderLine2;
	}

	public void setSaleOrderLine2(List<SaleOrderLine2> saleOrderLine2) {
		this.saleOrderLine2 = saleOrderLine2;
	}

	/**
	 * Add the given {@link SaleOrderLine2} item to the {@code saleOrderLine2}.
	 *
	 * <p>
	 * It sets {@code item.saleOrder2 = this} to ensure the proper relationship.
	 * </p>
	 *
	 * @param item
	 *            the item to add
	 */
	public void addSaleOrderLine2(SaleOrderLine2 item) {
		if (getSaleOrderLine2() == null) {
			setSaleOrderLine2(new ArrayList<>());
		}
		getSaleOrderLine2().add(item);
		item.setSaleOrder2(this);
	}

	/**
	 * Remove the given {@link SaleOrderLine2} item from the {@code saleOrderLine2}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeSaleOrderLine2(SaleOrderLine2 item) {
		if (getSaleOrderLine2() == null) {
			return;
		}
		getSaleOrderLine2().remove(item);
	}

	/**
	 * Clear the {@code saleOrderLine2} collection.
	 *
	 * <p>
	 * If you have to query {@link SaleOrderLine2} records in same transaction, make
	 * sure to call {@link javax.persistence.EntityManager#flush() } to avoid
	 * unexpected errors.
	 * </p>
	 */
	public void clearSaleOrderLine2() {
		if (getSaleOrderLine2() != null) {
			getSaleOrderLine2().clear();
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
		if (!(obj instanceof SaleOrder2)) return false;

		final SaleOrder2 other = (SaleOrder2) obj;
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
			.omitNullValues()
			.toString();
	}
}
