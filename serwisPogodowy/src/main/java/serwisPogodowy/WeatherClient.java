package serwisPogodowy;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WeatherClient {
	public static final String URL ="http://api.openweathermap.org/data/2.5/weather?q=[City]&APPID=1a5e916666e092bda3d5cc7cb07f35ea";
	
	public AbstractWeatherInformation getAbstractWeatherInformationByCityName(String name)
	{
		Response response = ClientBuilder.newClient().target(URL.replace("[City]", name)).request(MediaType.APPLICATION_JSON).get();
		if(response.getStatus()==200)
			return response.readEntity(AbstractWeatherInformation.class);
		 
		return null;
	 }

}
