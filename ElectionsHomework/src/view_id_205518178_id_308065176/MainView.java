package view_id_205518178_id_308065176;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Vector;

import com.sun.javafx.scene.traversal.TopMostTraversalEngine;

import id_205518178_id_308065176.Party.Wing;
import id_205518178_id_308065176.PartyMember;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class MainView extends Application{
	
	private Label Caption;
	
	public MainView(Stage primaryStage, int month, int year) {
		primaryStage.setTitle(Month.of(month) + " " + year + " Election Round System");
		Caption = new Label(Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH) + " " + year + " Election Round System");
		start(primaryStage);

	}

	public void start(Stage s) {
		

		
		BorderPane bpRoot = new BorderPane();
		bpRoot.setPadding(new Insets(10));
		bpRoot.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		
		// Top BorderPane Editor
		Caption.setUnderline(true);
		Caption.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

		bpRoot.setTop(Caption);
		bpRoot.setAlignment(Caption, Pos.CENTER);
		
		// Center BorderPane Editor
		bpRoot.setCenter(new Label("Choice"));
		
		//Left Section BorderPane Editor - VBOX Type
		VBox vBox = new VBox();
		Label mainMenuLbl = createLabel("Main Menu", 12, true, FontWeight.BOLD);
		Button addVotingStationBtn = new Button("Add Voting Station");
		Button addCitizenBtn = new Button("Add Citizen");
		Button addPartyBtn = new Button("Add Party");
		Button addPartyMemberBtn = new Button("Add Candidate");
		Button showAllVotingStationsBtn = new Button("Show Voting Stations");
		Button showAllCitizensBtn = new Button("Show All Citizens");
		Button showAllPartiesBtn = new Button ("Show All Parties");
		Button voteBtn = new Button ("Start Vote");
		
		Button saveBtn = new Button("Save");
		
		
		addVotingStationBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				GridPane gProot = createGridPane();
				Label headLine = createLabel("New Voting Staion Generator", 12, true, FontWeight.EXTRA_BOLD);
				TextField AddressTf = new TextField();
				CheckBox coronCheckBox = new CheckBox("Corona Voting Station");
				CheckBox militaryCheckBox = new CheckBox("Military Voting Station");
				gProot.add(headLine, 0, 0);
				gProot.add(new Label("Enter Address:"), 0, 1);
				gProot.add(AddressTf, 1, 1);
				gProot.add(coronCheckBox, 0, 2);
				gProot.add(militaryCheckBox, 0, 3);

				
				
				
				bpRoot.setCenter(gProot);
				bpRoot.setAlignment(gProot, Pos.TOP_CENTER);
				bpRoot.setBottom(saveBtn);
				BorderPane.setAlignment(saveBtn, Pos.CENTER_RIGHT);
				
				saveBtn.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						String Address = AddressTf.getText();
						Boolean isCorona = coronCheckBox.isSelected();
						Boolean isMilitary = militaryCheckBox.isSelected();
						
						// Add Trigger to the model (By Listeners / Straight To The Controller 
						
						
					}
				});
			}
		});

		addCitizenBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				GridPane gProot = createGridPane();
				
				Label headLine = createLabel("New Citizen Generator", 12, true, FontWeight.EXTRA_BOLD);
				TextField idTf = new TextField();
				TextField nameTf = new TextField();
				TextField YearofBirthTf = new TextField();
				
				gProot.add(headLine, 0, 0);
				gProot.add(new Label("Enter Valid ID Number:"), 0, 1);
				gProot.add(idTf, 1, 1);
				gProot.add(new Label("Enter Your Name:"), 0, 2);
				gProot.add(nameTf, 1, 2);
				gProot.add(new Label("Enter Year of Birth:"), 0, 3);
				gProot.add(YearofBirthTf, 1, 3);
				
				bpRoot.setCenter(gProot);
				bpRoot.setBottom(saveBtn);
				bpRoot.setAlignment(saveBtn, Pos.CENTER_RIGHT);
				
				saveBtn.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						int Id = Integer.parseInt(idTf.getText());
						String name = nameTf.getText();
						int year = Integer.parseInt(YearofBirthTf.getText());
						
						// Add Trigger to the model (By Listeners / Straight To The Controller 
						
						
					}
				});
			}
		});
			
		addPartyBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				GridPane gProot = createGridPane();
				
				Label headLine = createLabel("New Party Generator", 12, true, FontWeight.EXTRA_BOLD);
				TextField partyNameTf = new TextField();
				DatePicker dateCreated = new DatePicker();
				ComboBox<Wing> cmbWings = new ComboBox<Wing>();
				cmbWings.getItems().addAll(Wing.Left, Wing.Center, Wing.Right);
				gProot.add(headLine, 0, 0);
				gProot.add(new Label("Enter New Party Name:"), 0, 1);
				gProot.add(partyNameTf, 1, 1);
				gProot.add(new Label("Date Created:"), 0, 2);
				gProot.add(dateCreated, 1, 2);
				gProot.add(new Label("Pick The Party Wing:"), 0, 3);
				gProot.add(cmbWings, 1, 3);
				
				bpRoot.setCenter(gProot);
				bpRoot.setBottom(saveBtn);
				bpRoot.setAlignment(saveBtn, Pos.CENTER_RIGHT);
				
				saveBtn.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						String partyName = partyNameTf.getText();
						LocalDate date = dateCreated.getValue();
						Wing partyWing = cmbWings.getValue();
						
						// Add Trigger to the model (By Listeners / Straight To The Controller 
						
						
					}
				});
			}
			
			
		});
		
		addPartyMemberBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				GridPane gProot = createGridPane();
				
				Label headLine = createLabel("New Party Member Generator", 12, true, FontWeight.EXTRA_BOLD);
				TextField idTf = new TextField();
				TextField nameTf = new TextField();
				TextField YearofBirthTf = new TextField();
				
				gProot.add(headLine, 0, 0);
				gProot.add(new Label("Enter Valid ID Number:"), 0, 1);
				gProot.add(idTf, 1, 1);
				gProot.add(new Label("Enter Your Name:"), 0, 2);
				gProot.add(nameTf, 1, 2);
				gProot.add(new Label("Enter Year of Birth:"), 0, 3);
				gProot.add(YearofBirthTf, 1, 3);
				
				bpRoot.setCenter(gProot);
				bpRoot.setBottom(saveBtn);
				bpRoot.setAlignment(saveBtn, Pos.CENTER_RIGHT);
				
				saveBtn.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						int Id = Integer.parseInt(idTf.getText());
						String name = nameTf.getText();
						int year = Integer.parseInt(YearofBirthTf.getText());
						
						
						// Add Trigger to the model (By Listeners / Straight To The Controller 
						
						
					}
				});
			}
		});

		showAllVotingStationsBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				
			}
		});
		
		showAllCitizensBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				
			}
		});

		showAllPartiesBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				
			}
		});
		
		voteBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		
