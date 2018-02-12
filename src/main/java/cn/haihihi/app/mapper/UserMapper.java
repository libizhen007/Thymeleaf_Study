package cn.haihihi.app.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import cn.haihihi.app.domain.User;

/**
 * 使用mybatis开发
 * @author Administrator
 *
 */
@Component
@Mapper//或者在启动类上添加@MapperScan(“com.dudu.dao”)注解都行。
public interface UserMapper {

	@Insert("INSERT INTO user VALUES(#{username})")
	public int addUser(User user);
	
	//使用xml文件配置
	public int delete(String username);
}
