package rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("service")
public class TestRestService {

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String test(){
		return "REST Service is running";
	}
	
	@POST
	@Path("/test")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response test(BasicDto dto){
		System.out.print(dto.getMessege());
		
		return Response.status(201).build();
	}
}


