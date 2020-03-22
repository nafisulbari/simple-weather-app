package com.nafisulbari.weather;


import com.nafisulbari.weather.controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


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


        AnchorPane anchorPane = loader.load();

        Scene scene = new Scene(anchorPane, 250, 150);

        primaryStage.initStyle(StageStyle.UNDECORATED);

        //Selecting the pane
        anchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        //To move the pane on drag
        anchorPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        Controller controller = loader.getController();
        controller.updateWeather();


        //----Using timer to update weather data----
        int MINUTES = 1;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                timeCount++;
                Platform.runLater(() -> controller.setTimer("Updated " + timeCount + " minutes ago"));
                System.out.println(timeCount);

                if (timeCount == 15) {
                    Platform.runLater(controller::updateWeather);
                    timeCount = 0;
                }

            }
        }, 0, 1000 * 60 * MINUTES);
        //-------------------------------------------


        primaryStage.setScene(scene);
        primaryStage.show();


    }

    static int timeCount = 0;

}
