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
import java.sql.Timestamp;
import java.util.Date;

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
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("/app.fxml"));

        WeatherService weatherService = WeatherService.getInstance();
        JsonObject weatherData = weatherService.getWeatherData();
        JsonObject locationData = weatherService.getLocationData();


        AnchorPane anchorPane = loader.load();

        //getting controller from the fxml file.
        Controller controller = loader.getController();


        //setting degree value from the Controller.setDegree(String degreeVal) method.
        controller.setDegree(weatherData.get("currently").getAsJsonObject().get("temperature").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLocation(locationData.get("city").toString().replace("\"", ""));
        controller.setWeatherType(weatherData.get("currently").getAsJsonObject().get("summary").toString().replace("\"", ""));
        controller.setRealFeel("RealFeel " + weatherData.get("currently").getAsJsonObject().get("apparentTemperature").toString().split("\\.", 2)[0].concat("\u00B0"));

        System.err.println(weatherData.get("daily").getAsJsonObject().get("icon").toString());
        System.err.println(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("temperatureHigh").toString());





        long l = weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("time").getAsLong();
        Date date = new Date(l*1000L);
        System.out.println(date.toString().substring(0,1));


        Scene scene = new Scene(anchorPane, 250, 150);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }
}
