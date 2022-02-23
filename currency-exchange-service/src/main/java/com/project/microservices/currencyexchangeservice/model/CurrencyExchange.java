package com.project.microservices.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CURRENCY_EXCHANGE")
public class CurrencyExchange {
	
	public CurrencyExchange(long id, String from, String to, BigDecimal conversionMultiple) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id;
	@Column(name="CURRENCY_FROM")
	private String from;
	@Column(name="CURRENCY_TO")
	private String to;
	@Column(name="CONVERSION_MULTIPLE")
	private BigDecimal conversionMultiple;
	@Column(name="ENVIRONMENT")
	private String environment;

}
