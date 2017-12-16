package com.richard.airline.reservations1;

import javafx.application.Application;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.swing.text.html.ListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.CheckBox;

public class Front extends Application {

	static Back backEnd = new Back();
	static boolean isValid;

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("Dick's airline since 1969.");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);

		Text titleText = new Text("Dick's Airline Company Hello.");
		Text failText = new Text("Login attempt Failed Senior");
		Label userLabel = new Label("Username: ");
		Label passLabel = new Label("Password: ");
		TextField userField = new TextField();
		PasswordField passField = new PasswordField();
		Button signUpButton = new Button("Sign Up");
		Button loginButton = new Button("Login");
		Button tempButton = new Button("Am not a customer I'm a big important airline busniessman, this is an emergency & I need to do some big important busniess stuff QUICK!");
		titleText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		failText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));

		loginButton.setOnAction(event -> {
			try {
				isValid = backEnd.login(userField.getText(), passField.getText());
				if (isValid == true) {
					primaryStage.setScene(this.drawHomeScreen(primaryStage));
				}
				if (isValid == false) {
					grid.add(failText, 1, 7);
				}
			}

			catch (Exception e) {
				System.err.println(e);
			}

		});

		signUpButton.setOnAction(event -> {
			primaryStage.setScene(this.drawRegisterScene(primaryStage));
		});
		
		tempButton.setOnAction( event -> {
			primaryStage.setScene(this.drawUtilitiesScreen(primaryStage));
		});

		grid.add(titleText, 0, 0, 2, 1);
		grid.add(userLabel, 0, 3);
		grid.add(userField, 1, 3);
		grid.add(passLabel, 0, 4);
		grid.add(passField, 1, 4);
		grid.add(loginButton, 1, 5);
		grid.add(signUpButton, 2, 5);
		grid.add(tempButton, 1, 6);
		Scene currentScene = new Scene(grid, 1000, 500);
		primaryStage.setScene(currentScene);
		primaryStage.show();
	}

	public Scene drawRegisterScene(Stage primaryStage) {

		primaryStage.setTitle("Dick's Airline Registration");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);

		Text registerTitle = new Text("Dick Airlines Registration.");
		registerTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 35));
		Label firstlab = new Label("First Name: ");
		Label lastlab = new Label("Last Name: ");
		Label addresslab = new Label("Address: ");
		Label contactnumlab = new Label("Contact Number: ");
		Label citylab = new Label("City: ");
		Label statelab = new Label("State: ");
		Label countrylab = new Label("Country: ");
		Label genderlab = new Label("Gender: ");
		Label emaillab = new Label("Email: ");
		Label idlab = new Label("User ID: ");
		Label passlab = new Label("Password: ");
		TextField firstField = new TextField();
		TextField lastField = new TextField();
		TextField addressField = new TextField();
		TextField contactNumField = new TextField();
		TextField cityField = new TextField();
		TextField stateField = new TextField();
		TextField countryField = new TextField();
		TextField genderField = new TextField();
		TextField emailField = new TextField();
		TextField idField = new TextField();
		PasswordField passField = new PasswordField();
		Button submitButton = new Button("Submit");
		submitButton.setOnAction(event -> {
			backEnd.registerInfo[0] = firstField.getText();
			backEnd.registerInfo[1] = lastField.getText();
			backEnd.registerInfo[2] = addressField.getText();
			backEnd.registerInfo[3] = contactNumField.getText();
			backEnd.registerInfo[4] = cityField.getText();
			backEnd.registerInfo[5] = stateField.getText();
			backEnd.registerInfo[6] = countryField.getText();
			backEnd.registerInfo[7] = genderField.getText();
			backEnd.registerInfo[8] = emailField.getText();
			backEnd.registerInfo[9] = idField.getText();
			backEnd.registerInfo[10] = passField.getText();
			backEnd.registerNewUser(backEnd.registerInfo);
			primaryStage.setScene(this.drawYouHaveRegisterdScreen(primaryStage));

		});

		grid.add(registerTitle, 0, 0, 2, 1);
		grid.add(firstlab, 0, 1);
		grid.add(firstField, 1, 1);
		grid.add(lastlab, 0, 2);
		grid.add(lastField, 1, 2);
		grid.add(addresslab, 0, 3);
		grid.add(addressField, 1, 3);
		grid.add(contactnumlab, 0, 4);
		grid.add(contactNumField, 1, 4);
		grid.add(citylab, 0, 5);
		grid.add(cityField, 1, 5);
		grid.add(statelab, 0, 6);
		grid.add(stateField, 1, 6);
		grid.add(countrylab, 0, 7);
		grid.add(countryField, 1, 7);
		grid.add(genderlab, 0, 8);
		grid.add(genderField, 1, 8);
		grid.add(emaillab, 0, 9);
		grid.add(emailField, 1, 9);
		grid.add(idlab, 0, 10);
		grid.add(idField, 1, 10);
		grid.add(passlab, 0, 11);
		grid.add(passField, 1, 11);
		grid.add(submitButton, 1, 12);

		grid.setGridLinesVisible(false);
		Scene currentScene = new Scene(grid, 700, 400);
		primaryStage.setScene(currentScene);
		return currentScene;

	}

	public Scene drawHomeScreen(Stage primaryStage) {
		GridPane grid = new GridPane();

		Text head = new Text("Dick Airlines");
		Text head2 = new Text("Since 1969.");
		head.setFont(Font.font("Tahoma", FontWeight.NORMAL, 40));
		head2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		Button lookUpReservationsButton = new Button("Look up avliable reservations.");
		Button viewMyReservationsButton = new Button("View my current reservations.");
		Button manageAccountButton = new Button("Manage my account.");
		
		lookUpReservationsButton.setOnAction( event -> {
			primaryStage.setScene(this.drawLookUpReservationsScreen(primaryStage));
		});
		
		manageAccountButton.setOnAction( event -> {
			primaryStage.setScene(this.drawAccountManagementScreen(primaryStage));
		});
		
		grid.add(head, 0, 0);
		grid.add(head2, 0, 1);
		grid.add(lookUpReservationsButton, 0, 2);
		grid.add(viewMyReservationsButton, 0, 5);
		grid.add(manageAccountButton, 0, 8);

		Scene currentScene = new Scene(grid, 700, 500);
		return currentScene;

	}
	
	public Scene drawAccountManagementScreen(Stage primaryStage){
		 GridPane grid = new GridPane();
		 Button updateInfo = new Button("Update login info");
		 Button updatePayment = new Button("Manage existing payment methods");
		 Button addPaymentMethod = new Button("Add new Payment method");
		 
		 addPaymentMethod.setOnAction(event -> {
			 primaryStage.setScene(this.drawAddPaymentMethodScreen(primaryStage));
		 });
		 
		 grid.add(updateInfo, 0, 3);
		 grid.add(updatePayment, 0, 4);
		 grid.add(addPaymentMethod, 0, 5);
		 Scene currentScene = new Scene(grid, 700, 500);
		 return currentScene;
		 
	 }

	public Scene drawLookUpReservationsScreen(Stage primaryStage){
	
	 String[] specs = new String[5];
	 GridPane grid = new GridPane();
	 Label orCityLab = new Label("Origin City: ");
	 Label desCityLab = new Label("Destination City: ");
	 Label monthLab = new Label("Departure Month: ");
	 Label dayLab= new Label("Departure Day: ");
	 Label seatLab = new Label("Seat Preferance: ");
	 TextField desCityField = new TextField();
	 TextField orCityField = new TextField();
	 ChoiceBox<String> seatList = new ChoiceBox<>();
	 ChoiceBox<String> monthList = new ChoiceBox<>();
	 ChoiceBox<String> dayList = new ChoiceBox<>();
	 monthList.getItems().addAll("January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
	 monthList.setValue("January");
	 dayList.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
	 dayList.setValue("01");
	 seatList.getItems().addAll("First Class", "Coach");
	 Button searchButt = new Button("Search for them reservations");
	 Button homeButt = new Button("Home");
	 searchButt.setOnAction( event -> {

		 specs[0] = desCityField.getText();
		 specs[1] = orCityField.getText();
		 specs[2] = backEnd.convertMonth(monthList.getValue());
		 specs[3] = dayList.getValue();
		 primaryStage.setScene(this.drawResultReservationsScreen(primaryStage, backEnd.searchReservations(specs)));

	
	 });
	 
	 homeButt.setOnAction( event -> {
	 	
	 	primaryStage.setScene(this.drawHomeScreen(primaryStage));
	 
	 });
	
	 grid.add(orCityLab, 0, 1);
	 grid.add(orCityField, 1, 1);
	 grid.add(desCityLab, 0, 2);
	 grid.add(desCityField ,1, 2);
	 grid.add(monthLab, 0, 3);
	 grid.add(monthList, 1, 3);
	 grid.add(dayLab, 0, 4);
	 grid.add(dayList, 1, 4);
	 grid.add(seatLab, 0, 5);
	 grid.add(seatList, 1, 5);
	 grid.add(homeButt, 1, 6);
	 grid.add(searchButt, 0, 6);
	 Scene currentScene = new Scene(grid, 500, 500);
	 return currentScene;
	
	 }

	public Scene drawResultReservationsScreen(Stage primaryStage, ArrayList<Flight> fargs){
	
	 GridPane grid = new GridPane();
	 int x = 1;
	 int y = 1;
//	 grid.setPadding();
	 Label head = new Label("Avliable Reservations based on yo criteria.");
	 grid.add(head, 1, 0);
	 for (Flight i: fargs){
		 Button reserve = new Button("Book Now.");
		 reserve.setOnAction(event -> {
			 System.out.println("getting all seats from flight" + i.flightID);
			 primaryStage.setScene(this.drawAvailableSeatsScreen(primaryStage, backEnd.getAvailableSeats(i)));
		 });
		 		
		Text departTimeText = new Text(i.getDepartTime());
		Text arrivalTimeText = new Text(i.getArrivalTime());
		Text departDateText = new Text(i.getArrivalTime());
		Text originCity = new Text(i.getOriginCity());
		Text destinationCity = new Text(i.getDestinationCity());
		
		grid.add(reserve, 0, y);
		grid.add(departTimeText, 2, y);
		grid.add(arrivalTimeText, 3, y);
		grid.add(departDateText, 4, y);
		grid.add(originCity, 5, y);
		grid.add(destinationCity, 6, y);
		y += 1;
	 	}
	 Scene currentScene = new Scene(grid, 500, 500);
	 return currentScene;
	 
	 }

	public Scene drawYouHaveRegisterdScreen(Stage primaryStage) {

		primaryStage.setTitle("Dick's Airline Registration");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		Text onlyTextOnThisScreen = new Text("YOU HAVE SUCCESFULLY REGISTERED!!!");
		onlyTextOnThisScreen.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
		Button onlyButtonForTheeseScreenSenior = new Button("Alright");
		onlyButtonForTheeseScreenSenior.setOnAction(event -> {
			primaryStage.setScene(this.drawLoginScreen(primaryStage));
		});

		grid.add(onlyTextOnThisScreen, 0, 0);
		grid.add(onlyButtonForTheeseScreenSenior, 1, 1);
		Scene currentScene = new Scene(grid, 700, 400);

		return currentScene;

	}

	public Scene drawLoginScreen(Stage primaryStage) {
		primaryStage.setTitle("Dick's airline since 1969.");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);

		Text titleText = new Text("Dick's Airline Company Hello.");
		Label userLabel = new Label("Username: ");
		Label passLabel = new Label("Password: ");
		TextField userField = new TextField();
		Text failText = new Text("Login attempt Failed Senior");
		PasswordField passField = new PasswordField();
		Button signUpButton = new Button("Sign Up");
		Button loginButton = new Button("Login");
		titleText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));

		 loginButton.setOnAction( event -> {
			 try {
					isValid = backEnd.login(userField.getText(), passField.getText());
					if (isValid == true) {
						primaryStage.setScene(this.drawHomeScreen(primaryStage));
					}
					if (isValid == false) {
						grid.add(failText, 1, 6);
					}
				}

				catch (Exception e) {
					System.err.println("ayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
				}
		});

		grid.add(titleText, 0, 0, 2, 1);
		grid.add(userLabel, 0, 3);
		grid.add(userField, 1, 3);
		grid.add(passLabel, 0, 4);
		grid.add(passField, 1, 4);
		grid.add(loginButton, 1, 5);
		grid.add(signUpButton, 2, 5);
		Scene currentScene = new Scene(grid, 700, 250);
		primaryStage.setScene(currentScene);
		primaryStage.show();
		return currentScene;
	}
	
	public Scene drawUtilitiesScreen(Stage primaryStage){
		primaryStage.setTitle("Dick Airline Utilities");
		GridPane grid = new GridPane();
		Button addFlightButton = new Button("Schedule A Flight");
		grid.add(addFlightButton, 1, 1);
	
		
	
		addFlightButton.setOnAction(event -> {
			primaryStage.setScene(this.drawAddFlightScreen(primaryStage));
		});
		
		Scene currentScene = new Scene(grid, 1000, 1000);
		return currentScene;
		
		
	}
	
	public Scene drawAddFlightScreen(Stage primaryStage){
		
		primaryStage.setTitle("Add a flight (Utilities)");
		
		GridPane grid = new GridPane();
		
		Label originCityLab = new Label("City of origin");
		Label originCountryLab = new Label("Country of Origin");
		Label destinationLab = new Label("Destination City");
		Label departDateLab = new Label("Date of departure");
		Label departTimeLab = new Label("Time of departure");
		Label etaLab = new Label("Estimated Time Of Arrival");
		Label firstClassQunatityLab = new Label("Number Of First Class Seats");
		Label coachQuantityLab = new Label("Number of Coach Seats");
		Label firstClassPriceLab = new Label("First Class Price");
		Label coachPriceLab = new Label("Coach Price");
		TextField originCityField = new TextField();
		TextField originCountryField = new TextField();
		TextField destinationField = new TextField();
		ChoiceBox<String> departMonthChoice = new ChoiceBox();
		ChoiceBox<String> departDayChoice = new ChoiceBox();
		ChoiceBox<String> departHourChoice = new ChoiceBox();
		ChoiceBox<String> departMinuteChoice = new ChoiceBox();
		TextField firstClassQuantityField = new TextField();
		TextField firstClassPriceField = new TextField();
		TextField coachQuantityField = new TextField();
		TextField coachPriceField = new TextField();
		
		departMonthChoice.getItems().addAll("January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		departMonthChoice.setValue("January");
		departDayChoice.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
		departDayChoice.setValue("01");
		departHourChoice.getItems().addAll("00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23");
		departHourChoice.setValue("00");
		departMinuteChoice.getItems().addAll("00", "15", "30", "45");
		departMinuteChoice.setValue("00");
		
		Button submitButton = new Button("Submit");
		submitButton.setOnAction( event ->{
			
			backEnd.specs[0] = originCityField.getText();
			backEnd.specs[1] = originCountryField.getText();
			backEnd.specs[2] = destinationField.getText();
			backEnd.specs[3] = backEnd.convertMonth(departMonthChoice.getValue());
			backEnd.specs[4] = departDayChoice.getValue();
			backEnd.specs[5] = departHourChoice.getValue();
			backEnd.specs[6] = departMinuteChoice.getValue();
			backEnd.nums[1] = Integer.parseInt(firstClassQuantityField.getText());
			backEnd.nums[2] = Integer.parseInt(firstClassPriceField.getText());
			backEnd.nums[3] = Integer.parseInt(coachQuantityField.getText());
			backEnd.nums[4] = Integer.parseInt(coachPriceField.getText());
			
			
			backEnd.addNewFlight(backEnd.specs, backEnd.nums);
			
		});
		
		grid.add(originCityLab, 0, 1);
		grid.add(originCountryLab, 0, 2);
		grid.add(destinationLab, 0, 3);
		grid.add(departDateLab, 0, 4);
		grid.add(departTimeLab, 0, 5);
		grid.add(etaLab, 0, 6);
		grid.add(firstClassQunatityLab, 0, 7);
		grid.add(firstClassPriceLab, 0, 8);
		grid.add(coachQuantityLab, 0, 9);
		grid.add(coachPriceLab, 0, 10);
		
		grid.add(originCityField, 1, 1);
		grid.add(originCountryField, 1, 2);
		grid.add(destinationField, 1, 3);
		grid.add(departDayChoice, 1, 4 );
		grid.add(departMonthChoice, 2, 4);
		grid.add(departHourChoice, 1, 5);
		grid.add(departMinuteChoice, 2, 5);
		grid.add(firstClassQuantityField, 1, 7);
		grid.add(firstClassPriceField, 1, 8);
		grid.add(coachQuantityField, 1, 9);
		grid.add(coachPriceField, 1, 10);
		grid.add(submitButton, 0, 11);
		
		Scene currentScene = new Scene(grid, 500, 500);
		return currentScene;
		
		
		
	}

	public Scene drawAddPaymentMethodScreen(Stage primaryStage){
		GridPane grid = new GridPane();
		Label cardNumLab = new Label("Card Number: ");
		Label cardNameLab = new Label("Card Holder: ");
		Label experationLab = new Label("Experation Date: ");
		Label securityKeyLab = new Label("Security Key: ");
		Label failText = new Label("Faliled to add payment method");
		ChoiceBox<String> monthList = new ChoiceBox<>();
		ChoiceBox<String> yearList = new ChoiceBox<>();
		monthList.getItems().addAll("January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		yearList.getItems().addAll("2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030");
		monthList.setValue("January");
		yearList.setValue("2018");
		TextField numField = new TextField();
		TextField holderField = new TextField();
		TextField securityField = new TextField();
		Button submitButton = new Button("Submit");
		submitButton.setOnAction( event -> {
			backEnd.specs[0] = numField.getText();
			backEnd.specs[1] = holderField.getText();
			backEnd.specs[2] = securityField.getText();
			backEnd.specs[3] = backEnd.convertMonth(monthList.getValue());
			backEnd.specs[4] = yearList.getValue();
			try{
			if (backEnd.addPaymentMethod(backEnd.specs) == true){
				primaryStage.setScene(this.drawYouHaveRegisterdScreen(primaryStage));
			}
			else {
				grid.add(failText, 0, 6);
				primaryStage.setScene(this.drawAddPaymentMethodScreen(primaryStage));
				}
			}
			catch (Exception e){
				System.err.println(e);
			}
		});
			
			
		grid.add(cardNumLab, 0, 1);
		grid.add(cardNameLab, 0, 2);
		grid.add(experationLab, 0, 3);
		grid.add(securityKeyLab, 0, 4);
		grid.add(numField, 1, 1);
		grid.add(holderField, 1, 2);
		grid.add(monthList, 1, 3);
		grid.add(yearList, 2, 3);
		grid.add(securityField, 1, 4);
		grid.add(submitButton, 0, 5);
		
		Scene currentScene = new Scene(grid, 600, 600);
		return currentScene;
			
			

	}

//	public Scene drawReserveFlightScreen(Stage primaryStage, ArrayList<String[]> fargs){
//		
//		GridPane grid = new GridPane();
//		Label existingPaymentsTexts = new Label("Existing Payment Methods On Your Account");
//		Button useButton = new Button("Use");
//		
//	}
	
	public Scene drawAvailableSeatsScreen(Stage primaryStage, ArrayList<Seat> seats){
		
		GridPane grid = new GridPane();
		int x = 1;
		int y = 1;

		Label head = new Label("Available seats on your selected flight");
		grid.add(head, 0, 0);
		
		for (Seat s : seats){
			Text seatClass = new Text(s.getSeatClass());
			Text seatPrice = new Text(s.getStringSeatPrice());
			CheckBox chezchBox = new CheckBox("Seat #" + s.getStringSeatID());
			grid.add(chezchBox, 1, y);
			grid.add(seatPrice, 2, y);
			grid.add(seatClass, 3, y);
			y += 1;
		}
		
		
		Scene currentScene = new Scene(grid, 500, 500);
		return currentScene;
		
	}

	
	
	public static void main(String[] args) {
		launch(args);
	}

}
