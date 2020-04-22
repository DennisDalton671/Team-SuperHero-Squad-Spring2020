package Model;

public class SaveFile {

	private String id;
	private String room;
	private String saveID;
	
	public SaveFile(String saveID, String health, String attack, String playerState, String equipped, String room_id, String items) {
		this.saveID = saveID;
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
