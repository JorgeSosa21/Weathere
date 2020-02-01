package jorge.vargas.weathere.model;

public class Weather {
    private long temp;
    private long feelLike;
    private long tempMin;
    private long tempMax;
    private long pressure;
    private int humidity;
    private float windSpeed;
    private String description;

    public Weather(){

    }

    public long getTemp() {
        return temp;
    }

    public void setTemp(long temp) {
        this.temp = temp;
    }

    public long getFeelLike() {
        return feelLike;
    }

    public void setFeelLike(long feelLike) {
        this.feelLike = feelLike;
    }

    public long getTempMin() {
        return tempMin;
    }

    public void setTempMin(long tempMin) {
        this.tempMin = tempMin;
    }

    public long getTempMax() {
        return tempMax;
    }

    public void setTempMax(long tempMax) {
        this.tempMax = tempMax;
    }

    public long getPressure() {
        return pressure;
    }

    public void setPressure(long pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getDescription() {
        return description.substring(0,1).toUpperCase() + description.substring(1);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
