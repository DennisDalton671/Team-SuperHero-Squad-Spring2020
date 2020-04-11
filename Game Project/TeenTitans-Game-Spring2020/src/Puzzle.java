import java.util.ArrayList;

public class Puzzle {

    private int id;
    private String description;
    private String solution;
    private ArrayList rewards;
    private boolean punishment;
    private int roomLocation;

    public Puzzle(int id, String description, String solution, ArrayList rewards, boolean punishment) {
        this.id = id;
        this.description = description;
        this.solution = solution;
        this.rewards = rewards;
        this.punishment = punishment;
    }

    // Getters
    public int getId() { return id; }
    public String getDescription() { return description; }
    public String getSolution() { return solution; }
    public ArrayList getRewards() { return rewards; }
    public boolean isPunishment() { return punishment; }
    public int getRoomLocation() { return roomLocation; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setSolution(String solution) { this.solution = solution; }
    public void setRewards(ArrayList rewards) { this.rewards = rewards; }
    public void setPunishment(boolean punishment) { this.punishment = punishment; }
    public void setRoomLocation(int roomLocation) { this.roomLocation = roomLocation; }
}
