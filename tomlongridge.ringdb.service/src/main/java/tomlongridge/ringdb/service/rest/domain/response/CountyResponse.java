package tomlongridge.ringdb.service.rest.domain.response;

import org.springframework.hateoas.ResourceSupport;

public class CountyResponse extends ResourceSupport {
	
	private long id;

	private String name;
	
	private CountryResponse country;

	public long getID() {
		return id;
	}
	
	public void setID(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CountryResponse getCountry() {
		return country;
	}

	public void setCountry(CountryResponse country) {
		this.country = country;
	}

}
