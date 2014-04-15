package tomlongridge.ringdb.service.events;

import tomlongridge.ringdb.service.domain.Country;

public class CountryRetrievedEvent extends RetrievedEvent {
	
	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public static CountryRetrievedEvent countryNotFound() {
		CountryRetrievedEvent event = new CountryRetrievedEvent();
		event.setFound(false);
		return event;
	}

}
