package com.example.travelagency_backend.service;

import com.example.travelagency_backend.dto.CountryDto;
import com.example.travelagency_backend.entity.CountryEntity;
import com.example.travelagency_backend.exception.CountryAlreadyExistsException;
import com.example.travelagency_backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDto> getCountries() {
        return countryRepository.findAll()
                .stream()
                .map(CountryDto::toDto)
                .toList();
    }

    public String createCountry(String countryName) throws CountryAlreadyExistsException {
        if (countryRepository.findByName(countryName).isPresent())
            throw new CountryAlreadyExistsException("Country already exists");

        countryRepository.save(CountryEntity
                .builder()
                .name(countryName)
                .build()
        );

        return "Country created";
    }

}
