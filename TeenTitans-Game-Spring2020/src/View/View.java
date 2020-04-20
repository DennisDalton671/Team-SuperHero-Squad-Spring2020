package View;
import java.util.ArrayList;
import java.util.Observable;

import Model.Connector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.WindowEvent;

public class View extends BorderPane implements java.util.Observer {

	public static final int width = 1920;
	public static final int height = 1080;
	
	private Label title;
	
	private GridPane grid1;
	private Button newGame;
	private Button loadSaves;
	private TableView table;
	private ScrollPane sp1;
	private Button continueGame;
	
	private GridPane grid2;
	private GridPane grid3;
	private GridPane grid4;
	private GridPane grid5;
	private TableView inventory;
	private Label health;
	private Label attack;
	private Label equipped;
	private TextArea display;
	private ScrollPane sp2;
	private TextField text; 
	private Button inputButton;
	private Button northButton;
	private Button eastButton;
	private Button southButton;
	private Button westButton;
	
	public View() {
		
		defaultSetup();
		buildMenu();

	}
	
	public void addInputController(EventHandler<ActionEvent> controller){
		inputButton = new Button("Input");
		setButton(inputButton);
		inputButton.setOnAction(controller);
	}
	
	public void changeViewController(EventHandler<ActionEvent> controller){
		newGame.setOnAction(controller);
		continueGame.setOnAction(controller);
	}
	
	public void addKeyInput(EventHandler<KeyEvent> controller) {
		this.setOnKeyPressed(controller);
	}
	
	public void startUpEvent(EventHandler<ActionEvent> controller) {
		loadSaves.setOnAction(controller);
	}
	
	public String getInput() {
		String temp = text.getText();
		text.clear();
		return temp;
	}

