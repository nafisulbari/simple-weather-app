package com.nafisulbari.weather;


import com.nafisulbari.weather.controller.Controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;



/**
 * A simple weather widget
 *
 * @author Ahmed Nafisul Bari
 */

public class Main extends Application {

    //offsets for dragging
    private double xOffset = 0;
    private double yOffset = 0;


    public static void main(String[] args) throws IOException {

        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app.fxml"));

        AnchorPane anchorPane = loader.load();

        Scene scene = new Scene(anchorPane, 250, 150);

        primaryStage.initStyle(StageStyle.UNDECORATED);

        //Selecting the pane for dragging----------------------------
        anchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        //To move the pane on drag-----------------------------------
        anchorPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        Controller controller = loader.getController();
        controller.updateWeather();
        controller.startTimer();

        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