//		Label mainMenuLbl = createLabel("Main Menu", 12, true, FontWeight.BOLD);
//		Label addVotingStatLbl = createLabel("Add Voting Station", 12, true, FontWeight.SEMI_BOLD); 
//		Label addCitizenLbl = createLabel("Add Citizen", 12, true, FontWeight.SEMI_BOLD);
//		Label addPartyLbl = createLabel("Add Party", 12, true, FontWeight.SEMI_BOLD);
//		Label addPartyMemLbl = createLabel("Add party candidate", 12, true, FontWeight.SEMI_BOLD);
//		Label showAllVotStatLbl = createLabel("Show all voting stations", 12, true, FontWeight.SEMI_BOLD);
//		Label showAllCitizenLbl = createLabel("Show all citizens", 12, true, FontWeight.SEMI_BOLD);
//		Label showAllPartiesLbl = createLabel("Show all parties", 12, true, FontWeight.SEMI_BOLD);
//		Label voteLbl = createLabel("Vote", 12, true, FontWeight.SEMI_BOLD);
//		Label showResultsLbl = createLabel("Show Results", 12, true, FontWeight.SEMI_BOLD);
//		Label exitLbl = createLabel("Exit", 12, true, FontWeight.SEMI_BOLD);
		vBox.setPrefWidth(200);
		vBox.setSpacing(10);
		vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		//vBox.getChildren().addAll(mainMenuBtn,addVotingStationBtn,addCitizenLbl,addPartyLbl,addPartyMemLbl,showAllVotStatLbl,showAllCitizenLbl,showAllPartiesLbl,voteLbl,showResultsLbl,exitLbl);
		vBox.getChildren().addAll(mainMenuLbl,addVotingStationBtn,addCitizenBtn,addPartyBtn,addPartyMemberBtn,showAllVotingStationsBtn,showAllCitizensBtn,showAllPartiesBtn,voteBtn);
		bpRoot.setLeft(vBox);

		
		// Scene Initial
		s.setScene(new Scene(bpRoot, 700, 460));
		s.show();
	}
	
	private Label createLabel(String text, double size, boolean underline, FontWeight fontWeight) {
		Label theLabel = new Label(text);
		theLabel.setFont(Font.font("Verdana", fontWeight, size));
		theLabel.setUnderline(underline);
		return theLabel;
		
	}
	
	private	GridPane createGridPane() {
		GridPane gProot = new GridPane();
		gProot.setPadding(new Insets(10));
		gProot.setAlignment(Pos.CENTER);
		gProot.setHgap(10);
		gProot.setVgap(10);
		
		return gProot;
		
	}



}
