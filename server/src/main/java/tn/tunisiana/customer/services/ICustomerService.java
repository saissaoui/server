package tn.tunisiana.customer.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import tn.tunisiana.customer.model.Customer;
@Path("/customer")
@Produces("application/json")
@Consumes("application/json")
public interface ICustomerService {

	@GET
	@Path("/getAll")
	List<Customer> getAll();
	
	@POST
	@Path("/add/{offerId}")
	int addCustomer(Customer customer,@PathParam("offerId") int offerId);
	void updateCustomer(Customer customer);
	void deleteCustomer(int customerId);
}
