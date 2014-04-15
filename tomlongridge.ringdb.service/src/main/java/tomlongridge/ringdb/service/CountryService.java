package tomlongridge.ringdb.service;

import tomlongridge.ringdb.service.events.AllCountriesRetrievedEvent;
import tomlongridge.ringdb.service.events.CountryCreatedEvent;
import tomlongridge.ringdb.service.events.CountryRetrievedEvent;
import tomlongridge.ringdb.service.events.CreateCountryEvent;
import tomlongridge.ringdb.service.events.RetrieveAllCountriesEvent;
import tomlongridge.ringdb.service.events.RetrieveCountryEvent;

public interface CountryService {

	public CountryCreatedEvent create(CreateCountryEvent event);

	public CountryRetrievedEvent get(RetrieveCountryEvent event);
	
	public AllCountriesRetrievedEvent getAll(RetrieveAllCountriesEvent event);

}
