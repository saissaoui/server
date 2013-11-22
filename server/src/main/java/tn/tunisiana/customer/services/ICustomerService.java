package tn.tunisiana.customer.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import tn.tunisiana.customer.model.Customer;
@Path("/customer")
@Produces("application/json")
public interface ICustomerService {

	@GET
	@Path("/getAll")
	List<Customer> getAll();

}
