package com.axelor.accounting.db;

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
import com.google.common.base.MoreObjects;

@Entity
@Cacheable
@Table(name = "ACCOUNTING_ACCOUNTING_LINE", indexes = { @Index(columnList = "accounting") })
public class AccountingLine extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTING_ACCOUNTING_LINE_SEQ")
	@SequenceGenerator(name = "ACCOUNTING_ACCOUNTING_LINE_SEQ", sequenceName = "ACCOUNTING_ACCOUNTING_LINE_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Accounting accounting;

	private String accountingAccount;

	private BigDecimal debit = BigDecimal.ZERO;

	private BigDecimal credit = BigDecimal.ZERO;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public AccountingLine() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Accounting getAccounting() {
		return accounting;
	}

	public void setAccounting(Accounting accounting) {
		this.accounting = accounting;
	}

	public String getAccountingAccount() {
		return accountingAccount;
	}

	public void setAccountingAccount(String accountingAccount) {
		this.accountingAccount = accountingAccount;
	}

	public BigDecimal getDebit() {
		return debit == null ? BigDecimal.ZERO : debit;
	}

	public void setDebit(BigDecimal debit) {
		this.debit = debit;
	}

	public BigDecimal getCredit() {
		return credit == null ? BigDecimal.ZERO : credit;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
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
		if (!(obj instanceof AccountingLine)) return false;

		final AccountingLine other = (AccountingLine) obj;
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
			.add("accountingAccount", getAccountingAccount())
			.add("debit", getDebit())
			.add("credit", getCredit())
			.omitNullValues()
			.toString();
	}
}
