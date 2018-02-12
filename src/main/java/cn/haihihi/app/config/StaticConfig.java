package cn.haihihi.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.haihihi.app.interceptor.MyInterceptor;
/**
 * 重写addResourceHandlers 指定静态访问资源目录
 * @author Administrator
 *
 */
@Configuration
public class StaticConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/newaa/**").addResourceLocations("classpath:/static/aa/");
		super.addResourceHandlers(registry);
	}
	
	
	/**
	* 拦截器
	* @param registry
	*/
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    // addPathPatterns 用于添加拦截规则
	    // excludePathPatterns 用户排除拦截
		//addPathPatterns("/**")对所有请求都拦截，但是排除了/toLogin和/login请求的拦截。
	    //registry.addInterceptor(new MyInterceptor()).addPathPatterns("/day01").excludePathPatterns("/toLogin","/login");
	    super.addInterceptors(registry);
	}

}
