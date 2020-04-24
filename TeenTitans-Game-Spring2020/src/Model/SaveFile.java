package Model;

public class SaveFile {

	private String id;
	private String room;
	private String saveID;
	private String health;
	private String attack;
	private String playerState;
	private String equipped;
	private String items;
	
	public SaveFile(String saveID, String health, String attack, String playerState, String equipped, String room_id, String items) {
		this.id = saveID;
		this.room = room_id;
		this.health = health;
		this.attack = attack;
		this.playerState = playerState;
		this.equipped = equipped;
		this.items = items;
		
		
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
