package Controller;

import Model.InputC;
import View.View;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/* Takes input from the user and is activated with the enter button press */

public class KeyInput implements EventHandler<KeyEvent> {

	private InputC model;
	private View view;

	public KeyInput(InputC model, View view) {
		this.model = model;
		this.view = view;

	}

	public void addModel(InputC m) {
		this.model = m;
	}

	public void handle(KeyEvent keypress) {
		if (keypress.getCode() == KeyCode.ENTER) {
			model.checkUserInput(view.getInput());
		}
	}

}
