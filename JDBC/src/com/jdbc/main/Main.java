package com.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;

import com.jdbc.DAO.JDBCOperationsDAO;
import com.jdbc.model.Brand;

public class Main {

	public static void main(String[] args) {
		
		JDBCOperationsDAO jdbcOps = new JDBCOperationsDAO();
		
		Connection con = null;
		System.out.println("running jdbc app");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/showroom", "root", "Avgap@914");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//***Getting all the brands in the DB***
		List<Brand> brands = jdbcOps.getBrands(con);
		for (Brand brand : brands) {
			System.out.println(brand.toString()+"\\n");
		}
		System.out.println("------------------------------");
		
		
		//***Geting brand by brandID***
		System.out.println("Please enter the brand ID: ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		Brand brand = jdbcOps.getBrandByID(con, id);
		System.out.println(brand.toString()+"\n");
		System.out.println("------------------------------");
		
		
		//***Inserting a new brand***
		//brandID is autoincremented in the database
		System.out.print("Please enter the brand name to insert into DB");
		sc.nextLine();
		String brandname=sc.nextLine();
		String status = jdbcOps.insertBrand(con, brandname);
		sc.close();
		System.out.println(status);
		

	}

}
