public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private String description;

    // Constructor
    public WeatherData(String city, double temperature, double humidity, String description) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.description = description;
    }

    // Getter dan Setter
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
