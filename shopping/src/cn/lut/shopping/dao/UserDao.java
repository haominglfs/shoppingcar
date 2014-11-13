package cn.lut.shopping.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.lut.shopping.bean.User;
import cn.lut.shopping.util.SessionCreater;

public class UserDao {

	private SessionFactory sf;
	private Session s;
	private Transaction ts;
	
	public UserDao() {
		sf = SessionCreater.getSessionFactory();
	}
	
	public void add(User u){
		s = sf.openSession();
		ts = s.beginTransaction();
		s.save(u);
		ts.commit();
		SessionCreater.close(sf, s);
			
	}
	
	public List<User> queryAll(){
		s = sf.openSession();
		ts = s.beginTransaction();
		Query query = s.createQuery("from User");
		List<User> users = query.list();
		SessionCreater.close(sf, s);
		
		return users;
	}
}
