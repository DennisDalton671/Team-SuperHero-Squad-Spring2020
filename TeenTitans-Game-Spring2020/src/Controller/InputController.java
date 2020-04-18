package Controller;
import Model.Model;
import Model.InputC;
import View.View;
import javafx.event.Event;
import javafx.event.EventHandler;

public class InputController implements EventHandler {

	private InputC model;
	private View view;
	
	public InputController(InputC model, View view) {
		this.model = model;
		this.view = view;
		
	}

	
	public void addModel(InputC m){
		this.model = m;
	}
	
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		model.checkUserInput(view.getInput());
	}
	
}
