package Driver;

import Controller.AttackInput;
import Controller.ChangeViewController;
import Controller.EastInput;
import Controller.InputController;
import Controller.KeyInput;
import Controller.LoadGame;
import Controller.LookInput;
import Controller.NorthInput;
import Controller.RestartInput;
import Controller.SouthInput;
import Controller.StartUpController;
import Controller.WestInput;
import Model.SaveLoader;
import Model.InputC;
import View.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* The main driver of the program and initializes the controllers, model, view, and structures the game*/

public class Main extends Application {

	InputController control;
	ChangeViewController control2;
	KeyInput control3;
	StartUpController control4;
	NorthInput control5;
	EastInput control6;
	SouthInput control7;
	WestInput control8;
	LoadGame control9;
	AttackInput control10;
	LookInput control11;
	RestartInput control12;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@SuppressWarnings("deprecation")
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		View view = new View(primaryStage);
		Scene scene = new Scene(view);
		InputC c = new InputC();
		SaveLoader s = new SaveLoader();
		c.addObserver(view);
		s.addObserver(view);

		control = new InputController(c, view);
		control2 = new ChangeViewController(c, view);
		control3 = new KeyInput(c, view);
		control4 = new StartUpController(s, view);
		control5 = new NorthInput(c);
		control6 = new EastInput(c);
		control7 = new SouthInput(c);
		control8 = new WestInput(c);
		control9 = new LoadGame(c, view);
		control10 = new AttackInput(c);
		control11 = new LookInput(c);
		control12 = new RestartInput(c);

		control2 = new ChangeViewController(c, view);
		control2.addModel(c);
		control = new InputController(c, view);

		view.addInputController(control);
		view.changeViewController(control2);
		view.addKeyInput(control3);
		view.startUpEvent(control4);
		view.addNorthInput(control5);
		view.addEastInput(control6);
		view.addSouthInput(control7);
		view.addWestInput(control8);
		view.loadGameController(control9);
		view.addAttackInput(control10);
		view.addLookInput(control11);
		view.addRestartInput(control12);

		primaryStage.setTitle("Mansion Escape");
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
