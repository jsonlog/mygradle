package ui;

import game.Game;

import java.util.Scanner;

import admin.Data;

import user.UserInfo;

public class Menu {
	UserInfo[] userArray = new UserInfo[200]; // ���鿪���

	UserInfo u = null;
	Game n = null;
	Data data = new Data();
	// ���˵�
	public void Menu() {
		data.readeInfo(userArray);
		Scanner input = new Scanner(System.in);
		System.out.println("\n\t��ӭ�����ɽ����ͨ��");
		System.out.println("*************************************************");
		System.out.println("\t1.ע��");
		System.out.println("\t2.��½");
		System.out.println("\t3.������Ϣ");
		System.out.print("\t����������ѡ��");
		int i = input.nextInt();
		switch (i) {
		case 1:
			Register();
			break;
		case 2:
			Login();		
			Menu();
			return;
		case 3:
			data.writeInfo(userArray);
			System.out.println("����ɹ�");
			Menu();
			break;
		default:
			System.out.println("\n\t��������������룡");
			Menu();
			break;
		}
		/*
		 * if (i == 1) { Register(); } else if (i == 2) { Login(); n = new
		 * Game(); Menu(); return ; } else {
		 * System.out.println("\n\t��������������룡"); Menu(); }
		 */
	}

	// ע��ֲ˵�
	public void Register() {
		Scanner input = new Scanner(System.in);
		UserInfo tempUserInfo = new UserInfo(); // ����
		System.out.println("\n\tע�����");
		System.out.println("*************************************************");
		System.out.print("\t�������û�����");
		String UserName = input.next();
		System.out.print("\t����������ID��");
		String UserID = input.next();
		System.out.print("\t���������룺");
		String UserPassword1 = input.next();
		System.out.print("\t���ٴ��������룺");
		String UserPassword2 = input.next();
		// �������
		if (UserPassword1.equals(UserPassword2)) {
			for (int i = 0; userArray[i] != null; i++) {// ����
				// ���Id
				if (userArray[i].getUserID().equals(UserID)) {
					System.out.println("\n\t�û�ID�ѱ�ע�ᣡ������ע�ᣡ");
					Menu();
					return;// ����
				}
			}
			System.out.println("\n\tע��ɹ���");
			tempUserInfo.setUserName(UserName); // ����
			tempUserInfo.setUserID(UserID);
			tempUserInfo.setUserPassword(UserPassword1);
			tempUserInfo.setUserLevel(0);
			tempUserInfo.setUserScore(0);
			// ������Ϣ
			for (int i = 0; i < userArray.length; i++) { // ѭ�����ҿ�λ
				if (userArray[i] == null) {
					userArray[i] = tempUserInfo; // ����
					break;
				}
			}
			Menu();
			return; // ����
		}else {
			System.out.println("�������벻ͬ�����ٴ�ѡ��");
			Menu();
			return;
		}
	}

	// ��¼�ֲ˵�
	public void Login() {
		boolean y = Loginplus();
		if (y) {
			System.out.println("\n\t��½�ɹ���");
			n = new Game();
			n.gameMenu();
		} else {
			System.out.println("\n\t��½ʧ�ܣ�");
			Menu();
			return;// ����
		}
	}

	public boolean Loginplus() {
		Scanner input = new Scanner(System.in);
		UserInfo usertempInfo;
		System.out.println("\n\t��¼����");
		System.out.println("*************************************************");
		System.out.print("\t�������û�ID��");
		String UserID = input.next();
		System.out.print("\t���������룺");
		String UserPassword = input.next();

		for (int i = 0; userArray[i] != null; i++) { // ����

			if (userArray[i].getUserID().equals(UserID)
					&& userArray[i].getUserPassword().equals(UserPassword)) {

				u = userArray[i];
				return true;
			}
		}

		return false;
	}

}
