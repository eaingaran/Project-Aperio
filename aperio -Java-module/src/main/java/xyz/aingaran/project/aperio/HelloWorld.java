package xyz.aingaran.project.aperio;

import org.apache.log4j.Logger;

/**
 * @author Aingaran Elango
 * @category Hello world! - class
 */
public class HelloWorld {
	protected final static Logger logger = Logger.getLogger(HelloWorld.class);
	//Injected
	String helloWorld;
	
	
    /**
	 * @return the helloWorld
	 */
	public String getHelloWorld() {
		return helloWorld;
	}

	/**
	 * @param helloWorld the helloWorld to set
	 */
	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}
	
	/**
	 * This is a public method that calls a private method helloWorld to return a string.
	 * @return String
	 */
    public String sayHelloWorld() {
    	return helloWorld();
    }
    

	/**
     * This method creates a String "Hello World!"
     * It prints the String on console, logs it and returns it too.
     * @return String
     */
    private String helloWorld() {
    	System.out.println( helloWorld );
    	logger.info("String helloWorld = "+helloWorld);
        return helloWorld;
    }
}
