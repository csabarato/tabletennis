package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountries();

    Country getByCountryCode(String countryCode);

    Country saveOrUpdate(Country country);
}
