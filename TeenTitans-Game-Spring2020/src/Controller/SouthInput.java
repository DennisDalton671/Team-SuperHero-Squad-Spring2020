package Controller;

import Model.InputC;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/* This controller initializes the south button to work in the game */

public class SouthInput implements EventHandler<ActionEvent>{
	private InputC model;
	
	public SouthInput(InputC model) {
		this.model = model;
	}

	public void addModel(InputC m){
		this.model = m;
	}
	
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.checkUserInput("South");
	}
}
