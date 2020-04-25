package Controller;
import Model.InputC;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/* This controller is the main controller of the game and takes the user input and places it into the model
 * to do the heavy lifting for the program*/

public class InputController implements EventHandler<ActionEvent> {
	
	private InputC model;
	private View view;
	
	public InputController(InputC model, View view) {
		this.model = model;
		this.view = view;
		
	}

	
	public void addModel(InputC m){
		this.model = m;
	}
	
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.checkUserInput(view.getInput());
	}
	
}
