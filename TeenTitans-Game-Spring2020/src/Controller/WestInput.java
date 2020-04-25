package Controller;

import Model.InputC;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/* This controller initializes the west button to work in the game */

public class WestInput implements EventHandler<ActionEvent>{
	private InputC model;
	
	public WestInput(InputC model) {
		this.model = model;
	}

	public void addModel(InputC m){
		this.model = m;
	}
	
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.checkUserInput("West");
	}
}
