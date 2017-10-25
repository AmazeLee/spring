package com.sh.a_jdbctemplate;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sh.bean.User;

/**
 * @author Amaze_lee
 * @date 2017年10月23日 上午10:13:33
 * @version V1.0
 * @Description: 演示JDBC模板
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	
	@Resource(name="userDao")
	private UserDao ud;
	
	@Test
	public void fun1() throws Exception {

		// 准备连接池
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///hibernate_01");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		// 1.创建JDBC模板对象
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(dataSource);
		
		// 2.书写sql，并执行
		String sql = "insert into t_user values(null,'甜妞')";
		jt.update(sql);
	}
	
	@Test
	public void fun2() throws Exception {

		User user = new User();
		user.setName("沙和尚");
		ud.save(user);
	}
}
