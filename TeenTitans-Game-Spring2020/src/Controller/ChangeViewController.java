package Controller;

import Model.InputC;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ChangeViewController implements EventHandler<ActionEvent>{

	private InputC model;
	private View view;
	
	public ChangeViewController(InputC model, View view) {
		this.model = model;
		this.view = view;
		
	}
	
	public void addModel(InputC model) {
		this.model = model;
	}
	
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//model.updateView();
		view.buildGame();
		model.startup();
	}
	
}
