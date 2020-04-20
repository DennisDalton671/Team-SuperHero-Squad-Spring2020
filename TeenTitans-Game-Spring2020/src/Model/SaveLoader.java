package Model;

import java.util.ArrayList;

public class SaveLoader extends java.util.Observable{

	private ArrayList<SaveFile> saves;
	
	public SaveLoader() {
		saves = new ArrayList<SaveFile>();
		saves.add(new SaveFile("Room 1"));
		saves.add(new SaveFile("Room 2"));
		saves.add(new SaveFile("Room 3"));
		saves.get(0).setId("1");
		saves.get(1).setId("2");
		saves.get(2).setId("3");
	}

	public void getSaves() {
		setChanged();
		notifyObservers(saves);
	}
	
}
