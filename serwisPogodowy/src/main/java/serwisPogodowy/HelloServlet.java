package serwisPogodowy;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pogoda")
public class HelloServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String city = request.getParameter("city");
		
		WeatherClient client = new WeatherClient();
		AbstractWeatherInformation wi;
		wi = client.getAbstractWeatherInformationByCityName(city);

		response.getWriter().println(printWeather(wi));
	}
	
	private String printWeather(AbstractWeatherInformation wi)
	{
		String pogoda = "Pogoda dla " + wi.getName() + "\n" +
		"Opis ogolny: " + wi.getWeather().get(0).getDescription() + "\n" +
		"Poziom zachmurzenia " + wi.getClouds().getAll() + "\n" +
		"Temperatura " + wi.getMain().getTemp() + "\n" +
		"Cisnienie " + wi.getMain().getPressure() + "\n" +
		"Predkosc wiatru " + wi.getWind().getSpeed() + "\n" +
		"==================================\n";
		
		return pogoda;
	}

}
