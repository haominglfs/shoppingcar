package cn.lut.shopping.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import cn.lut.shopping.bean.User;

public class SessionCreater {
	
	static Configuration conf = null;
	static ServiceRegistry sr;
	static SessionFactory sf = null;
	static Session s = null;
	static Transaction ts = null;
	
	public static SessionFactory getSessionFactory(){
		conf = new Configuration().configure();
		sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		sf = conf.buildSessionFactory(sr);		
		return sf;
	}
	
	public static void close(SessionFactory sf , Session s){
		s.close();
		sf.close();
	}
}
