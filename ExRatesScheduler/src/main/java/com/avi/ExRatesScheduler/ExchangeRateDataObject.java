package com.avi.ExRatesScheduler;

import java.util.HashMap;

public class ExchangeRateDataObject {
	
	private String disclaimer;
	private String license;
	private Long timestamp;
	private String base;
	private HashMap<String, String> rates;
	
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public HashMap<String, String> getRates() {
		return rates;
	}
	public void setRates(HashMap<String, String> rates) {
		this.rates = rates;
	}
	@Override
	public String toString() {
		return "exRateData [disclaimer=" + disclaimer + ", license=" + license + ", timestamp=" + timestamp + ", base="
				+ base + ", rates=" + rates + "]";
	}
}
