package com.nafisulbari.weather.controller;

import com.nafisulbari.weather.service.WeatherService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public Label location;

    public AnchorPane anchorPane;

    public Label degree;


    WeatherService weatherService = WeatherService.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    //-----------------------Get & Set methods for Controller injection--------------------------------------------
    //-------------------------------------------------------------------------------------------------------------

    public void setDegree(String degreeVal) {
        this.degree.setText(degreeVal);
    }

    public void setLocation(String locationVal) {
        this.location.setText(locationVal);
    }





    //-------------------------End of Get & Set methods-------------------------------------------------------------







    //-------------------------Controller Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    public void degreeOnClicked(MouseEvent mouseEvent) {
        degree.setText(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());
    }






    //------------------------End of Controller Methods--------------------------------------------------------------

}
