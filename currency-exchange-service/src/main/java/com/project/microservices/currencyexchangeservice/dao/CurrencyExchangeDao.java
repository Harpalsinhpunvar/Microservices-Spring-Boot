package com.project.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.microservices.currencyexchangeservice.model.CurrencyExchange;

public interface CurrencyExchangeDao extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByFromAndTo(String from, String to);
}
