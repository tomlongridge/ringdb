package tomlongridge.ringdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tomlongridge.ringdb.service.CountryService;
import tomlongridge.ringdb.service.dao.CountryDAO;
import tomlongridge.ringdb.service.domain.Country;
import tomlongridge.ringdb.service.events.AllCountriesRetrievedEvent;
import tomlongridge.ringdb.service.events.CountryCreatedEvent;
import tomlongridge.ringdb.service.events.CountryRetrievedEvent;
import tomlongridge.ringdb.service.events.CreateCountryEvent;
import tomlongridge.ringdb.service.events.RetrieveAllCountriesEvent;
import tomlongridge.ringdb.service.events.RetrieveCountryEvent;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDAO countryDAO;
	
	public CountryCreatedEvent create(CreateCountryEvent event)
	{
		Country country = new Country();
		country.setName(event.getName());
		Country persistedCountry = countryDAO.save(country);
		
		CountryCreatedEvent responseEvent = new CountryCreatedEvent();
		responseEvent.setCountry(persistedCountry);
		return responseEvent;
	}
	
	public CountryRetrievedEvent get(RetrieveCountryEvent event)
	{
		final Country country = countryDAO.retrieve(event.getID());
		
		CountryRetrievedEvent response;
		if (country != null) {
			response = new CountryRetrievedEvent();
			response.setFound(true);
			response.setCountry(country);
		} else {
			response = CountryRetrievedEvent.countryNotFound();
		}
		
		return response;
	}

	@Override
	public AllCountriesRetrievedEvent getAll(RetrieveAllCountriesEvent event) {
		AllCountriesRetrievedEvent responseEvent = new AllCountriesRetrievedEvent();
		responseEvent.setCountries(countryDAO.retrieveAll());
		return responseEvent;		
	}

}
