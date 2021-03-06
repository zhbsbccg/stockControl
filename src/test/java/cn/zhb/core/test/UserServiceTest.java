package cn.zhb.core.test;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zhb.core.entity.Users;
import cn.zhb.core.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring.xml"})
public class UserServiceTest {
	@Resource
	private UsersService userService;
	
	@Test
	public void test() {
		Users user = userService.getUserByUsername("admin");
		System.out.println(user);
		assertNotNull(user);
	}
	@Test
	public void testPassword() {
		String password = "admin";
		String md5Password = DigestUtils.md5Hex(password);
		System.out.println(md5Password);
	}
	
}
