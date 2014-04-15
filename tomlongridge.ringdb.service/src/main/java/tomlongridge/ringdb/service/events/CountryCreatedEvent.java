package tomlongridge.ringdb.service.events;

import tomlongridge.ringdb.service.domain.Country;

public class CountryCreatedEvent extends CreatedEvent {
	
	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
