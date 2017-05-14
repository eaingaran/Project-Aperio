package xyz.aingaran.project.aperio.domain;

/**
 * @author Aingaran Elango
 * @category Bean Object
 * This bean carries information about User(s)
 */
public class User {

	private int userId;
	private String userName;
	private String email;
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @category Parameterized Constructor
	 * @param userId
	 * @param userName
	 * @param email
	 */
	public User(int userId, String userName, String email) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
	}
	
	/**
	 * @category Default Constructor
	 */
	public User() {
	}
	
	
}
