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
	private String dataFilePath = "Data.data";// ���ݻ����ַ

	/**
	 * Description�� �ӱ����ļ���ȡ���ݴ���UserInfo[] ����
	 * 
	 * @param userArray
	 *            �����ݵ�����
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
	 * Description�� ���������Ϣ���뱾���ļ�
	 * 
	 * @param userArry
	 *            �����Ϣ������
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
	 * Description: ����IDɾ���û�
	 * 
	 * @param userArray
	 *            ��ŵ����ݵ�����
	 * @param ID
	 *            Ҫɾ�����û�ID
	 * @return ɾ���˷���true
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
	 * Description:����ID�޸����֣����룬 ���֣� �ȼ�
	 * 
	 * @param userArray
	 * @param ID
	 * @return �ɹ�����True
	 */
	public boolean updatUser(UserInfo[] userArray, String ID) {
		String userName = null, userPassword = null;
		Scanner inputScanner = new Scanner(System.in);
		int userScore = 0, userLevel = 0;
		for (int i = 0; userArray[i] != null; i++) {
			if (userArray[i].getUserID().equals(ID)) {
				show(userArray[i]);

				System.out.println("�������޸ĵ�����:");
				userName = inputScanner.next();
				System.out.println("�������޸ĵ�����:");
				userPassword = inputScanner.next();
				System.out.println("������Ҫ�޸ĵĻ���:");
				userScore = inputScanner.nextInt();
				System.out.println("������Ҫ�޸ĵĵȼ�");
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
	 * Description�� ��ʾuser�û�����Ϣ
	 * 
	 * @param user
	 */
	public void show(UserInfo user) {
		if (user != null)
			System.out.println("�û�����" + user.getUserName() + "\n�û�ID��"
					+ user.getUserID() + "\n�û����룺" + user.getUserPassword()
					+ "\n�û����֣�" + user.getUserScore() + "\n�û��ȼ���"
					+ user.getUserLevel());
	}

	/**
	 * Description:��ʾ�����û���Ϣ
	 */
	public void showAll(UserInfo[] userArray) {
		for (int i = 0; userArray[i] != null; i++) {
			UserInfo user = userArray[i];
			System.out.println("�û�����" + user.getUserName() + "\n�û�ID��"
					+ user.getUserID() + "\n�û����룺" + user.getUserPassword()
					+ "\n�û����֣�" + user.getUserScore() + "\n�û��ȼ���"
					+ user.getUserLevel());
		}
	}
}
