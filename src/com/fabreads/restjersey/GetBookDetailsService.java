package com.fabreads.restjersey;

/**
 * @author Prajna
 */
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.fabreads.dao.BookDetailsDAO;
import com.fabreads.javabeans.Book;
import com.google.gson.Gson;
 
@Path("/getbookdetails")
public class GetBookDetailsService {
 
	  @Path("{id}")
	  @GET
	  @Produces("application/json")
	  public Response getBookDetails(@PathParam("id") String id) throws JSONException {
 
		BookDetailsDAO bookDetailsDAO = new BookDetailsDAO();
		int bookid = Integer.parseInt(id);
		Book book = bookDetailsDAO.getBookDetails(bookid);
		
		Gson gson = new Gson();
		String json = gson.toJson(book);
		 
		String result = "Output: \n\nBook Details : \n\n" + json;
		return Response.status(200).entity(result).build();
	  }
 
}