	public void update(Observable o, Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Connector) {
			String updated = fixString(((Connector)obj).getOutput());
			this.display.appendText(updated + "\n");
		}
		if (obj instanceof ArrayList) {
			for (int x = 0; x < ((ArrayList) obj).size(); x++) {
				table.getItems().add(((ArrayList) obj).get(x));
			}
		}
		//this.display.appendText(((Connector)obj).getOutput() + "\n");
	}
	
	public void defaultSetup() {
		title = new Label("Mansion Escape");

		this.setPadding(new Insets(20, 20, 20, 20));

		this.setStyle(("-fx-background-color: indigo;"));

		Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 50);
		title.setFont(font);
		title.setTextFill(javafx.scene.paint.Color.LIGHTGRAY);

		setAlignment(title, Pos.CENTER);
		this.setTop(title);
	}
	
	public void buildMenu() {
		this.setCenter(null);
		
		grid1 = new GridPane();
		newGame = new Button("Start New Game");
		loadSaves = new Button("Load Saves");
		table = new TableView();
		sp1 = new ScrollPane();
		continueGame = new Button("Continue Game");
		
		table.setMinWidth(400);
		
		setButton(newGame);
		setButton(loadSaves);
		setButton(continueGame);
		
		loadSaves.setAlignment(Pos.CENTER);
		
		grid1.setHgap(50);
		grid1.setVgap(25);
		
		
		grid1.add(newGame, 0, 0);
		grid1.add(loadSaves, 0, 1);
		
		grid1.setAlignment(Pos.CENTER);
		GridPane.setHalignment(newGame, HPos.CENTER);
		GridPane.setHalignment(loadSaves, HPos.CENTER);
		
		setAlignment(grid1, Pos.CENTER);
		this.setCenter(grid1);
		
	}
	
	public void buildGame() {
		this.setCenter(null);
		
		sp2 = new ScrollPane();
		display = new TextArea();
		text = new TextField();
		//inputButton = new Button("Button 1");
		grid2 = new GridPane();
		grid3 = new GridPane();
		grid4 = new GridPane();
		
		inventory = new TableView();
		
		northButton = new Button("North");
		eastButton = new Button("East");
		southButton = new Button("South");
		westButton = new Button("West");
		
		setButton(northButton);
		setButton(eastButton);
		setButton(southButton);
		setButton(westButton);
		
		health = new Label("100");
		attack = new Label("50");
		equipped = new Label("None");
		Label healthD = new Label("Health = ");
		Label attackD = new Label("Attack = ");
		Label equippedD = new Label("Equipped = ");
		Label inventoryD = new Label("Inventory = ");
		
		setLabel(health);
		setLabel(healthD);
		setLabel(attack);
		setLabel(attackD);
		setLabel(equipped);
		setLabel(equippedD);
		setLabel(inventoryD);
		
		TableColumn inventoryC = new TableColumn<Object, Object>("Inventory");
        inventoryC.setCellValueFactory(new PropertyValueFactory("Inventory"));
		
        inventory.getColumns().setAll(inventoryC);
        
        grid3.add(healthD, 0, 0);
        grid3.add(health, 1, 0);
        grid3.add(attackD, 0, 1);
        grid3.add(attack, 1, 1);
        grid3.add(equippedD, 0, 2);
        grid3.add(equipped, 1, 2);
        grid3.add(inventoryD, 0, 3);
        grid3.add(inventory, 1, 3);
		
		sp2.setStyle(("-fx-background: black;" + "-fx-background-color: black"));
		
		display.setMinHeight(height/2);
		display.setMinWidth(width/2);
		sp2.setMinHeight(height/2);
		sp2.setMinWidth(width/2);
		
		sp2.setContent(display);
		
		grid2.add(display, 0, 0);
		grid2.add(text, 0, 1);
		grid2.add(inputButton, 0, 2);
		
		grid4.add(new Label(), 0, 0);
		grid4.add(northButton, 1, 0);
		grid4.add(new Label(), 2, 0);
		grid4.add(westButton, 0, 1);
		grid4.add(new Label(), 1, 1);
		grid4.add(eastButton, 2, 1);
		grid4.add(new Label(), 0, 2);
		grid4.add(southButton, 1, 2);
		grid4.add(new Label(), 2, 2);
		
		grid2.setAlignment(Pos.CENTER);
		grid3.setAlignment(Pos.CENTER);
		grid4.setAlignment(Pos.CENTER);
		GridPane.setHalignment(inputButton, HPos.RIGHT);
		
		display.setEditable(false);
		
		grid2.setPadding(new Insets(20,20,20,20));
		
		grid5 = new GridPane();
		
		Button b = new Button("Test");
		
		b.setMinHeight(400);
		b.setMinWidth(450);
		
		grid4.setPadding(new Insets(20,20,20,20));
		
		grid5.add(b, 0, 0);
		grid5.add(grid4, 0,1);
		
		this.setLeft(grid3);
		this.setCenter(grid2);
		this.setRight(grid5);
	}
	
	
	public Button setButton(Button b) {
		b.setStyle("-fx-font-size: 40");
		b.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
		b.setMinHeight(100);
		b.setMinWidth(150);
		return b;
	}
	
	public Label setLabel(Label l) {
		Font font = Font.font("Verdana", FontWeight.EXTRA_BOLD, 25);
		l.setFont(font);
		l.setTextFill(Color.WHITE);
		return l;
	}
	
	public String fixString(String s) {
		int wrapLength = 175;
	    String wrapString = new String();

	    while(s.length()>wrapLength){
	        int lastIndex = s.lastIndexOf(" ", wrapLength);
	        wrapString = wrapString.concat(s.substring(0, lastIndex));
	        wrapString = wrapString.concat("\n");

	        s = s.substring(lastIndex+1, s.length());
	    }
	    return wrapString + s + "\n";
		
	}
	
	public void setSTabel() {
		table = new TableView();
		sp1 = new ScrollPane();
		
		table.setMinWidth(400);
		
		sp1.setContent(table);
		
		TableColumn saveCol = new TableColumn("Save");
        saveCol.setCellValueFactory(new PropertyValueFactory("id"));
        TableColumn roomCol = new TableColumn("Current Room");
        roomCol.setCellValueFactory(new PropertyValueFactory("room"));
        
        table.getColumns().setAll(saveCol, roomCol);
        
        grid1.getChildren().remove(loadSaves);
        grid1.add(sp1, 0, 1);
        grid1.add(continueGame, 0, 2);
        
        GridPane.setHalignment(sp1, HPos.CENTER);
        GridPane.setHalignment(continueGame, HPos.CENTER);
	}
}
