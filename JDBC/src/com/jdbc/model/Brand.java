package com.jdbc.model;

public class Brand {

	private int brandID;

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

	public Brand(int brandID, String brandname) {
		this.brandID = brandID;
		this.brandname = brandname;
	}

	public Brand() {

	}

	@Override
	public String toString() {
		return "Brand [brandID=" + brandID + ", brandname=" + brandname + "]";
	}
}
