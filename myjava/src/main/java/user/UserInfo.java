package user;
/**
 * @Copy Right Information��LOVIN
 * @See���û���Ϣ
 * @Project: Typewriting
 * @Version�� 1.0.0 2015.11.11
 * @JDK Version used��JDK 1.7
 * @Author�� Kevin
 *
 */
public class UserInfo {
	private String userName; // �û���
	private String userID; // ��½ID
	private String userPassword; // ��½����
	private int userScore; // �û�����
	private int userLevel; //�ȼ�
	/**
	 * Description�� ����û��ȼ�
	 * @return int
	 */
	public int getUserLevel() {
		return userLevel;
	}
/**
 * Description�� ���õȼ�
 * @param userGrade 
 */
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
/**
 * Description�� ����û���
 * @return String
 */
	public String getUserName() {
		return userName;
	}
/**
 * Description�� �����û���
 * @param userName
 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
/**
 * Description�������û�ID
 * @return String
 */
	public String getUserID() {
		return userID;
	}
/**
 * Description�� �����û�ID
 * @param userID
 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
/**
 * Description������û�����
 * @return	String
 */
	public String getUserPassword() {
		return userPassword;
	}
/**
 * Description�� �����û�����
 * @param userPassword
 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
/**
 * Description�� ����û���Ϸ����
 * @return int
 */
	public int getUserScore() {
		return userScore;
	}
/**
 * Description�� �����û���Ϸ����
 * @param userScore
 */
	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

}
