package cn.haihihi.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.haihihi.app.domain.User;
import cn.haihihi.app.mapper.UserMapper;
/**
 * 服务层添加事务注解，@Transactional；然后在启动类上还有加@EnableTransactionManagement  以便开启注解。
 * @Transactional 标注在类上则表明是当前类的所有方法都需要用到事务，方法同理。
 * @author Administrator
 *
 */
@Transactional
@Component
public class UserService {

	@Autowired
	private UserMapper userMapper;
	public int addUser(User user) {
		return userMapper.addUser(user);
	}
	
	public int delete(User user) {
		return userMapper.delete(user.getUsername());
	}
}
