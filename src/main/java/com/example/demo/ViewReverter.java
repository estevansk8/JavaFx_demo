package com.example.demo;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewReverter extends Application implements EventHandler {

    private Label labelInput;
    private Label labelresult;
    private Label labelOutput;
    private TextField txtInput;
    private Button buttonReverse;

    @Override
    public void start(Stage stage) throws IOException {
        labelInput = new Label("Input: ");
        labelresult = new Label("Reversed: ");
        labelOutput = new Label();
        txtInput = new TextField();
        txtInput.setPromptText("Enter what you want: ");
        buttonReverse = new Button("Reverse");
        buttonReverse.setOnAction(this);

        HBox layout = new HBox();
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setPadding(new Insets(5,10,5,10));
        layout.setSpacing(10);
        layout.getChildren().addAll(labelInput,txtInput,buttonReverse,labelresult,labelOutput);

        Scene scene = new Scene(layout, 320, 240);
        stage.setTitle("String Reverter!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(Event event) {
        if (event.getSource() == buttonReverse){
            StringBuilder reverter = new StringBuilder(txtInput.getText());
            labelresult.setText("Result: " + reverter.reverse());
        }
    }
}