package view;

import java.util.ArrayList;

import Model.Employee;
import Model.RWAccounts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class viewEmployee {

	public void show(Stage stage) {
		
		stage.setTitle("Employees");
		
		TableView table = new TableView();
		table.setEditable(true);
		
		RWAccounts rwa = new RWAccounts();
		
		//arraylist of the employees which will be shows
		ArrayList<Employee> emp = new ArrayList<>();
		//filling up the arraylist
		emp = rwa.readEmp();
		
		
		table.setEditable(true);
		table.setMinSize(400, 600);
		
		TableColumn<String, Employee> username = new TableColumn<String, Employee>("Username");
		username.setCellValueFactory(new PropertyValueFactory<>("username"));
		username.setMinWidth(90);
		

		TableColumn<String, Employee> name = new TableColumn<String, Employee>("Name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setMinWidth(90);

		TableColumn<String, Employee> surname = new TableColumn<String, Employee>("Surname");
		surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
		surname.setMinWidth(90);
		
		TableColumn<Double, Employee> salary = new TableColumn<Double, Employee>("Salary");
		salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
		salary.setMinWidth(90);

		TableColumn<String, Employee> bdt = new TableColumn<String, Employee>("Birthday");
		bdt.setCellValueFactory(new PropertyValueFactory<>("bdt"));
		bdt.setMinWidth(90);
		
		table.setItems(FXCollections.observableArrayList(emp));
		table.getColumns().addAll(username,name,surname,salary,bdt);
		
		
		//button to add Employee
		Button add = new Button("Add");
		add.setPrefSize(70, 30);
		add.setOnAction( e -> {
			new createUserView().create(new Stage());
		});
		
		//button to delete Employee
		Button delete = new Button("Delete");
		delete.setPrefSize(70, 30);
		delete.setOnAction( e -> {
			for(Object x: table.getSelectionModel().getSelectedItems()) {
				if( x instanceof Employee) {
					rwa.remove((Employee) x);
					show(stage);
				}
			}
		});
		
		Button close = new Button("Close");
		close.setPrefSize(70, 30);
		close.setOnAction(e -> {
			stage.close();
		});
		
		
		
		//creating a hbox for the buttons
		HBox buttons = new HBox(add,delete);
		buttons.setAlignment(Pos.CENTER);
		buttons.setSpacing(20);
		
		BorderPane pane = new BorderPane();
		pane.setLeft(buttons);
		pane.setRight(close);
		pane.setPadding(new Insets(15));
		
		VBox vbox = new VBox(table,pane);
		vbox.setSpacing(30);
		
		stage.setScene(new Scene(vbox,600,700));
		stage.show();
		
	}
}
