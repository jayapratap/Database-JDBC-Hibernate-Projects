package org.restTest.showroom.services;

import java.util.List;


import org.restTest.showroom.DAO.BrandsDAO;
import org.restTest.showroom.hibernate.entities.BrandEntity;

public class BrandsService {

	public List<BrandEntity> getBrands() {
		List<BrandEntity> list = new BrandsDAO().getBrands();
		return list;
	}

	public void addBrand(BrandEntity brand) {
		new BrandsDAO().addBrand(brand);		
	}

	public void deleteBrand(int brandID) {
		new BrandsDAO().deleteBrand(brandID);
		
	}

	public void updateBrand(BrandEntity updateBrand) {
		new BrandsDAO().updateBrand(updateBrand);
		
	}

}
