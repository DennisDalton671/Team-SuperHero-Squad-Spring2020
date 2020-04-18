package Model;

public class Model extends java.util.Observable{

	private int counter;
	private String string;
	
	public void setValue(int v) {
		this.counter = v;
		setChanged();
		notifyObservers(counter);
	}
	
	public void incrementValue() {
		counter++;
		setChanged();
		notifyObservers(counter);
	}
	
	public void addString(String string) {
		this.string = string;
		setChanged();
		notifyObservers(this.string);
	}
	
	public void updateView() {
		setChanged();
		notifyObservers();
	}
}
