package game;

import java.util.Scanner;

public class Game {
	Scanner input = new Scanner(System.in);
	int choose1; // 游戏语言选择
	int choose2; // 游戏模式选择
	int right = 0; // 记录正确的数量
	int wrong = 0; // 记录错误的数量
	int rat = 0; // 速度
	int Drat = 0; // 正确率
	boolean isTrue = true;
	String strC = "我国的首都在北京，那里风景优美，物产丰富，是个好玩的地方，也是一座美丽的城市。";
	String strE = "Since I go to high school, I have to walk a very far distance, it always takes me half an hour to reach the school.";

	// Menu m = new Menu(); //接菜单类
	/**
	 * 游戏主菜单
	 */
	public void gameMenu() {
		while (isTrue) {
			System.out.println("***********欢迎来到金山打字游戏***************");
			System.out.println("\t1、汉字游戏");
			System.out.println("\t2、英语游戏");
			System.out.println("\t3、返回上一级");
			System.out.println("\t0、退出系统");
			System.out.println("****************************************");
			System.out.print("请输入您的选择(输入0或任意数字返回上一级)：");
			choose1 = input.nextInt();
			switch (choose1) {
			case 1:
				showGameType(strC);
				break;
			case 2:
				showGameType(strE);
				break;
			case 3:
				return;
			case 0:
				System.exit(0);
			default:
				break;
			}
			/*
			 * if (choose1 == 1) { showGameType(strC);
			 * 
			 * } else if (choose1 == 2) { showGameType(strE);
			 * 
			 * } else { break; }
			 */
		}
	}

	/**
	 * 显示游戏模式
	 */
	public void showGameType(String s) {
		Adventure c = new Adventure();
		boolean flag = true;
		while (flag) {
			System.out.println("***********欢迎来到金山打字游戏***************");
			System.out.println("\t1、打字速度测试");
			System.out.println("\t2、冒险模式");
			System.out.println("\t0、返回上一级");
			System.out.println("****************************************");
			System.out.print("请输入您的选择(输入0或任意数字返回上一级)：");
			choose2 = input.nextInt();
			if (choose2 == 1) {
				LanguagePlayTest(s);
				flag = true;
			} else if (choose2 == 2) {
				c.Mode(s);
				flag = true;
			} else if (choose2 != 1 && choose2 != 2) {
				flag = false;
			}
		}

	}

	/**
	 * 打字速度测试
	 */
	public void LanguagePlayTest(String s) {

		System.out.println("请输入下面这段话：");
		System.out.println(s);
		long long1 = System.currentTimeMillis(); // 开始时间
		String str1 = input.next();
		long long2 = System.currentTimeMillis(); // 结束时间
		char[] ch1 = s.toCharArray(); // 将原字符串转化成字符数组
		char[] ch2 = str1.toCharArray(); // 将输入字符串转化成字符数组
		long time = long2 - long1; // 打字用时
		for (int i = 0; i < (ch2.length > ch1.length ? ch1.length : ch2.length); i++) { // ?
																						// :
																						// 取两个数组小的防止出现空指针异常
			if (ch1[i] == ch2[i]) {
				right++; // 正确的数量
			} else {
				wrong++; // 错误的数量
			}
		}
		rat = (int) (ch2.length / (time / 1000) * 60);
		Drat = right * 100 / ch2.length;
		System.out.println("您输入的用时是：" + time / 1000 + "秒" + time % 1000 / 10);
		System.out.println("您的正确率是：" + Drat + "%");
		System.out.println("您的速度是：" + rat + "字/分");
		if (rat < 100 || Drat < 85) { // 不及格：速度小于100m/s||准确度小于85%
			System.out.println("您没有及格，继续努力哦~");
		} else if ((rat >= 100 && rat < 110) && Drat >= 85) { // 及格：速度大于等于100m/s小于110m/s&&准确度大于等于85%
			System.out.println("恭喜您及格了~");
		} else if ((rat >= 110 && rat < 130) && Drat >= 90) { // 良好：速度大于等于110m/s小于130m/s&&准确度大于等于90%
			System.out.println("成绩良好~继续加油吧！");
		} else if ((rat >= 130 && rat < 150) && Drat >= 95) { // 优秀：速度大于等于130m/s小于150m/s&&准确度大于等于95%
			System.out.println("成绩优秀~fighting~");
		} else if (rat >= 200 && Drat == 100) { // 超神：速度大于等于200m/s&&准确度等于100%
			System.out.println("哇塞~您的速度都超神了！");
		}

	}

}
