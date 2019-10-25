package admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import user.UserInfo;

/**
 * 
 * @author Kevin
 * 
 */
public class Data {
	private String dataFilePath = "Data.data";// 数据缓存地址

	/**
	 * Description： 从本地文件读取数据存入UserInfo[] 数据
	 * 
	 * @param userArray
	 *            存数据的数组
	 */
	public void readeInfo(UserInfo[] userArray) {
		File file = new File(dataFilePath);
		DataInputStream dataInputStream = null;
		int count = 0;
		try {
			while (userArray[count] != null)
				count++;
			if (!file.exists())
				file.createNewFile();
			dataInputStream = new DataInputStream(new BufferedInputStream(
					new FileInputStream(dataFilePath)));
			while (true) {
				UserInfo temp = new UserInfo();
				temp.setUserName(dataInputStream.readUTF());
				temp.setUserID(dataInputStream.readUTF());
				temp.setUserPassword(dataInputStream.readUTF());
				temp.setUserScore(dataInputStream.readInt());
				temp.setUserLevel(dataInputStream.readInt());
				// if(temp.getUserID()==null) break;
				userArray[count++] = temp;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (dataInputStream != null)
					dataInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}

	/**
	 * Description： 将数组的信息存入本地文件
	 * 
	 * @param userArry
	 *            存放信息的数组
	 */
	public void writeInfo(UserInfo[] userArray) {
		File file = new File(dataFilePath);
		DataOutputStream outputStream = null;
		int count = 0;
		try {
			outputStream = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(dataFilePath)));
			for (int i = 0; userArray[i] != null; i++) {
				UserInfo temp;
				temp = userArray[i];
				outputStream.writeUTF(temp.getUserName());
				outputStream.writeUTF(temp.getUserID());
				outputStream.writeUTF(temp.getUserPassword());
				outputStream.writeInt(temp.getUserScore());
				outputStream.writeInt(temp.getUserLevel());
			}
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}

	}

	/**
	 * Description: 根据ID删除用户
	 * 
	 * @param userArray
	 *            存放的数据的数组
	 * @param ID
	 *            要删除的用户ID
	 * @return 删除了返回true
	 */
	public boolean delUser(UserInfo[] userArray, String ID) {
		for (int i = 0; userArray[i] != null; i++) {
			if (userArray[i].getUserID().equals(ID)) {
				while (userArray[i + 1] != null)
					userArray[i] = userArray[++i];
				userArray[i] = null;
				return true;
			}
		}
		return false;
	}

	/**
	 * Description:根据ID修改名字，密码， 积分， 等级
	 * 
	 * @param userArray
	 * @param ID
	 * @return 成功返回True
	 */
	public boolean updatUser(UserInfo[] userArray, String ID) {
		String userName = null, userPassword = null;
		Scanner inputScanner = new Scanner(System.in);
		int userScore = 0, userLevel = 0;
		for (int i = 0; userArray[i] != null; i++) {
			if (userArray[i].getUserID().equals(ID)) {
				show(userArray[i]);

				System.out.println("请输入修改的名字:");
				userName = inputScanner.next();
				System.out.println("请输入修改的密码:");
				userPassword = inputScanner.next();
				System.out.println("请输入要修改的积分:");
				userScore = inputScanner.nextInt();
				System.out.println("请输入要修改的等级");
				userLevel = inputScanner.nextInt();
				userArray[i].setUserName(userName);
				userArray[i].setUserScore(userScore);
				userArray[i].setUserLevel(userLevel);
				userArray[i].setUserPassword(userPassword);

				show(userArray[i]);
				return true;
			}
		}
		return false;
	}

	/**
	 * Description： 显示user用户的信息
	 * 
	 * @param user
	 */
	public void show(UserInfo user) {
		if (user != null)
			System.out.println("用户名：" + user.getUserName() + "\n用户ID："
					+ user.getUserID() + "\n用户密码：" + user.getUserPassword()
					+ "\n用户积分：" + user.getUserScore() + "\n用户等级："
					+ user.getUserLevel());
	}

	/**
	 * Description:显示所有用户信息
	 */
	public void showAll(UserInfo[] userArray) {
		for (int i = 0; userArray[i] != null; i++) {
			UserInfo user = userArray[i];
			System.out.println("用户名：" + user.getUserName() + "\n用户ID："
					+ user.getUserID() + "\n用户密码：" + user.getUserPassword()
					+ "\n用户积分：" + user.getUserScore() + "\n用户等级："
					+ user.getUserLevel());
		}
	}
}
