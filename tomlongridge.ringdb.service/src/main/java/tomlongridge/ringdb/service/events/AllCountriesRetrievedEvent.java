package tomlongridge.ringdb.service.events;

import java.util.List;

import tomlongridge.ringdb.service.domain.Country;

public class AllCountriesRetrievedEvent extends RetrievedEvent {
	
	private List<Country> countries;

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
