package com.jdbc.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Brand;

public class JDBCOperationsDAO {
	
	
	public List<Brand> getBrands(Connection con) {
		List<Brand> brand = new ArrayList<Brand>();
		try {
			Statement st = con.createStatement();
			String sql = "select * from brands";
			ResultSet rs = st.executeQuery(sql);

			
			while (rs.next()) {
				Brand b = new Brand();
				b.setBrandID(rs.getInt(1));
				b.setBrandname(rs.getString(2));
				brand.add(b);
			}
			return brand;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return brand;
	}
	

	public Brand getBrandByID(Connection con, int id) {
		try {
			PreparedStatement prepst = con.prepareStatement("select * from brands where brandid = ?");
			prepst.setInt(1, id);
			ResultSet rs = prepst.executeQuery();
			while (rs.next()) {
				Brand b = new Brand();
				b.setBrandID(rs.getInt(1));
				b.setBrandname(rs.getString(2));
				return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}


	public String insertBrand(Connection con, String brandname) {
		int status = 0;
		try {
			CallableStatement cs = con.prepareCall("{call insertBrand(?)}");
			cs.setString(1, brandname);
			status = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(status == 1) {
			return "Successfully Inserted";
		} else {
			return "Failed to Insert";
		}
	}
}
