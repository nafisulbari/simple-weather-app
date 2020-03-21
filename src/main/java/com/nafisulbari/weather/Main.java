package com.nafisulbari.weather;


import com.google.gson.JsonObject;
import com.nafisulbari.weather.service.WeatherService;
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
 * A simple weather app
 *
 * @author Ahmed Nafisul Bari
 */

public class Main extends Application {

    //offsets for dragging
    private double xOffset = 0;
    private double yOffset = 0;


    public static void main(String[] args) throws IOException {


        launch(args);


//        WeatherService weatherService = WeatherService.getInstance();
//        System.out.println(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());
//
//        System.err.println(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());
//
//        System.out.println(weatherService.getWeatherData().get("hourly").getAsJsonObject().get("data").getAsJsonArray());


    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/app.fxml"));

        WeatherService weatherService = WeatherService.getInstance();
        JsonObject weatherData = weatherService.getWeatherData();
        JsonObject locationData = weatherService.getLocationData();


        AnchorPane anchorPane = loader.load();


        Scene scene = new Scene(anchorPane, 250, 150);
        primaryStage.initStyle(StageStyle.UNDECORATED);


        //grab your root here
        anchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        //move around here
        anchorPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });



        primaryStage.setScene(scene);
        primaryStage.show();




    }


}
