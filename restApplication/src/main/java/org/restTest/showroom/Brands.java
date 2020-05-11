package org.restTest.showroom;
import java.util.List;

import org.restTest.showroom.hibernate.entities.BrandEntity;
import org.restTest.showroom.services.BrandsService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/showroom")
public class Brands {
	
	@GET
	@Path("/getBrands")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BrandEntity> getBrands() {
		List<BrandEntity> listOfBrands= new BrandsService().getBrands();
		return listOfBrands;
	}
	
	@POST
	@Path("/addBrand")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBrand(BrandEntity brand) {
		new BrandsService().addBrand(brand);
		
	}
	
	@PUT
	@Path("/brand/{brandID}")
	@Consumes(MediaType.APPLICATION_JSON)	
	public void updateBrand(@PathParam("brandID") int brandID, BrandEntity updateBrand) {
		updateBrand.setBrandID(brandID);
		new BrandsService().updateBrand(updateBrand);
	}
	
	@DELETE
	@Path("/deleteBrand/{brandID}")
	@Consumes(MediaType.TEXT_PLAIN)
	public void deleteBrand(@PathParam("brandID") int brandID) {
		new BrandsService().deleteBrand(brandID);
	}
}
