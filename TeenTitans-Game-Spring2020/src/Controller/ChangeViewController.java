package Controller;

import Model.Model;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class ChangeViewController implements EventHandler<ActionEvent>{

	private Model model;
	private View view;
	
	public ChangeViewController(Model model, View view) {
		this.model = model;
		this.view = view;
		
	}
	
	public void initModel(int x){
		this.model.setValue(x);
	} 
	
	public void addModel(Model m){
		this.model = m;
	}
	
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//model.updateView();
		view.buildGame();
	}
	
}
