package xyz.aingaran.project.aperio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Aingaran Elango
 * @category Test Class
 * This class tests the functionality of HelloWorld
 * @see HelloWorld
 */
@ContextConfiguration(locations="/spring/resources.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldTest implements ApplicationContextAware {

	@Autowired
	private ApplicationContext applicationContext;
	
	private HelloWorld helloWorld;
	private String notHelloWorldString;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
	 	notHelloWorldString = "not a hello world!";

	}

	/**
	 * Test method for {@link xyz.aingaran.project.aperio.HelloWorld#sayHelloWorld()}.
	 */
	@Test
	public void testSayHelloWorldPositive() {
		assertTrue(helloWorld.sayHelloWorld().equalsIgnoreCase(helloWorld.getHelloWorld()));
	}
	
	/**
	 * Test method for {@link xyz.aingaran.project.aperio.HelloWorld#sayHelloWorld()}.
	 */
	@Test
	public void testSayHelloWorldNegative() {
		assertFalse(helloWorld.sayHelloWorld().equalsIgnoreCase(notHelloWorldString));

	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		
	}

}
