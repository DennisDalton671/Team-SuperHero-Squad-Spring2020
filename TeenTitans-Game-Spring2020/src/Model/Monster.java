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
    
    /**
	 * @return the healthPoint
	 */
	public String getHealthPoint() {
		return healthPoint;
	}

	/**
	 * @param healthPoint the healthPoint to set
	 */
	public void setHealthPoint(String healthPoint) {
		this.healthPoint = healthPoint;
	}
    
    /**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the attackPoint
	 */
	public String getAttackPoint() {
		return attackPoint;
	}

	/**
	 * @param attackPoint the attackPoint to set
	 */
	public void setAttackPoint(String attackPoint) {
		this.attackPoint = attackPoint;
	}

	public void MonsterGestsAttacked(String i) {
		healthPoint = Integer.toString(Integer.parseInt(healthPoint) - Integer.parseInt(i));
	}
    
    public String HitsPlayer() {
		return attackPoint;
	}
}
