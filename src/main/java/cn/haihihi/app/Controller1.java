package cn.haihihi.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.haihihi.app.domain.User;
import cn.haihihi.app.service.UserService;

@Controller
public class Controller1 {

	
	@RequestMapping("day01")
	public String day01(HttpSession session,HttpServletRequest request) {
		request.setAttribute("name", "张三");
		session.setAttribute("age", 13);
		User user = new User();
		user.setUsername("李四");
		request.setAttribute("user", user);
		request.setAttribute("html", "<h1>张三1</h1>");
		request.getServletContext().setAttribute("context", "上下文");
		return "day01";
	}
	
	@ResponseBody
	@RequestMapping("/responseBody")
	public String getJson(HttpSession session) {
		System.out.println(session.getAttribute("age"));
		return "{\"name\":\"zhangsan\"}";
	}
	
	@RequestMapping("/th")
	public String thymeleaf(HttpServletRequest request) {
		
		User user = new User();
		user.setUsername("王五");
		request.setAttribute("user", user);
		String[] as = {"13","李四"};
		request.setAttribute("as", as);
		
		return "thymeleaf";
	}
	
	
	/**
	 * 数据库应用-mybatis
	 */
	@Autowired
	private UserService userService;
	
	//简单的添加
	@ResponseBody
	@RequestMapping("/addUser")
	public String addUser(User user) {
		return "数据库返回的：" + userService.addUser(user);
	}
	
	//事务管理
	@ResponseBody
	@RequestMapping("/testAdd")
	public String testAdd(User user) {
		user.setUsername("2222");
		userService.addUser(user);
		int i = 1/0;//这里会执行回滚
		return "数据库返回的：" + userService.addUser(user);
	}
	
	//mybatis使用xml文件
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(User user) {
		return "数据库返回的：" + userService.delete(user);
	}
}

