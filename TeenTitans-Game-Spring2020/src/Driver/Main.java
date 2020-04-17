package Driver;

import Controller.ChangeViewController;
import Controller.InputController;
import Model.Model;
import MVC.Model2;
import View.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    InputController control;
    ChangeViewController control2;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Model2 m;
        launch(args);


    }

    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

        View view = new View();
        Scene scene = new Scene(view);
        Model model = new Model();

        model.addObserver(view);

        control = new InputController(model,view);
        control2 = new ChangeViewController(model,view);
        control.addModel(model);
        control2.addModel(model);
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

