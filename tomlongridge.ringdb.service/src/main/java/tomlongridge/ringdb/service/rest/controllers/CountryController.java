package tomlongridge.ringdb.service.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tomlongridge.ringdb.service.CountryService;
import tomlongridge.ringdb.service.domain.Country;
import tomlongridge.ringdb.service.events.AllCountriesRetrievedEvent;
import tomlongridge.ringdb.service.events.CountryCreatedEvent;
import tomlongridge.ringdb.service.events.CountryRetrievedEvent;
import tomlongridge.ringdb.service.events.CreateCountryEvent;
import tomlongridge.ringdb.service.events.RetrieveAllCountriesEvent;
import tomlongridge.ringdb.service.events.RetrieveCountryEvent;
import tomlongridge.ringdb.service.rest.domain.request.CountryRequest;
import tomlongridge.ringdb.service.rest.domain.response.CountryResponse;

@Controller
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	CountryService service;
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<CountryResponse> create(@RequestBody CountryRequest country)
	{
		CreateCountryEvent requestEvent = new CreateCountryEvent();
		requestEvent.setName(country.getName());
		CountryCreatedEvent responseEvent = service.create(requestEvent);
		
		CountryResponse response = new CountryResponse();
		response.setID(responseEvent.getCountry().getID());
		response.setName(responseEvent.getCountry().getName());
		return new ResponseEntity<CountryResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ResponseEntity<List<CountryResponse>> getAll()
	{
		AllCountriesRetrievedEvent response = service.getAll(new RetrieveAllCountriesEvent());
		List<CountryResponse> responseList = new ArrayList<CountryResponse>();
		for (Country country : response.getCountries()) {
			CountryResponse countryResponse = new CountryResponse();
			countryResponse.setID(country.getID());
			countryResponse.setName(country.getName());
			responseList.add(countryResponse);
		}
		return new ResponseEntity<List<CountryResponse>>(responseList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CountryResponse> get(@PathVariable long id)
	{
		RetrieveCountryEvent requestEvent = new RetrieveCountryEvent();
		requestEvent.setID(id);
		CountryRetrievedEvent responseEvent = service.get(requestEvent);
		
		ResponseEntity<CountryResponse> responseEntity;
		if (responseEvent.isFound()) {
			CountryResponse response = new CountryResponse();
			response.setID(responseEvent.getCountry().getID());
			response.setName(responseEvent.getCountry().getName());
			responseEntity = new ResponseEntity<CountryResponse>(response, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<CountryResponse>(HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}
	
}
