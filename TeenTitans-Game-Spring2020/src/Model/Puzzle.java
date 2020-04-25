package Model;

/* Stores all of the infromation about a puzzle */

public class Puzzle {

    private String id;
    private String name;
    private String description;
    private String hint1;
    private String hint2;
    private String hint3;
    private String hint4;
    private String solution;
    private String reward;
    private String penalty;
    private String room_puzzle;
    private String completion;
    private String itemRequired_1;
    private String itemRequired_2;
    private String itemRequired_3;
    private String itemRequired_4;
    
    public Puzzle(String id, String name, String description, String hint1, String hint2, String hint3, String hint4, String solution, String reward, String penalty, String room_puzzle, String completion, String itemRequired_1, String itemRequired_2, String itemRequired_3, String itemRequired_4) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hint1 = hint1;
        this.hint2 = hint2;
        this.hint3 = hint3;
        this.hint4 = hint4;
        this.solution = solution;
        this.reward = reward;
        this.penalty = penalty;
        this.room_puzzle = room_puzzle;
        this.completion = completion;
        this.itemRequired_1 = itemRequired_1;
        this.itemRequired_2 = itemRequired_2;
        this.itemRequired_3 = itemRequired_3;
        this.itemRequired_4 = itemRequired_4;
    }

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

	public String getHint1() {
		return hint1;
	}

	public void setHint1(String hint1) {
		this.hint1 = hint1;
	}

	public String getHint2() {
		return hint2;
	}

	public void setHint2(String hint2) {
		this.hint2 = hint2;
	}

	public String getHint3() {
		return hint3;
	}

	public void setHint3(String hint3) {
		this.hint3 = hint3;
	}

	public String getHint4() {
		return hint4;
	}

	public void setHint4(String hint4) {
		this.hint4 = hint4;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getPenalty() {
		return penalty;
	}

	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}

	public String getRoom_puzzle() {
		return room_puzzle;
	}

	public void setRoom_puzzle(String room_puzzle) {
		this.room_puzzle = room_puzzle;
	}

	public String getCompletion() {
		return completion;
	}

	public void setCompletion(String completion) {
		this.completion = completion;
	}

	public String getItemRequired_1() {
		return itemRequired_1;
	}

	public void setItemRequired_1(String itemRequired_1) {
		this.itemRequired_1 = itemRequired_1;
	}

	public String getItemRequired_2() {
		return itemRequired_2;
	}

	public void setItemRequired_2(String itemRequired_2) {
		this.itemRequired_2 = itemRequired_2;
	}

	public String getItemRequired_3() {
		return itemRequired_3;
	}

	public void setItemRequired_3(String itemRequired_3) {
		this.itemRequired_3 = itemRequired_3;
	}

	public String getItemRequired_4() {
		return itemRequired_4;
	}

	public void setItemRequired_4(String itemRequired_4) {
		this.itemRequired_4 = itemRequired_4;
	}

    // Getters

    
    

}