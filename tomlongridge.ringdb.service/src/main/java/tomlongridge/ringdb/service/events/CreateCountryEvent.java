package tomlongridge.ringdb.service.events;

public class CreateCountryEvent extends CreateEvent {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
