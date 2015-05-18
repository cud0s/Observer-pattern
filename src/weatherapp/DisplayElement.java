/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author slvai_000
 */
class DisplayElement implements Observer {

    private final DisplayFrame frame;

    @Override
    public void update(Observable o, Object o1) {
        System.out.println("one");
        if (o instanceof WeatherStation) {
            WeatherStation station = (WeatherStation)o;
            System.out.println(station.getTemp());
            String temp = Double.toString(station.getTemp());
            String percip = station.getDescription();
            String country = station.getCountry();
            String description = station.getDescription();
            String city = station.getCity();
            
            frame.jTextField1.setText(temp);
            frame.jTextField2.setText(country);
            frame.jTextField3.setText(description);
            frame.jTextField4.setText(city);
           
        }
    }

    DisplayElement() {
        frame = new DisplayFrame();
        frame.setVisible(true);
    }
}
