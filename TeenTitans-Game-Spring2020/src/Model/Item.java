package Model;

public class Item {

    private int id;
    private String itemName;
    private String description;
    private int roomLocation;
    private String attackBoost;

    public Item(int id, String itemName, String description, int roomLocation, String attackBoost) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.roomLocation = roomLocation;
        this.attackBoost = attackBoost;
    }
    
    // Getters
    public int getId() { return id; }
    public String getItemName() { return itemName; }
    public String getDescription() { return description; }
    public int getRoomLocation() { return roomLocation; }
	public String getAttackBoost() {return attackBoost;}
	

	// Setters
    public void setId(int id) { this.id = id; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setDescription(String description) { this.description = description; }
    public void setRoomLocation(int roomLocation) { this.roomLocation = roomLocation; }
    public void setAttackBoost(String attackBoost) {this.attackBoost = attackBoost;}
}
