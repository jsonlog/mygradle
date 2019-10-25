package game;

import java.util.Scanner;

public class Adventure {
	Game a = new Game();
	Scanner input = new Scanner(System.in);
	double accuracy = 0;// ��ȷ��
	double speed = 0;// �����ٶ�
	int level=0;
	public void Mode(String s) {// ѡ��ģʽ�˵�
		System.out.println("***********��ӭ������ɽ������Ϸ***************");
		System.out.println("��ӭ����ð��ģʽ");
		System.out.println("1.��ģʽ");
		System.out.println("2.һ��ģʽ");
		System.out.println("3.����ģʽ");
		System.out.println("4.������һ��");
		System.out.println("����������ѡ��");
		int num = input.nextInt();
		switch (num) {
		case 1:
			Easy(s);
			break;
		case 2:
			if (level >= 1) {
				Normal(s);
			} else {
				System.out.println("�Բ������ĵȼ�����������ͨ����ģʽ");
				Mode(s);
			}

			break;
		case 3:
			if (level >= 2) {
				Hard(s);
			} else {
				System.out.println("�Բ������ĵȼ�����������ͨ��һ��ģʽ");
				Mode(s);
			}

			break;
		case 4:
			break;
		}
	}

	public void Count(String s) {// ����ķ���
		int right = 0;// �Ե���
		int wrong = 0;// �����
		Scanner inputs = new Scanner(System.in);
		System.out.println("������������λ���");
		String str = s;
		System.out.println(str);
		long long1 = System.currentTimeMillis();// ����һ˲�俪ʼ��¼ʱ��
		String in = inputs.nextLine();
		long long2 = System.currentTimeMillis();// ����ʱ��¼ʱ��
		long time = long2 - long1;
		char[] ch1 = str.toCharArray();// ����ת��
		char[] ch2 = in.toCharArray();// ��String��ת����char��
		int b = in.length() > str.length() ? str.length() : in.length();
		for (int i = 0; i < b; i++) {
			if (ch1[i] == ch2[i]) {
				right++;// ��ȷ������1
			} else {
				// wrong++;// ���������1
			}
		}
		try {
			this.accuracy = (right / str.length()) * 100;// ������ȷ��
			this.speed = b / ((time / 1000.0) / 60.0);// �����ٶ�
		} catch (Exception e) {

		}
		System.out.println("���������ʱ�ǣ�" + time / 1000 + "��" + time % 1000 / 10);
		System.out.println("��ȷ���ǣ�" + this.accuracy + "%");
		System.out.println("�����ٶ��ǣ�" + (int) this.speed + "��/����");
	}

	public void Easy(String s) {// ��ģʽ
		System.out.println("***********��ӭ������ģʽ***************");
		Count(s);
		if (this.accuracy > 10 && this.speed > 10) {
			if (this.level < 1) {
				this.level = 1;
			}
			System.out.println("***********��ӭ������ģʽ***************");
			System.out.println("��ϲ��ͨ���˴˹�");
			System.out.println("���ĵȼ�����Ϊ��" + this.level);
			System.out.println("��������ѡ����Ҫ���ģʽ");
			System.out.println("1.��ģʽ");
			System.out.println("2.һ��ģʽ");
			System.out.println("3.����ģʽ");
			System.out.println("4.����ѡ������");
			int num = input.nextInt();
			if (num == 1 && this.level >= 0) {
				Easy(s);
			} else if (num == 2) {
				if (level >= 1) {
					Normal(s);
				} else {
					System.out.println("�Բ������ĵȼ�����");
					Mode(s);
				}

			} else if (num == 3) {
				if (level >= 2) {
					Hard(s);
				}else{
					System.out.println("�Բ������ĵȼ�����");
					Mode(s);
				}
			} else if (num == 4) {
				Game q = new Game();
				q.gameMenu();
			}
		} else {
			System.out.println("***********��ӭ������ģʽ***************");
			System.out.println("�Բ�����δͨ����ģʽ");
			System.out.println("1.������һ��  2.������ģʽ");
			int num = input.nextInt();
			if (num == 1) {
				Mode(s);
			} else if (num == 2) {
				Easy(s);
			}
		}
	}

	public void Normal(String s) {// һ��ģʽ
		System.out.println("***********��ӭ����һ��ģʽ***************");
		Count(s);
		if (this.accuracy > 80 && this.speed > 80) {
			if (this.level < 2) {
				this.level = 2;
			}
			System.out.println("***********��ӭ����һ��ģʽ***************");
			System.out.println("��ϲ��ͨ���˴˹�");
			System.out.println("���ĵȼ�����Ϊ��" + this.level);
			System.out.println("��������ѡ����Ҫ���ģʽ");
			System.out.println("1.��ģʽ");
			System.out.println("2.һ��ģʽ");
			System.out.println("3.����ģʽ");
			System.out.println("4.����ѡ������");
			int num = input.nextInt();
			if (num == 1 && this.level >= 0) {
				Easy(s);
			} else if (num == 2) {
				if (level >= 1) {
					Normal(s);
				} else {
					System.out.println("�Բ������ĵȼ�����");
					Mode(s);
				}

			} else if (num == 3) {
				if (level >= 2) {
					Hard(s);
				} else {				
					System.out.println("�Բ������ĵȼ�����");
					Mode(s);
				}
			} else if (num == 4) {
				Game q = new Game();
				q.gameMenu();
			}
		} else {		
			System.out.println("�Բ�����δͨ����ģʽ");
			System.out.println("1.������һ��  2.������ģʽ");
			int num = input.nextInt();
			if (num == 1) {
				Mode(s);
			} else if (num == 2) {
				Easy(s);
			}
		}
	}

	public void Hard(String s) {// ����ģʽ
		System.out.println("***********��ӭ��������ģʽ***************");
		Count(s);
		if (this.accuracy > 95 && this.speed > 95) {
			if (this.level < 3) {
				this.level = 3;
			}
			System.out.println("***********��ӭ��������ģʽ***************");
			System.out.println("��ϲ��ͨ���˴˹�");
			System.out.println("���ĵȼ�����Ϊ��" + this.level);
			System.out.println("��������ѡ����Ҫ���ģʽ");
			System.out.println("1.��ģʽ");
			System.out.println("2.һ��ģʽ");
			System.out.println("3.����ģʽ");
			System.out.println("4.����ѡ������");
			int num = input.nextInt();
			if (num == 1 && this.level >= 0) {
				Easy(s);
			} else if (num == 2) {
				if (level >= 1) {
					Normal(s);
				} else {
					System.out.println("�Բ������ĵȼ�����");
					Mode(s);
				}

			} else if (num == 3) {
				if (level >= 2) {
					Hard(s);
				} else {
					System.out.println("�Բ������ĵȼ�����");
					Mode(s);
				}
			} else if (num == 4) {
				Game q = new Game();
				q.gameMenu();
			}
		} else {
			System.out.println("�Բ�����δͨ����ģʽ");
			System.out.println("1.������һ��  2.������ģʽ");
			int num = input.nextInt();
			if (num == 1) {
				Mode(s);
			} else if (num == 2) {
				Easy(s);
			}
		}
	}
}