package tomlongridge.ringdb.service.rest.domain.response;

public class CountryResponse {
	
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
