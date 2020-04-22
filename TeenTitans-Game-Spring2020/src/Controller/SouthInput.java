package Controller;

import Model.InputC;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SouthInput implements EventHandler<ActionEvent>{
	private InputC model;
	private View view;
	
	public SouthInput(InputC model, View view) {
		this.model = model;
		this.view = view;
		
	}

	
	public void addModel(InputC m){
		this.model = m;
	}
	
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.checkUserInput("South");
	}
}
