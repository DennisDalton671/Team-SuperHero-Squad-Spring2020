package Model;

/* Stores the save date to be displayed by the table view */

public class SaveFile {

	private String id;
	private String room;
	
	public SaveFile(String saveID, String room_id) {
		this.id = saveID;
		this.room = room_id;
		
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	
	
}
