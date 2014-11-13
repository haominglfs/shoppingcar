package cn.lut.shopping.action;

import java.util.List;
import java.util.Map;

import javax.websocket.Session;

import org.apache.struts2.interceptor.SessionAware;

import cn.lut.shopping.bean.Product;
import cn.lut.shopping.bean.User;
import cn.lut.shopping.dao.ProductDao;
import cn.lut.shopping.dao.UserDao;

public class RegisterAction implements SessionAware {

	private String register_message;
	private String login_message;

	private User user;
	private Map<String, Object> sessionMap;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRegister_message() {
		return register_message;
	}

	public String getLogin_message() {
		return login_message;
	}

	public void setRegister_message(String register_message) {
		this.register_message = register_message;
	}

	public void setLogin_message(String login_message) {
		this.login_message = login_message;
	}

	public String register() {

		String username = user.getUsername();
		String password = user.getPassword();
		String password1 = user.getPassword1();
		if ("".equals(username)) {
			register_message = "用户名不能为空";
			sessionMap.put("register_message", register_message);
			return "fail";
		}
		if (!password.equals(password1)) {
			register_message = "两次密码不一致";
			sessionMap.put("register_message", register_message);
			return "fail";
		}

		UserDao ud = new UserDao();
		List<User> users = ud.queryAll();
		for (User u : users) {
			if (u.getUsername().equals(username)) {
				register_message = "用户名已经存在";
				sessionMap.put("register_message", register_message);
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

	public String login() {

		String username = user.getUsername();
		String password = user.getPassword();
		System.out.println(username);
		System.out.println(password);
		if ("".equals(username)) {
			login_message = "用户名不能为空";
			sessionMap.put("login_message", login_message);
			return "fail1";
		}

		UserDao ud = new UserDao();
		List<User> users = ud.queryAll();
		int i = 0;
		for (User u : users) {

			if (username.equals(u.getUsername())) {
				i = 1;
				if (password.equals(u.getPassword())) {
					return "success1";
				}
			}
		}

		if (i == 1) {
			login_message = "密码错误";
		} else {
			login_message = "用户不存在";
		}
		sessionMap.put("login_message", login_message);
		return "fail1";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

		this.sessionMap = arg0;
	}

}
