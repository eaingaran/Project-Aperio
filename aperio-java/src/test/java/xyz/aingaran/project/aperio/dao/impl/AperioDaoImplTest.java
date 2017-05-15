package xyz.aingaran.project.aperio.dao.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xyz.aingaran.project.aperio.dao.AperioDao;
import xyz.aingaran.project.aperio.domain.User;

/**
 * @author Aingaran Elango
 * @category Test Class
 * This class tests the functionality of {@link AperioDaoImpl}
 */
@ContextConfiguration(locations="/spring/resources.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AperioDaoImplTest implements ApplicationContextAware {

	@Autowired
	private ApplicationContext applicationContext;
	
	AperioDao aperioDao;
	List<User> users;
	
	@Before
	public void setUp() throws Exception {
		aperioDao =  (AperioDao) applicationContext.getBean("aperioDao");
		users = new ArrayList<>();
		for(int i=0;i<100;i++) {
			User user = new User(i,"name"+i,"name"+i+"@gmail.com");
			users.add(user);
		}
		for(int i=100;i<200;i++) {
			User user = new User();
			user.setUserId(i);
			user.setUserName("name"+i);
			user.setEmail("name"+i+"@gmail.com");
			users.add(user);
		}
	}

	@After
	public void tearDown() throws Exception {
		SqlSession session = aperioDao.getSqlSessionFactory().openSession();
		for(User user : users) {
			session.delete("deleteUser", user.getUserId());
		}
	}

	@Test
	public void testInsertPositive() {
		assertTrue(aperioDao.insert("insertUsers", users));
	}
	
	@Test
	public void testInsertNegative() {
		assertFalse(aperioDao.insert("someRandomQueryId", users));
	}
	
	@Test
	@Ignore
	public void testInsertPositiveDeep() {
		SqlSession session = aperioDao.getSqlSessionFactory().openSession();
		List<User> userList = session.selectList("selectUsers");
		System.out.println(userList.size());
		System.out.println(users.size());
		assertTrue(userList.size()==users.size());
		for(User user : userList) {
			assert(users.contains(user));
		}
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		
	}

}
