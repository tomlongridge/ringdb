package tomlongridge.ringdb.service.events;

public abstract class UpdatedEvent {
	
	private boolean isFound;

	public boolean isFound() {
		return isFound;
	}

	public void setFound(boolean isFound) {
		this.isFound = isFound;
	}

}
