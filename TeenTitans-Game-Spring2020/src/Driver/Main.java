package Driver;
import Controller.ChangeViewController;
import Controller.InputController;
import Model.Model;
import Model.InputC;
import View.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	InputController control;
	ChangeViewController control2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		View view = new View();
		Scene scene = new Scene(view);
		Model model = new Model();
		InputC c = new InputC();
		
		model.addObserver(view);
		c.addObserver(view);
		
		//control = new InputController(model,view);
		control2 = new ChangeViewController(model,view);
		//control.addModel(model);
		control2.addModel(model);
		control = new InputController(c,view);
		//control.initModel(10);
		
		view.addInputController(control);
		view.changeViewController(control2);
		
		primaryStage.setTitle("Fun Testing");
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//control.buildView(primaryStage, view);
	}

}
