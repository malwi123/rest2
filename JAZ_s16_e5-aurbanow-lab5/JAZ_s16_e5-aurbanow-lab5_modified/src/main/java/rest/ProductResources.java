package rest;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Comment;
import domain.Product;


@Path("/product")
@Stateless
public class ProductResources {

	@PersistenceContext(unitName = "demoPU")
	EntityManager em;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAll() {
		return em.createNamedQuery("product.all", Product.class).getResultList();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Add(Product product) {
		em.persist(product);
		return Response.ok(product.getId()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		Product result = em.createNamedQuery("product.id", Product.class).setParameter("productId", id).getSingleResult();

		if (result == null) {
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByName(@PathParam("name") String name) {
		Product result = em.createNamedQuery("product.name", Product.class).setParameter("productName", name).getSingleResult();

		if (result == null) {

			return Response.ok(name).build();
		}
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/category/{category}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByCategory(@PathParam("category") String category) {

		Product result = em.createNamedQuery("product.category", Product.class).setParameter("productCategory", category).getSingleResult();

		if (result == null) {
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/price/{from}/{to}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByPrice(@PathParam("from") int from, @PathParam("to") int to) {

		Product result = em.createNamedQuery("product.price", Product.class).setParameter("from", from).setParameter("to", from).getSingleResult();

		if (result == null) {
			return Response.status(404).build();
		}
		return Response.ok(result).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Product p) {
		Product result = em.createNamedQuery("product.id", Product.class).setParameter("productId", id).getSingleResult();

		if (result == null) {
			return Response.status(404).build();
		}

		result.setName(p.getName());
		result.setCategory(p.getCategory());

		em.persist(result);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) throws Exception {

		Product result = em.createNamedQuery("product.id", Product.class).setParameter("productId", id)
				.getSingleResult();

		if (result == null) {
			return Response.status(404).build();
		}

		em.remove(result);

		return Response.ok().build();
	}

	@GET
	@Path("/{productId}/comment")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getCars(@PathParam("productId") int productId) {
		Product result = em.createNamedQuery("product.id", Product.class).setParameter("productId", productId)
				.getSingleResult();

		if (result == null)
			return null;

		return result.getComments();
	}

	@POST
	@Path("/{id}/comment")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCar(@PathParam("id") int productId, Comment comment) {
		Product result = em.createNamedQuery("product.id", Product.class).setParameter("productId", productId)
				.getSingleResult();

		if (result == null) {
			return Response.status(404).build();
		}

		result.getComments().add(comment);
		comment.setProduct(result);
		em.persist(comment);

		return Response.ok().build();
	}

}
