package Model;

public class Monster {

    private String id;
    private String name;
    private String description;
    private String health;
    private String attackPoints;
    private String roomid;
    private String DefeatedMessage;
    private String itemReward;
    private String itemReward2;


    public Monster(String id, String name, String description, String health, String attackPoints, String roomid, String defeatedMessage, String itemReward, String itemReward2) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.health = health;
        this.attackPoints = attackPoints;
        this.roomid = roomid;
        DefeatedMessage = defeatedMessage;
        this.itemReward = itemReward;
        this.itemReward2 = itemReward2;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(String attackPoints) {
        this.attackPoints = attackPoints;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getDefeatedMessage() {
        return DefeatedMessage;
    }

    public void setDefeatedMessage(String defeatedMessage) {
        DefeatedMessage = defeatedMessage;
    }

    public String getItemReward() {
        return itemReward;
    }

    public void setItemReward(String itemReward) {
        this.itemReward = itemReward;
    }

    public String getItemReward2() {
        return itemReward2;
    }

    public void setItemReward2(String itemReward2) {
        this.itemReward2 = itemReward2;
    }
}
