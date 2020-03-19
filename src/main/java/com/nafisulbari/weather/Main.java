package com.nafisulbari.weather;


import com.google.gson.JsonObject;
import com.nafisulbari.weather.controller.Controller;
import com.nafisulbari.weather.service.WeatherService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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


//        WeatherService weatherService = WeatherService.getInstance();
//        System.out.println(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());
//
//        System.err.println(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());
//
//        System.out.println(weatherService.getWeatherData().get("hourly").getAsJsonObject().get("data").getAsJsonArray());



    }



    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/app.fxml"));

        WeatherService weatherService =WeatherService.getInstance();
        JsonObject weatherData =weatherService.getWeatherData();
        JsonObject locationData = weatherService.getLocationData();


        AnchorPane anchorPane =loader.load();

        //getting controller from the fxml file.
        Controller controller =loader.getController();


        //setting degree value from the Controller.setDegree(String degreeVal) method.
        controller.setDegree(weatherData.get("currently").getAsJsonObject().get("temperature").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLocation(locationData.get("city").toString().replace("\"",""));

        Scene scene =  new Scene(anchorPane,250,150);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }
}
