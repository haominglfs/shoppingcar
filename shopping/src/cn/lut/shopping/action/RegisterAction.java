package cn.lut.shopping.action;

import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.struts2.interceptor.SessionAware;

import cn.lut.shopping.bean.Product;
import cn.lut.shopping.bean.User;
import cn.lut.shopping.dao.ProductDao;
import cn.lut.shopping.dao.UserDao;

public class RegisterAction implements SessionAware{

	private User user;
	private String message;
	private Map<String, Object> sessionMap ;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String register(){
		
		String username = user.getUsername();
		String password = user.getPassword();
		String password1 = user.getPassword1();
		if("".equals(username)){
			message="用户名不能为空";
			sessionMap.put("message", message);
			return "fail";
		}
		if(!password.equals(password1)){
			message="两次密码不一致";
			sessionMap.put("message", message);
			return "fail";
		}
		
		UserDao ud = new UserDao();
		List<User> users = ud.queryAll();
		for(User u : users){
			if(u.getUsername().equals(username)){
				message="用户名已经存在";
				sessionMap.put("message", message);
				return "fail";
			}
		}
		
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		ud.add(u);
		
		ProductDao pd = new ProductDao();
		List<Product> products = pd.queryAll();
		sessionMap.put("products", products);
		
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

		this.sessionMap = arg0;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
