/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author slvai_000
 */
public class WeatherApp {

    /**
     * @param args the command line arguments
     */
    public static ExecutorService executor = Executors.newFixedThreadPool(1);
    public static void main(String[] args) {
        String city = "Kaunas";
        String country = "lt";
        WeatherStation station = new WeatherStation(city, country);        
        DisplayElement display = new DisplayElement();
        station.addObserver(display);
        
        executor.execute(station);
    }
    
}
