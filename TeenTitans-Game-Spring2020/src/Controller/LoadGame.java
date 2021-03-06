package Controller;

import Model.InputC;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LoadGame implements EventHandler<ActionEvent> {

	private InputC model;
	private View view;

	public LoadGame(InputC model, View view) {
		this.model = model;
		this.view = view;
	}

	public void addModel(InputC m) {
		this.model = m;
	}

	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		model.loadPlayer(view.getSave());
		view.buildGame();
		model.startup();
	}

}
