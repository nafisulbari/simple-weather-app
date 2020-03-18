package com.nafisulbari.weather.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherService {


    public JsonObject getWeatherData(){

        JsonObject jobj= new JsonObject();
        try {

            URL url = new URL("https://api.darksky.net/forecast/d257f7195d5a5ac353a59304d20032db/"+getLatLong());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            String output = br.readLine();
            System.out.println(output);

            String json = output;
            jobj = new Gson().fromJson(json, JsonObject.class);

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

        return jobj;
    }

    public String getLatLong(){

        JsonObject jobj= new JsonObject();
        try {

            URL url_name = new URL("http://bot.whatismyipaddress.com");

            BufferedReader sc =
                    new BufferedReader(new InputStreamReader(url_name.openStream()));

            // reads system IPAddress
            String systemipaddress = sc.readLine().trim();


            URL url = new URL("http://ip-api.com/json/"+systemipaddress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            output = br.readLine();
            System.out.println(output);

            String json = output;
            jobj = new Gson().fromJson(json, JsonObject.class);


            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        System.out.println("LOC: "+jobj.get("lat")+","+jobj.get("lon"));
        return jobj.get("lat")+","+jobj.get("lon");
    }
}
