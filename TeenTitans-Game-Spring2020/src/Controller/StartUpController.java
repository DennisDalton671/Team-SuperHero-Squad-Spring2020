package Controller;

import Model.SaveLoader;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartUpController implements EventHandler<ActionEvent> {

	private SaveLoader model;
	private View view;
	
	public StartUpController(SaveLoader model, View view) {
		this.model = model;
		this.view = view;
	}


	public void addModel(SaveLoader m){
		this.model = m;
	}
	
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		view.setSTabel();
		model.getSaves();
	}

	
	
}
