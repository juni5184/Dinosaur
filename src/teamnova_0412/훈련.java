package teamnova_0412;

import java.util.Scanner;

public class �Ʒ� {
	
	Scanner scan= new Scanner(System.in);
	Thread th= new Thread();
	int time;
	
	public boolean �Ʒ��ϱ�(String �Ʒ��̸�) {
		boolean result = false;
		System.out.println(�Ʒ��̸�+"�Ʒ��� �����մϴ�.\n");
		long ran= (long)(Math.random()*100000L);
		System.out.println(ran);
		System.out.println("ȭ�鿡 ���̴� ���ڸ� �ٸ��� �Է��ϼ���! (���ѽð� 5��)");
		System.out.print("���� �ð� : ");
		th= new Thread () {
			
			@Override
			public void run() {
				for(time=5; time>=0; time--) {
					try {
						th.sleep(1000);
						System.out.print(time+" ");
					} catch (InterruptedException e) {
						return;
					}
				}
			
			}
		};
		th.start();
		long input= scan.nextLong();
		System.out.println();
		String �Ʒ�;
		//10�ڸ� �������̶� �Է��� ���ڰ� ������
		if(time>=0) {
			if(ran==input) {
				th.interrupt();
				�Ʒ�= �Ʒ��̸�+"�Ʒÿ� ���������ϴ�!\n\n";
				for(int i=0; i<�Ʒ�.length(); i++) {
					try {
						Thread.sleep(50);
						System.out.format("%c", �Ʒ�.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				result=true;
			}else {
				th.interrupt();
				�Ʒ�= �Ʒ��̸�+"�Ʒÿ� �����߽��ϴ�...\n\n";
				for(int i=0; i<�Ʒ�.length(); i++) {
					try {
						Thread.sleep(50);
						System.out.format("%c", �Ʒ�.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}else {
			th.interrupt();
			�Ʒ�= "�ð��� �ʰ��Ǿ� "+�Ʒ��̸�+"�Ʒÿ� �����߽��ϴ�...\n";
			for(int i=0; i<�Ʒ�.length(); i++) {
				try {
					Thread.sleep(50);
					System.out.format("%c", �Ʒ�.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
