package com.mahesh.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Serializable> {

}
