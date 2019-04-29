package com.avi.ExRatesScheduler;

import java.util.HashMap;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExRatesScheduler {

	@Autowired
	private RestTemplate restTemplate; 

	@Autowired
	private ExRatesRepo ratesRepo;
	
	@Scheduled(fixedRate = 300000)
	public void getDataRate()
	{
		System.out.println("Scheduled in every 300 secs");
		ExchangeRateDataObject exRatesObj = restTemplate.getForObject("https://openexchangerates.org/api/latest.json?app_id=18856ba1456340fca251a7af629578fe&base=usd", ExchangeRateDataObject.class);
		
		HashMap<String, String> map = exRatesObj.getRates();
		
		Iterator<String> itr = map.keySet().iterator();
		
		ratesRepo.deleteAll();
		
		while(itr.hasNext())
		{
			String sKey = itr.next();
			String sVal = map.get(sKey);
			ExRatesDb rate = new ExRatesDb(sKey, sVal);
			ratesRepo.save(rate);
		}
		ExRatesDb rate =new ExRatesDb("TIME",(exRatesObj.getTimestamp().toString()));
		ratesRepo.save(rate);
		rate =new ExRatesDb("BASE",(exRatesObj.getBase().toString()));
		ratesRepo.save(rate);
	}	
}
