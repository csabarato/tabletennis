package com.csabarato.tabletennis.repository;

import com.csabarato.tabletennis.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country,Integer> {

    Country findCountryByCountryCode(String countryCode);

}
