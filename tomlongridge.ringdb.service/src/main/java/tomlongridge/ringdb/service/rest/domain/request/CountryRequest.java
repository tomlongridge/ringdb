package tomlongridge.ringdb.service.rest.domain.request;

import org.springframework.hateoas.ResourceSupport;

public class CountryRequest extends ResourceSupport {
	
	private long id;

	private String name;

	public long getID()
	{
		return id;
	}

	public void setID(long id) {
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
