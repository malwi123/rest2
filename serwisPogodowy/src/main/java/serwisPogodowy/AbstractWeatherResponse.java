package serwisPogodowy;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AbstractWeatherResponse {
    private Date dt;
    private List<Weather> weather;
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
}
