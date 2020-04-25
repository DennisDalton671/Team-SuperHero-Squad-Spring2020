package Controller;

import Model.InputC;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/* This controller initializes the north button to work in the game */

public class NorthInput implements EventHandler<ActionEvent>{
	private InputC model;
	
	public NorthInput(InputC model) {
		this.model = model;	
	}

	public void addModel(InputC m){
		this.model = m;
	}
	
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.checkUserInput("North");
	}
}
