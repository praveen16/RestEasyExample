package org.jboss.example.jaxrs2.async;

import org.jboss.example.filters.OutBoundServletFilter;
import org.jboss.logging.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@Path("/customers")
public class CustomerResource
{
//   private static final Logger logger = LoggerFactory.getLogger(OutBoundServletFilter.class);
   private static final Logger logger = Logger.getLogger(CustomerResource.class);
   @GET
   @Produces("application/json")
   public Customer getByName(@QueryParam("name") String name)
   {
      logger.info("executing endpoint /customers?name="+name);
      return new Customer(name);
   }

   @GET
   @Path("exception")
   @Produces("application/json")
   public Response throwException()
   {
      logger.info("executing endpoint /customers/exception");
      // String buffer throws an unchecked arrayoutofbounds exception. lets do that
      StringBuffer sb = new StringBuffer();
      sb.insert(-1, "character");
      return Response.noContent().build();
   }

   @GET
   @Path("{id}")
   @Produces("application/json")
   public Customer getById(@PathParam("id") String id)
   {
      return new Customer("Bill");
   }

}
