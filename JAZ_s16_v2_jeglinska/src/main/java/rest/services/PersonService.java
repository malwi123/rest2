package rest.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import rest.dto.PersonDto;

@Path("people")
@Stateless
public class PersonService {

	@PersistenceContext(unitName = "demoPU")
	EntityManager em;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(PersonDto dto){
		em.persist(dto);
		return Response.status(201).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response delete(@PathParam("id") int id)
	{
		PersonDto p = em.find(PersonDto.class, id);

		em.remove(p);

	    return Response.noContent().build();
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, 
			PersonDto person) {

		PersonDto updatePerson = em.find(PersonDto.class, id);
	    if (person == null) {
	        throw new WebApplicationException(404);
	    }

	    updatePerson.setBirthday(person.getBirthday());
	    updatePerson.setFirstName(person.getFirstName());
	    updatePerson.setLastName(person.getLastName());
	    updatePerson.setGender(person.getGender());
	    updatePerson.setAge(person.getAge());
	    updatePerson.setEmail(person.getEmail());

	    return Response.noContent().build();
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonDto> getAll(@PathParam("id") int id){
		List<PersonDto> list = new ArrayList<PersonDto>();
		
		List<PersonDto> listPersons = em.createQuery("SELECT p FROM PersonDto p").getResultList();
		
		id--;
		for(int i = id*3; i<Math.min(id*3 + 3, listPersons.size()) ; i++ )
		{
			list.add(listPersons.get(i));
		}
		
		return list;
	}
}
