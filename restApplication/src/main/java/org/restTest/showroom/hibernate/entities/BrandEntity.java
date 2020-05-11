package org.restTest.showroom.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "brands")
@Table(name = "brands")
public class BrandEntity {
	
	@Id
	@Column(name = "brandid")
	private int brandID;
	
	@Column(name = "brandname")
	private String brandname;
	
	public int getBrandID() {
		return brandID;
	}
	
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	
	public String getBrandname() {
		return brandname;
	}
	
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	
	public BrandEntity(int brandID, String brandname) {
		this.brandID = brandID;
		this.brandname = brandname;
	}
	
	public BrandEntity() {
	
	}
	
}
