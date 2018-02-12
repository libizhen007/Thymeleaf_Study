package cn.haihihi.app.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截错误页
 * @author Administrator
 *
 */
@Configuration
public class MyErrorViewResolver implements ErrorViewResolver {
	/**
	 * 这里可以获取到错误页的信息
	 */
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		System.out.println(status);//404 == Not Found
		return null;
	}

}
