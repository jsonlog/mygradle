package user;
/**
 * @Copy Right Information：LOVIN
 * @See：用户信息
 * @Project: Typewriting
 * @Version： 1.0.0 2015.11.11
 * @JDK Version used：JDK 1.7
 * @Author： Kevin
 *
 */
public class UserInfo {
	private String userName; // 用户名
	private String userID; // 登陆ID
	private String userPassword; // 登陆密码
	private int userScore; // 用户积分
	private int userLevel; //等级
	/**
	 * Description： 获得用户等级
	 * @return int
	 */
	public int getUserLevel() {
		return userLevel;
	}
/**
 * Description： 设置等级
 * @param userGrade 
 */
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
/**
 * Description： 获得用户名
 * @return String
 */
	public String getUserName() {
		return userName;
	}
/**
 * Description： 设置用户名
 * @param userName
 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
/**
 * Description：设置用户ID
 * @return String
 */
	public String getUserID() {
		return userID;
	}
/**
 * Description： 设置用户ID
 * @param userID
 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
/**
 * Description：获得用户密码
 * @return	String
 */
	public String getUserPassword() {
		return userPassword;
	}
/**
 * Description： 设置用户密码
 * @param userPassword
 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
/**
 * Description： 获得用户游戏积分
 * @return int
 */
	public int getUserScore() {
		return userScore;
	}
/**
 * Description： 设置用户游戏积分
 * @param userScore
 */
	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

}
