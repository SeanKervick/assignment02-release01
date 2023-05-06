package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import models.Station;

import java.util.ArrayList;
import java.util.List;


public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Admin");

    List<Station> stations = Station.findAll();
    render ("dashboard.html", stations);

  }

  public static void addStation (String title)
  {
    Station station = new Station (title);
    Logger.info ("Adding a new playlist called " + title);
    station.save();
    redirect ("/dashboard");
  }
}
