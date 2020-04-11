public class Monster {

    private int id;
    private String name;
    private String description;
    private int health;
    private int attackPoints;
    private int roomLocaiton;
    private String monsterDefeatedMessage;

    public Monster(int id, String name, String description, int health, int attackPoints, int roomLocaiton, String monsterDefeatedMessage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.health = health;
        this.attackPoints = attackPoints;
        this.roomLocaiton = roomLocaiton;
        this.monsterDefeatedMessage = monsterDefeatedMessage;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHealth() { return health; }
    public int getAttackPoints() { return attackPoints; }
    public int getRoomLocaiton() { return roomLocaiton; }
    public String getMonsterDefeatedMessage() { return monsterDefeatedMessage; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setHealth(int health) { this.health = health; }
    public void setAttackPoints(int attackPoints) { this.attackPoints = attackPoints; }
    public void setRoomLocaiton(int roomLocaiton) { this.roomLocaiton = roomLocaiton; }
    public void setMonsterDefeatedMessage(String monsterDefeatedMessage) { this.monsterDefeatedMessage = monsterDefeatedMessage;}
}
