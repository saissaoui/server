package tn.tunisiana.customer.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import tn.tunisiana.customer.model.Customer;
import tn.tunisiana.customer.model.Offer;

@Consumes("application/json")
@Produces("application/json")

@Path("/offer")
public interface IOfferManagerService  {
	
	@POST
	@Path("/getAll")
	public List<Offer> getOffersFor(Customer customer);

	@GET
	@Path("/get/{operator}")
	public List<Offer> getOffersByOperator(@PathParam("operator")String operator);
}
