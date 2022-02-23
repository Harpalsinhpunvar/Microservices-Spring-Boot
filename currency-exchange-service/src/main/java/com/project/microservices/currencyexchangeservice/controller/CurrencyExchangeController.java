package com.project.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.microservices.currencyexchangeservice.dao.CurrencyExchangeDao;
import com.project.microservices.currencyexchangeservice.model.CurrencyExchange;

@RestController
public class CurrencyExchangeController {
	
	private Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeDao currencyExchangeDao;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue( 
			@PathVariable String from, 
			@PathVariable String to) {
		log.info("retrieveExchangeValue called with {} to {}", from, to);
		CurrencyExchange currencyExchange = 
				currencyExchangeDao.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException("Uable to find data for " + from + " to " + to);
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
				
		
	}

}
