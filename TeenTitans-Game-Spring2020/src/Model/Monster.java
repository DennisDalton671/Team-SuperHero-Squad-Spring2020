package Model;

/* Stores all the information of a monster */

public class Monster extends Entity {

    private String name;
    private String description;
    private String monsterDefeatedMessage;
    private String itemReward;

    public Monster(String ID, String health, String attack, String room, String name, String description, String monsterDefeatedMessage, String itemReward) {
    	super(ID, health, attack, room);
    	this.name = name;
        this.description = description;
        this.monsterDefeatedMessage = monsterDefeatedMessage;
        this.itemReward = itemReward;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getMonsterDefeatedMessage() { return monsterDefeatedMessage; }
    public String getItemReward() { return itemReward; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setMonsterDefeatedMessage(String monsterDefeatedMessage) { this.monsterDefeatedMessage = monsterDefeatedMessage;}
    public void setItemReward(String itemReward) { this.itemReward = itemReward;}

	public void MonsterGetsAttacked(String i) {
		super.setHealth(Integer.toString(Integer.parseInt(super.getHealth()) - Integer.parseInt(i)));
	}
    
}
