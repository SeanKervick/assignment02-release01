package models;
import utilities.Calculations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;


@Entity
public class Station extends Model
{
    public String name;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String name)
    {
        this.name = name;
    }

    public Reading getReading(){
        return readings.get(readings.size()-1);
    }
    //Weather code methods
    public int recentCode(){return getReading().getCode();}
    public String weather(){
        return Calculations.codeToString(recentCode());
    }
    //Temperature methods
    public double recentTempC(){
        return getReading().getTemp();
    }
    public double recentTempF(){
        return Calculations.convertToFahrenheit(recentTempC());
    }
    //WindSpeed methods
    public int recentWind(){
        return getReading().getWindSpeed();
    }
    public int beaufort(){
        return Calculations.beaufort(recentWind());
    }
    //Pressure method
    public int recentPressure(){
        return getReading().getPressure();
    }
    //WindDirection Methods
    public double recentWindDirection(){
        return getReading().getWindDirection();
    }
    public String direction(){
        return Calculations.direction(recentWindDirection());
    }
    public double windChill(){
        return Calculations.convertToWindChill(recentTempC(), recentWind());
    }

}
