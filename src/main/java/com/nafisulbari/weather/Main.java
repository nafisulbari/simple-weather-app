package com.nafisulbari.weather;


import com.nafisulbari.weather.controller.Controller;
import com.nafisulbari.weather.service.WeatherService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * A simple weather app
 *
 * @author Ahmed Nafisul Bari
 */

public class Main extends Application {
    public static void main(String[] args) throws IOException {

        launch(args);

//        WeatherService weatherService = new WeatherService();
//
//        System.out.println(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());
//
//        System.err.println(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());
//
//        System.out.println(weatherService.getWeatherData().get("hourly").getAsJsonObject().get("data").getAsJsonArray());


    }



    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));

        WeatherService weatherService = new WeatherService();



        GridPane gridPane =loader.load();

        //getting controller from the fxml file.
        Controller controller =loader.getController();


        //setting degree value from the Controller.setDegree(String degreeVal) method.
        controller.setDegree(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());

        Scene scene =  new Scene(gridPane,300,275);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }
}
