package cn.lut.shopping.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import cn.lut.shopping.bean.Product;
import cn.lut.shopping.util.JDBCUtil;
import cn.lut.shopping.util.SessionCreater;

public class Test {

	@org.junit.Test
	public void testGetConnection() {
		JDBCUtil.getConnection();
	}

	@org.junit.Test
	public void testP(){
		Product p = new Product();
		p.setPname("java");
		p.setPdesc("java-java");
		p.setPprice(99.99);
		SessionFactory sf = SessionCreater.getSessionFactory();
		Session s = sf.openSession();
		Transaction ts = s.beginTransaction();
		s.save(p);
		ts.commit();
		SessionCreater.close(sf, s);
		
	}
}
