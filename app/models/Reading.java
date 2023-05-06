package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Reading extends Model
{
    public int code;
    public double temperature;
    public int windSpeed;
    public int pressure;
    public double windDirection;


    public Reading(int code, double temperature, int windSpeed, double windDirection, int pressure)
    {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }

    //getters
    public int getCode(){
        return code;
    }
    public double getTemp(){
        return temperature;
    }
    public int getWindSpeed(){ return windSpeed;}
    public int getPressure(){ return pressure;}
    public double getWindDirection(){ return windDirection;}


}
