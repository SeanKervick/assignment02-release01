package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        //Reading reading = Reading.findById(id);
        Logger.info ("Station id " + id);
        render("station.html", station );//reading
    }
    public static void addReading(Long id, int code, double temperature, int windSpeed, double windDirection, int pressure)
    {
        Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }


}
