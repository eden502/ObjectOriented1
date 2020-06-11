package view_id_205518178_id_308065176;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import com.sun.javafx.scene.traversal.TopMostTraversalEngine;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
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
		Button mainMenuBtn = new Button("Main Menu");
		Button addVotingStationBtn = new Button("Add Voting Station");
		Button addCitizenBtn = new Button("Add Citizen");
		Button addPartyBtn = new Button("Add Party");
		Button addPartyMemberBtn = new Button("Add Candidate");
		Button showAllVotingStationsBtn = new Button("Show Voting Stations");
		Button showAllCitizensBtn = new Button("Show All Citizens");
		Button showAllPartiesBtn = new Button ("Show All Parties");
		Button voteBtn = new Button ("Start Vote");
		
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
		vBox.getChildren().addAll(mainMenuBtn,addVotingStationBtn,addCitizenBtn,addPartyBtn,addPartyMemberBtn,showAllVotingStationsBtn,showAllCitizensBtn,showAllPartiesBtn,voteBtn);
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



}
