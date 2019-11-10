package com.csabarato.tabletennis.service;

import com.csabarato.tabletennis.model.Country;
import com.csabarato.tabletennis.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().forEach(i -> countries.add(i));
        return countries;
    }

    @Override
    public Country getByCountryCode(String countryCode) {
        return countryRepository.findCountryByCountryCode(countryCode);
    }


}
