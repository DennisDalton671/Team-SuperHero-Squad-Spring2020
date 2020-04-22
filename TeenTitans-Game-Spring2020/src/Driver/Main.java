package Driver;
import Controller.ChangeViewController;
import Controller.EastInput;
import Controller.InputController;
import Controller.KeyInput;
import Controller.NorthInput;
import Controller.SouthInput;
import Controller.StartUpController;
import Controller.WestInput;
import Model.SaveLoader;
import Model.InputC;
import View.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	InputController control;
	ChangeViewController control2;
	KeyInput control3;
	StartUpController control4;
	NorthInput control5;
	EastInput control6;
	SouthInput control7;
	WestInput control8;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@SuppressWarnings("deprecation")
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		View view = new View();
		Scene scene = new Scene(view);
		InputC model = new InputC();
		InputC c = new InputC();
		SaveLoader s = new SaveLoader();
		
		model.addObserver(view);
		c.addObserver(view);
		s.addObserver(view);
		
		control = new InputController(c,view);
		control2 = new ChangeViewController(c,view);
		control3 = new KeyInput(c,view);
		control4 = new StartUpController(s,view);
		control5 = new NorthInput(c,view);
		control6 = new EastInput(c,view);
		control7 = new SouthInput(c,view);
		control8 = new WestInput(c,view);
		
		model.addObserver(view);
		c.addObserver(view);
		
		//control = new InputController(model,view);
		control2 = new ChangeViewController(c,view);
		//control.addModel(model);
		control2.addModel(c);
		control = new InputController(c,view);
		//control.initModel(10);
		
		view.addInputController(control);
		view.changeViewController(control2);
		view.addKeyInput(control3);
		view.startUpEvent(control4);
		view.addNorthInput(control5);
		view.addEastInput(control6);
		view.addSouthInput(control7);
		view.addWestInput(control8);
		
		primaryStage.setTitle("Fun Testing");
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//control.buildView(primaryStage, view);
	}

}
