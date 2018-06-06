package com.axelor.product.db;

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
@Table(name = "PRODUCT_PRODUCT", indexes = { @Index(columnList = "name"), @Index(columnList = "product_family") })
public class Product extends AuditableModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRODUCT_SEQ")
	@SequenceGenerator(name = "PRODUCT_PRODUCT_SEQ", sequenceName = "PRODUCT_PRODUCT_SEQ", allocationSize = 1)
	private Long id;

	private String name;

	private String description;

	@Widget(title = "Price before VAT")
	private BigDecimal exTaxPrice = BigDecimal.ZERO;

	private String accountingAccount;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private ProductFamily productFamily;

	@Widget(title = "Attributes")
	@Basic(fetch = FetchType.LAZY)
	@Type(type = "json")
	private String attrs;

	public Product() {
	}

	public Product(String name) {
		this.name = name;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getExTaxPrice() {
		return exTaxPrice == null ? BigDecimal.ZERO : exTaxPrice;
	}

	public void setExTaxPrice(BigDecimal exTaxPrice) {
		this.exTaxPrice = exTaxPrice;
	}

	public String getAccountingAccount() {
		return accountingAccount;
	}

	public void setAccountingAccount(String accountingAccount) {
		this.accountingAccount = accountingAccount;
	}

	public ProductFamily getProductFamily() {
		return productFamily;
	}

	public void setProductFamily(ProductFamily productFamily) {
		this.productFamily = productFamily;
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
		if (!(obj instanceof Product)) return false;

		final Product other = (Product) obj;
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
			.add("name", getName())
			.add("description", getDescription())
			.add("exTaxPrice", getExTaxPrice())
			.add("accountingAccount", getAccountingAccount())
			.omitNullValues()
			.toString();
	}
}
