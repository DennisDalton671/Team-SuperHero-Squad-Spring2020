package Model;

public class Monster extends Entity {

    private String name;
    private String description;
    private String monsterDefeatedMessage;
    private String itemReward;
	private String id;
	private String healthPoint;
	private String attackPoint;

    public Monster(String ID, String health, String attack, String room, String name, String description, String monsterDefeatedMessage, String itemReward) {
    	super(ID, health, attack, room);
        this.id=ID;
    	this.name = name;
    	this.healthPoint = health;
    	this.attackPoint = attack;
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
    public void setMonsterDefeatedMessage(String monsterDefeatedMessage) { this.itemReward = monsterDefeatedMessage;}
    public void setItemReward(String itemReward) { this.itemReward = itemReward;}
    
    public void getMonsterAttacklife(String i) {
		healthPoint = Integer.toString(Integer.parseInt(healthPoint) - Integer.parseInt(i));
	}
    
    public String getMAttack() {
		return attackPoint;
	}
}
