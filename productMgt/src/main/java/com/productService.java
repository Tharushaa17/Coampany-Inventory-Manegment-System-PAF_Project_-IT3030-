package com;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.productCtrl;

@Path("/Products")

public class productService {

	productCtrl pcObj = new productCtrl();
	
	//Read operation

		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		
		public String readCategories()
		{
			
			return pcObj.readProduct(); 
			
		}
		
	//Insert operation

		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String insertProduct(@FormParam("id") String id, @FormParam("name") String name,@FormParam("price")String price, 
									@FormParam("desc") String desc)
		{
			String output = pcObj.insertProduct(id, name, price, desc);
			return output;
		}
	//Update operation
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)

		public String updateCategories(String productData)
		{
			//convert the input string to a JSON object
			JsonObject pobject = new JsonParser().parse(productData).getAsJsonObject();
			
			//Read the values from the JSON object
			
			String ID = pobject.get("id").getAsString();
			String name = pobject.get("name").getAsString();
			String price = pobject.get("price").getAsString();
			String desc = pobject.get("desc").getAsString();
			
			String output = pcObj.updateProduct(name, price, desc, ID);
			
			return output;
		}
		
	//Delete operation
		
		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		
		public String deleteCategories(String productData) {
			
			//Convert input string to an XML Document
			Document doc = Jsoup.parse(productData,"",Parser.xmlParser());
			//Read the value from the element <ID>
			String ID = doc.select("id").text();
			
			String output = pcObj.deleteProduct(ID);
			
			return output;
			
			
		} 
		
		
}
