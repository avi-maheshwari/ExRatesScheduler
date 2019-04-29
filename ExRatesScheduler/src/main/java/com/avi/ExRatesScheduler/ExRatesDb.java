package com.avi.ExRatesScheduler;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Qualifier;

@Entity(name="rates_new")
@Qualifier(value="rates_new")
public class ExRatesDb {
	@Id
	private String curr_type;
	private String rate;
	
	public ExRatesDb() {
	}

	public ExRatesDb(String curr_type, String rate) {
		super();
		this.curr_type = curr_type;
		this.rate = rate;
	}
	public String getCurr_type() {
		return curr_type;
	}
	public void setCurr_type(String curr_type) {
		this.curr_type = curr_type;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "ExRatesDb [curr_type=" + curr_type + ", rate=" + rate + "]";
	}
}
