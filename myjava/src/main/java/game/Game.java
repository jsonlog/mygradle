package game;

import java.util.Scanner;

public class Game {
	Scanner input = new Scanner(System.in);
	int choose1; // ��Ϸ����ѡ��
	int choose2; // ��Ϸģʽѡ��
	int right = 0; // ��¼��ȷ������
	int wrong = 0; // ��¼���������
	int rat = 0; // �ٶ�
	int Drat = 0; // ��ȷ��
	boolean isTrue = true;
	String strC = "�ҹ����׶��ڱ���������羰����������ḻ���Ǹ�����ĵط���Ҳ��һ�������ĳ��С�";
	String strE = "Since I go to high school, I have to walk a very far distance, it always takes me half an hour to reach the school.";

	// Menu m = new Menu(); //�Ӳ˵���
	/**
	 * ��Ϸ���˵�
	 */
	public void gameMenu() {
		while (isTrue) {
			System.out.println("***********��ӭ������ɽ������Ϸ***************");
			System.out.println("\t1��������Ϸ");
			System.out.println("\t2��Ӣ����Ϸ");
			System.out.println("\t3��������һ��");
			System.out.println("\t0���˳�ϵͳ");
			System.out.println("****************************************");
			System.out.print("����������ѡ��(����0���������ַ�����һ��)��");
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
	 * ��ʾ��Ϸģʽ
	 */
	public void showGameType(String s) {
		Adventure c = new Adventure();
		boolean flag = true;
		while (flag) {
			System.out.println("***********��ӭ������ɽ������Ϸ***************");
			System.out.println("\t1�������ٶȲ���");
			System.out.println("\t2��ð��ģʽ");
			System.out.println("\t0��������һ��");
			System.out.println("****************************************");
			System.out.print("����������ѡ��(����0���������ַ�����һ��)��");
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
	 * �����ٶȲ���
	 */
	public void LanguagePlayTest(String s) {

		System.out.println("������������λ���");
		System.out.println(s);
		long long1 = System.currentTimeMillis(); // ��ʼʱ��
		String str1 = input.next();
		long long2 = System.currentTimeMillis(); // ����ʱ��
		char[] ch1 = s.toCharArray(); // ��ԭ�ַ���ת�����ַ�����
		char[] ch2 = str1.toCharArray(); // �������ַ���ת�����ַ�����
		long time = long2 - long1; // ������ʱ
		for (int i = 0; i < (ch2.length > ch1.length ? ch1.length : ch2.length); i++) { // ?
																						// :
																						// ȡ��������С�ķ�ֹ���ֿ�ָ���쳣
			if (ch1[i] == ch2[i]) {
				right++; // ��ȷ������
			} else {
				wrong++; // ���������
			}
		}
		rat = (int) (ch2.length / (time / 1000) * 60);
		Drat = right * 100 / ch2.length;
		System.out.println("���������ʱ�ǣ�" + time / 1000 + "��" + time % 1000 / 10);
		System.out.println("������ȷ���ǣ�" + Drat + "%");
		System.out.println("�����ٶ��ǣ�" + rat + "��/��");
		if (rat < 100 || Drat < 85) { // �������ٶ�С��100m/s||׼ȷ��С��85%
			System.out.println("��û�м��񣬼���Ŭ��Ŷ~");
		} else if ((rat >= 100 && rat < 110) && Drat >= 85) { // �����ٶȴ��ڵ���100m/sС��110m/s&&׼ȷ�ȴ��ڵ���85%
			System.out.println("��ϲ��������~");
		} else if ((rat >= 110 && rat < 130) && Drat >= 90) { // ���ã��ٶȴ��ڵ���110m/sС��130m/s&&׼ȷ�ȴ��ڵ���90%
			System.out.println("�ɼ�����~�������Ͱɣ�");
		} else if ((rat >= 130 && rat < 150) && Drat >= 95) { // ���㣺�ٶȴ��ڵ���130m/sС��150m/s&&׼ȷ�ȴ��ڵ���95%
			System.out.println("�ɼ�����~fighting~");
		} else if (rat >= 200 && Drat == 100) { // �����ٶȴ��ڵ���200m/s&&׼ȷ�ȵ���100%
			System.out.println("����~�����ٶȶ������ˣ�");
		}

	}

}
