package Model;

import java.util.ArrayList;

public class Connector {

	private String output;
	private String description;
	private String image;
	private boolean isDesc;
	private ArrayList<Inventory> list;

	public Connector() {
		list = new ArrayList<Inventory>();
	}
	
	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getImage() {
		return image;
	}

	public ArrayList<Inventory> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		for (int x = 0; x < list.size(); x++) {
			this.list.add(new Inventory(list.get(x)));
		}
	}
	
	public void clearList() {
		list.clear();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		isDesc = true;
	}

	public boolean isDesc() {
		return isDesc;
	}

	public void setDesc(boolean isDesc) {
		this.isDesc = isDesc;
	}
	
	
	
}
