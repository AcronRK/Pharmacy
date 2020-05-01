package view;

import java.util.ArrayList;

import Model.Employee;
import Model.Pharmacist;
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

public class viewPharmacist {

	
	public void show(Stage stage) {
		
		stage.setTitle("Pharmacists");
		TableView table = new TableView();
		
		RWAccounts rwa = new RWAccounts();
		ObservableList<Employee> emp = FXCollections.observableArrayList(rwa.readEmp());
		ArrayList<Pharmacist> ph = new ArrayList<>();
		for(Employee x: rwa.readEmp()) {
			if(x instanceof Pharmacist)
				ph.add((Pharmacist) x);
			emp = FXCollections.observableArrayList(ph);
		}
		
		table.setMinSize(400, 600);
		
		TableColumn<String, Pharmacist> username = new TableColumn<String, Pharmacist>("Username");
		username.setCellValueFactory(new PropertyValueFactory<>("username"));
		username.setMinWidth(90);
		

		TableColumn<String, Pharmacist> name = new TableColumn<String, Pharmacist>("Name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setMinWidth(90);

		TableColumn<String, Pharmacist> surname = new TableColumn<String, Pharmacist>("Surname");
		surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
		surname.setMinWidth(90);
		
		
		TableColumn<Double, Pharmacist> salary = new TableColumn<Double, Pharmacist>("Salary");
		salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
		salary.setMinWidth(90);


		TableColumn<String, Pharmacist> bdt = new TableColumn<String, Pharmacist>("Birthday");
		bdt.setCellValueFactory(new PropertyValueFactory<>("bdt"));
		bdt.setMinWidth(90);
		
		TableColumn<String, Pharmacist> bills = new TableColumn<String, Pharmacist>("Bills");
		bills.setCellValueFactory(new PropertyValueFactory<>("bills"));
		bills.setMinWidth(90);
		
		TableColumn<String, Pharmacist> money = new TableColumn<String, Pharmacist>("Money");
		money.setCellValueFactory(new PropertyValueFactory<>("money"));
		money.setMinWidth(90);
		
		table.setItems(FXCollections.observableArrayList(emp));
		table.getColumns().addAll(username,name,surname,salary,bills,money,bdt);
		
		
		//button to add Employee
//		Button add = new Button("Add");
//		add.setPrefSize(70, 30);
//		add.setOnAction( e -> {
//			new createUserView().create(new Stage());
//		});
		
		//button to delete Employee
//		Button delete = new Button("Delete");
//		delete.setPrefSize(70, 30);
//		delete.setOnAction( e -> {
//			for(Object x: table.getSelectionModel().getSelectedItems()) {
//				if( x instanceof Employee) {
//					rwa.remove((Employee) x);
//					show(stage);
//				}
//			}
//		});
		
		Button close = new Button("Close");
		close.setPrefSize(70, 30);
		close.setOnAction(e -> {
			stage.close();
		});
		
		
		
		//creating a hbox for the buttons
		HBox buttons = new HBox(/*add*/  /*,delete*/  );
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

