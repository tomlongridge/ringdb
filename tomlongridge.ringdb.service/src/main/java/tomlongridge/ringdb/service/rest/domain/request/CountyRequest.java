package tomlongridge.ringdb.service.rest.domain.request;

public class CountyRequest {
	
	private long id;

	private String name;
	
	private long country_id;

	public long getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCountryID() {
		return country_id;
	}

	public void setCountry(long country_id) {
		this.country_id = country_id;
	}

}
