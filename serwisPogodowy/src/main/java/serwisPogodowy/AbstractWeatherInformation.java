package serwisPogodowy;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AbstractWeatherInformation extends AbstractWeatherResponse {
    private MainParameters main;
    private Wind wind;
    private Clouds clouds;
    private SystemParameters sys;
    private Coord coord;
    private String base;
    private double visibility;
    private int id;
    private String name;
    private int cod;
    
    
	public MainParameters getMain() {
		return main;
	}
	public void setMain(MainParameters main) {
		this.main = main;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public Clouds getClouds() {
		return clouds;
	}
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	public SystemParameters getSys() {
		return sys;
	}
	public void setSys(SystemParameters sys) {
		this.sys = sys;
	}
	public Coord getCoord() {
		return coord;
	}
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public double getVisibility() {
		return visibility;
	}
	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
}