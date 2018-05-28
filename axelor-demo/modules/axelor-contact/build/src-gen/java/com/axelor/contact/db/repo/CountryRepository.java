package com.axelor.contact.db.repo;

import com.axelor.contact.db.Country;
import com.axelor.db.JpaRepository;
import com.axelor.db.Query;

public class CountryRepository extends JpaRepository<Country> {

	public CountryRepository() {
		super(Country.class);
	}

	public Country findByCode(String code) {
		return Query.of(Country.class)
				.filter("self.code = :code")
				.bind("code", code)
				.fetchOne();
	}

	public Country findByName(String name) {
		return Query.of(Country.class)
				.filter("self.name = :name")
				.bind("name", name)
				.fetchOne();
	}

}

