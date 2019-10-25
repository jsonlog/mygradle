package ui;

import game.Game;

import java.util.Scanner;

import admin.Data;

import user.UserInfo;

public class Menu {
	UserInfo[] userArray = new UserInfo[200]; // 数组开大点

	UserInfo u = null;
	Game n = null;
	Data data = new Data();
	// 主菜单
	public void Menu() {
		data.readeInfo(userArray);
		Scanner input = new Scanner(System.in);
		System.out.println("\n\t欢迎进入金山打字通！");
		System.out.println("*************************************************");
		System.out.println("\t1.注册");
		System.out.println("\t2.登陆");
		System.out.println("\t3.保存信息");
		System.out.print("\t请输入您的选择：");
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
			System.out.println("保存成功");
			Menu();
			break;
		default:
			System.out.println("\n\t输入错误！重新输入！");
			Menu();
			break;
		}
		/*
		 * if (i == 1) { Register(); } else if (i == 2) { Login(); n = new
		 * Game(); Menu(); return ; } else {
		 * System.out.println("\n\t输入错误！重新输入！"); Menu(); }
		 */
	}

	// 注册分菜单
	public void Register() {
		Scanner input = new Scanner(System.in);
		UserInfo tempUserInfo = new UserInfo(); // ？？
		System.out.println("\n\t注册界面");
		System.out.println("*************************************************");
		System.out.print("\t请输入用户名：");
		String UserName = input.next();
		System.out.print("\t请输入您的ID：");
		String UserID = input.next();
		System.out.print("\t请输入密码：");
		String UserPassword1 = input.next();
		System.out.print("\t请再次输入密码：");
		String UserPassword2 = input.next();
		// 检测密码
		if (UserPassword1.equals(UserPassword2)) {
			for (int i = 0; userArray[i] != null; i++) {// ？？
				// 检测Id
				if (userArray[i].getUserID().equals(UserID)) {
					System.out.println("\n\t用户ID已被注册！请重新注册！");
					Menu();
					return;// ？？
				}
			}
			System.out.println("\n\t注册成功！");
			tempUserInfo.setUserName(UserName); // ？？
			tempUserInfo.setUserID(UserID);
			tempUserInfo.setUserPassword(UserPassword1);
			tempUserInfo.setUserLevel(0);
			tempUserInfo.setUserScore(0);
			// 保存信息
			for (int i = 0; i < userArray.length; i++) { // 循环查找空位
				if (userArray[i] == null) {
					userArray[i] = tempUserInfo; // ？？
					break;
				}
			}
			Menu();
			return; // ？？
		}else {
			System.out.println("两次密码不同，请再次选择");
			Menu();
			return;
		}
	}

	// 登录分菜单
	public void Login() {
		boolean y = Loginplus();
		if (y) {
			System.out.println("\n\t登陆成功！");
			n = new Game();
			n.gameMenu();
		} else {
			System.out.println("\n\t登陆失败！");
			Menu();
			return;// ？？
		}
	}

	public boolean Loginplus() {
		Scanner input = new Scanner(System.in);
		UserInfo usertempInfo;
		System.out.println("\n\t登录界面");
		System.out.println("*************************************************");
		System.out.print("\t请输入用户ID：");
		String UserID = input.next();
		System.out.print("\t请输入密码：");
		String UserPassword = input.next();

		for (int i = 0; userArray[i] != null; i++) { // ？？

			if (userArray[i].getUserID().equals(UserID)
					&& userArray[i].getUserPassword().equals(UserPassword)) {

				u = userArray[i];
				return true;
			}
		}

		return false;
	}

}
