package Controller;

import Model.InputC;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RestartInput implements EventHandler<ActionEvent> {
	private InputC model;

	public RestartInput(InputC model) {
		this.model = model;
	}

	public void addModel(InputC m) {
		this.model = m;
	}

	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		model.checkUserInput("Reset");
	}
}
