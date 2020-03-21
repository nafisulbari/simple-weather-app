package com.nafisulbari.weather;


import com.google.gson.JsonObject;
import com.nafisulbari.weather.controller.Controller;
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
import java.sql.Timestamp;
import java.util.Date;

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

        //getting controller from the fxml file.
        Controller controller = loader.getController();


        //setting degree value from the Controller.setDegree(String degreeVal) method.
        controller.setDegree(weatherData.get("currently").getAsJsonObject().get("temperature").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLocation(locationData.get("city").toString().replace("\"", ""));
        controller.setWeatherType(weatherData.get("currently").getAsJsonObject().get("summary").toString().replace("\"", ""));
        controller.setRealFeel("RealFeel " + weatherData.get("currently").getAsJsonObject().get("apparentTemperature").toString().split("\\.", 2)[0].concat("\u00B0"));

        System.err.println(weatherData.get("daily").getAsJsonObject().get("icon").toString());
        System.err.println(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("temperatureHigh").toString());


        controller.setLabel1(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("time").getAsLong()));
        controller.setLabel1H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLabel1L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        controller.setLabel2(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(1).getAsJsonObject().get("time").getAsLong()));
        controller.setLabel2H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(1).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLabel2L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(1).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        controller.setLabel3(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(2).getAsJsonObject().get("time").getAsLong()));
        controller.setLabel3H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(2).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLabel3L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(2).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        controller.setLabel4(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(3).getAsJsonObject().get("time").getAsLong()));
        controller.setLabel4H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(3).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLabel4L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(3).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        controller.setLabel5(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(4).getAsJsonObject().get("time").getAsLong()));
        controller.setLabel5H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(4).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLabel5L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(4).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        controller.setLabel6(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(5).getAsJsonObject().get("time").getAsLong()));
        controller.setLabel6H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(5).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLabel6L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(5).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

        controller.setLabel7(longToDayString(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(6).getAsJsonObject().get("time").getAsLong()));
        controller.setLabel7H(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(6).getAsJsonObject().get("temperatureHigh").toString().split("\\.", 2)[0].concat("\u00B0"));
        controller.setLabel7L(weatherData.get("daily").getAsJsonObject().get("data").getAsJsonArray().get(6).getAsJsonObject().get("temperatureLow").toString().split("\\.", 2)[0].concat("\u00B0"));

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

    public String longToDayString(long l) {
        Date date = new Date(l * 1000L);
        return date.toString().substring(0, 1);
    }
}
