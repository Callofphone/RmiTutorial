import java.io.Serializable;

/**
 * Created by jamiel on 7-9-2017.
 */
public class Weather implements Serializable {
    private String city;
    private String temperature;
    private String current;
    private String humidity;

    public Weather() { }

    public Weather(String city, String temperature, String current, String humidity) {
        this.city = city;
        this.temperature = temperature;
        this.current = current;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String toString() {
        return "City: " + city +
                ", Temp: " + temperature +
                ", Current: " + current
                + ", Humidity: " + humidity + " ";
    }
}
