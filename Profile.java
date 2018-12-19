/**
* Make bean profile
*/
@SuppressWarnings("serial")
public class Profile implements Serializable {
	public String getRandomId() {		
		return randomId;
	}
	
	public void setRandomId(String randomId) {		
		this.randomId = randomId;
	}
	
	public Timestamp getCreatedTimestamp() {		
		return createdTimestamp;
	}
	
	public void setCreatedTimestamp(Timestamp createdTimestamp) {		
		this.createdTimestamp = createdTimestamp;
	}
}

