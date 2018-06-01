package com.axelor.accounting.db;

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
import com.axelor.db.annotations.NameColumn;
import com.axelor.db.annotations.Sequence;
import com.axelor.db.annotations.Widget;
import com.google.common.base.MoreObjects;

@Entity
@Cacheable
@Table(name = "ACCOUNTING_ACCOUNTING", indexes = { @Index(columnList = "customer"), @Index(columnList = "referenceAccountingDoc") })
public class Accounting extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTING_ACCOUNTING_SEQ")
	@SequenceGenerator(name = "ACCOUNTING_ACCOUNTING_SEQ", sequenceName = "ACCOUNTING_ACCOUNTING_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Contact customer;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accounting", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AccountingLine> accountingLine;

	private LocalDate dateOfAccounting;

	@NameColumn
	@Sequence("sequenceGenerator")
	private String referenceAccountingDoc;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Accounting() {
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

	public List<AccountingLine> getAccountingLine() {
		return accountingLine;
	}

	public void setAccountingLine(List<AccountingLine> accountingLine) {
		this.accountingLine = accountingLine;
	}

	/**
	 * Add the given {@link AccountingLine} item to the {@code accountingLine}.
	 *
	 * <p>
	 * It sets {@code item.accounting = this} to ensure the proper relationship.
	 * </p>
	 *
	 * @param item
	 *            the item to add
	 */
	public void addAccountingLine(AccountingLine item) {
		if (getAccountingLine() == null) {
			setAccountingLine(new ArrayList<>());
		}
		getAccountingLine().add(item);
		item.setAccounting(this);
	}

	/**
	 * Remove the given {@link AccountingLine} item from the {@code accountingLine}.
	 *
 	 * @param item
	 *            the item to remove
	 */
	public void removeAccountingLine(AccountingLine item) {
		if (getAccountingLine() == null) {
			return;
		}
		getAccountingLine().remove(item);
	}

	/**
	 * Clear the {@code accountingLine} collection.
	 *
	 * <p>
	 * If you have to query {@link AccountingLine} records in same transaction, make
	 * sure to call {@link javax.persistence.EntityManager#flush() } to avoid
	 * unexpected errors.
	 * </p>
	 */
	public void clearAccountingLine() {
		if (getAccountingLine() != null) {
			getAccountingLine().clear();
		}
	}

	public LocalDate getDateOfAccounting() {
		return dateOfAccounting;
	}

	public void setDateOfAccounting(LocalDate dateOfAccounting) {
		this.dateOfAccounting = dateOfAccounting;
	}

	public String getReferenceAccountingDoc() {
		return referenceAccountingDoc;
	}

	public void setReferenceAccountingDoc(String referenceAccountingDoc) {
		this.referenceAccountingDoc = referenceAccountingDoc;
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
		if (!(obj instanceof Accounting)) return false;

		final Accounting other = (Accounting) obj;
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
			.add("dateOfAccounting", getDateOfAccounting())
			.add("referenceAccountingDoc", getReferenceAccountingDoc())
			.omitNullValues()
			.toString();
	}
}
