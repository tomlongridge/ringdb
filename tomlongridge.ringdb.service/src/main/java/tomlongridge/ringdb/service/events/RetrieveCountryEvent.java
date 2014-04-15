package tomlongridge.ringdb.service.events;


public class RetrieveCountryEvent extends RetrieveEvent {
	
	private long id;

	public long getID() {
		return id;
	}

	public void setID(long id) {
		this.id = id;
	}

}
