package game;

import java.util.Scanner;

public class Adventure {
	Game a = new Game();
	Scanner input = new Scanner(System.in);
	double accuracy = 0;// 正确率
	double speed = 0;// 打字速度
	int level=0;
	public void Mode(String s) {// 选择模式菜单
		System.out.println("***********欢迎来到金山打字游戏***************");
		System.out.println("欢迎来到冒险模式");
		System.out.println("1.简单模式");
		System.out.println("2.一般模式");
		System.out.println("3.困难模式");
		System.out.println("4.返回上一级");
		System.out.println("请输入您的选择");
		int num = input.nextInt();
		switch (num) {
		case 1:
			Easy(s);
			break;
		case 2:
			if (level >= 1) {
				Normal(s);
			} else {
				System.out.println("对不起您的等级不够，请先通过简单模式");
				Mode(s);
			}

			break;
		case 3:
			if (level >= 2) {
				Hard(s);
			} else {
				System.out.println("对不起您的等级不够，请先通过一般模式");
				Mode(s);
			}

			break;
		case 4:
			break;
		}
	}

	public void Count(String s) {// 计算的方法
		int right = 0;// 对的数
		int wrong = 0;// 错的数
		Scanner inputs = new Scanner(System.in);
		System.out.println("请输入下面这段话：");
		String str = s;
		System.out.println(str);
		long long1 = System.currentTimeMillis();// 输入一瞬间开始记录时间
		String in = inputs.nextLine();
		long long2 = System.currentTimeMillis();// 结束时记录时间
		long time = long2 - long1;
		char[] ch1 = str.toCharArray();// 类型转换
		char[] ch2 = in.toCharArray();// 由String型转换成char型
		int b = in.length() > str.length() ? str.length() : in.length();
		for (int i = 0; i < b; i++) {
			if (ch1[i] == ch2[i]) {
				right++;// 正确个数加1
			} else {
				// wrong++;// 错误个数加1
			}
		}
		try {
			this.accuracy = (right / str.length()) * 100;// 计算正确率
			this.speed = b / ((time / 1000.0) / 60.0);// 计算速度
		} catch (Exception e) {

		}
		System.out.println("您输入的用时是：" + time / 1000 + "秒" + time % 1000 / 10);
		System.out.println("正确率是：" + this.accuracy + "%");
		System.out.println("您的速度是：" + (int) this.speed + "字/分钟");
	}

	public void Easy(String s) {// 简单模式
		System.out.println("***********欢迎来到简单模式***************");
		Count(s);
		if (this.accuracy > 10 && this.speed > 10) {
			if (this.level < 1) {
				this.level = 1;
			}
			System.out.println("***********欢迎来到简单模式***************");
			System.out.println("恭喜您通过了此关");
			System.out.println("您的等级现在为：" + this.level);
			System.out.println("请您继续选择您要玩的模式");
			System.out.println("1.简单模式");
			System.out.println("2.一般模式");
			System.out.println("3.困难模式");
			System.out.println("4.返回选择语言");
			int num = input.nextInt();
			if (num == 1 && this.level >= 0) {
				Easy(s);
			} else if (num == 2) {
				if (level >= 1) {
					Normal(s);
				} else {
					System.out.println("对不起，您的等级不够");
					Mode(s);
				}

			} else if (num == 3) {
				if (level >= 2) {
					Hard(s);
				}else{
					System.out.println("对不起，您的等级不够");
					Mode(s);
				}
			} else if (num == 4) {
				Game q = new Game();
				q.gameMenu();
			}
		} else {
			System.out.println("***********欢迎来到简单模式***************");
			System.out.println("对不起，您未通过此模式");
			System.out.println("1.返回上一级  2.继续本模式");
			int num = input.nextInt();
			if (num == 1) {
				Mode(s);
			} else if (num == 2) {
				Easy(s);
			}
		}
	}

	public void Normal(String s) {// 一般模式
		System.out.println("***********欢迎来到一般模式***************");
		Count(s);
		if (this.accuracy > 80 && this.speed > 80) {
			if (this.level < 2) {
				this.level = 2;
			}
			System.out.println("***********欢迎来到一般模式***************");
			System.out.println("恭喜您通过了此关");
			System.out.println("您的等级现在为：" + this.level);
			System.out.println("请您继续选择您要玩的模式");
			System.out.println("1.简单模式");
			System.out.println("2.一般模式");
			System.out.println("3.困难模式");
			System.out.println("4.返回选择语言");
			int num = input.nextInt();
			if (num == 1 && this.level >= 0) {
				Easy(s);
			} else if (num == 2) {
				if (level >= 1) {
					Normal(s);
				} else {
					System.out.println("对不起，您的等级不够");
					Mode(s);
				}

			} else if (num == 3) {
				if (level >= 2) {
					Hard(s);
				} else {				
					System.out.println("对不起，您的等级不够");
					Mode(s);
				}
			} else if (num == 4) {
				Game q = new Game();
				q.gameMenu();
			}
		} else {		
			System.out.println("对不起，您未通过此模式");
			System.out.println("1.返回上一级  2.继续本模式");
			int num = input.nextInt();
			if (num == 1) {
				Mode(s);
			} else if (num == 2) {
				Easy(s);
			}
		}
	}

	public void Hard(String s) {// 困难模式
		System.out.println("***********欢迎来到困难模式***************");
		Count(s);
		if (this.accuracy > 95 && this.speed > 95) {
			if (this.level < 3) {
				this.level = 3;
			}
			System.out.println("***********欢迎来到困难模式***************");
			System.out.println("恭喜您通过了此关");
			System.out.println("您的等级现在为：" + this.level);
			System.out.println("请您继续选择您要玩的模式");
			System.out.println("1.简单模式");
			System.out.println("2.一般模式");
			System.out.println("3.困难模式");
			System.out.println("4.返回选择语言");
			int num = input.nextInt();
			if (num == 1 && this.level >= 0) {
				Easy(s);
			} else if (num == 2) {
				if (level >= 1) {
					Normal(s);
				} else {
					System.out.println("对不起，您的等级不够");
					Mode(s);
				}

			} else if (num == 3) {
				if (level >= 2) {
					Hard(s);
				} else {
					System.out.println("对不起，您的等级不够");
					Mode(s);
				}
			} else if (num == 4) {
				Game q = new Game();
				q.gameMenu();
			}
		} else {
			System.out.println("对不起，您未通过此模式");
			System.out.println("1.返回上一级  2.继续本模式");
			int num = input.nextInt();
			if (num == 1) {
				Mode(s);
			} else if (num == 2) {
				Easy(s);
			}
		}
	}
}