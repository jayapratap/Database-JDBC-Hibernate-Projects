package org.restTest.showroom.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.restTest.showroom.hibernate.entities.BrandEntity;

public class BrandsDAO {

	SessionFactory factory = new Configuration()
			 .configure("hibernate.cfg.xml")
			 .addAnnotatedClass(BrandEntity.class)
			 .buildSessionFactory();
	
	public List<BrandEntity> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<BrandEntity> list = session.createQuery("from brands").getResultList();
		return list;
	}

	public void addBrand(BrandEntity brand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
	}

	public void updateBrand(BrandEntity updateBrand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(updateBrand);
		session.getTransaction().commit();		
	}

	public void deleteBrand(int brandID) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class, brandID);
		session.delete(brand);
		session.getTransaction().commit();		
	}

}
