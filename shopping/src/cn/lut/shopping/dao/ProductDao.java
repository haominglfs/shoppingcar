package cn.lut.shopping.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.lut.shopping.bean.Product;
import cn.lut.shopping.util.SessionCreater;

public class ProductDao {

	private SessionFactory sf;
	private Session s;
	private Transaction ts;
	
	public List<Product> queryAll(){
		sf = SessionCreater.getSessionFactory();
		s = sf.openSession();
		ts = s.beginTransaction();
		Query query = s.createQuery("from Product");
		List<Product> products = query.list();
		SessionCreater.close(sf, s);
		
		return products;
	}
}
