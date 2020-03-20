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


    public AnchorPane anchorPane;
    public Label location;
    public Label degree;
    public Label weatherType;
    public Label realFeel;

    public Label label1;
    public Label label1H;
    public Label label1L;

    public Label label2;
    public Label label2H;
    public Label label2L;

    public Label label3;
    public Label label3H;
    public Label label3L;

    public Label label4;
    public Label label4H;
    public Label label4L;

    public Label label5;
    public Label label5H;
    public Label label5L;

    public Label label6;
    public Label label6H;
    public Label label6L;

    public Label label7;
    public Label label7H;
    public Label label7L;


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

    public void setWeatherType(String weatherTypeVal){
        this.weatherType.setText(weatherTypeVal);
    }

    public void setRealFeel(String realFeelVal){
        realFeel.setText(realFeelVal);
    }

    public void setLabel1(String label1) {
        this.label1.setText(label1);
    }

    public void setLabel1H(String label1H) {
        this.label1H.setText(label1H);
    }

    public void setLabel1L(String label1L) {
        this.label1L.setText(label1L);
    }

    public void setLabel2(String label2) {
        this.label2.setText(label2);
    }

    public void setLabel2H(String label2H) {
        this.label2H.setText(label2H);
    }

    public void setLabel2L(String label2L) {
        this.label2L.setText(label2L);
    }

    public void setLabel3(String label3) {
        this.label3.setText(label3);
    }

    public void setLabel3H(String label3H) {
        this.label3H.setText(label3H);
    }

    public void setLabel3L(String label3L) {
        this.label3L.setText(label3L);
    }

    public void setLabel4(String label4) {
        this.label4.setText(label4);
    }

    public void setLabel4H(String label4H) {
        this.label4H.setText(label4H);
    }

    public void setLabel4L(String label4L) {
        this.label4L.setText(label4L);
    }

    public void setLabel5(String label5) {
        this.label5.setText(label5);
    }

    public void setLabel5H(String label5H) {
        this.label5H.setText(label5H);
    }

    public void setLabel5L(String label5L) {
        this.label5L.setText(label5L);
    }

    public void setLabel6(String label6) {
        this.label6.setText(label6);
    }

    public void setLabel6H(String label6H) {
        this.label6H.setText(label6H);
    }

    public void setLabel6L(String label6L) {
        this.label6L.setText(label6L);
    }

    public void setLabel7(String label7) {
        this.label7.setText(label7);
    }

    public void setLabel7H(String label7H) {
        this.label7H.setText(label7H);
    }

    public void setLabel7L(String label7L) {
        this.label7L.setText(label7L);
    }


//-------------------------End of Get & Set methods-------------------------------------------------------------







    //-------------------------Controller Methods-------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------

    public void degreeOnClicked(MouseEvent mouseEvent) {
        degree.setText(weatherService.getWeatherData().get("currently").getAsJsonObject().get("temperature").toString());
    }






    //------------------------End of Controller Methods--------------------------------------------------------------

}
