package teamnova_0412;

import java.util.Scanner;

public class 훈련 {
	
	Scanner scan= new Scanner(System.in);
	Thread th= new Thread();
	int time;
	
	public boolean 훈련하기(String 훈련이름) {
		boolean result = false;
		System.out.println(훈련이름+"훈련을 시작합니다.\n");
		long ran= (long)(Math.random()*100000L);
		System.out.println(ran);
		System.out.println("화면에 보이는 숫자를 바르게 입력하세요! (제한시간 5초)");
		System.out.print("남은 시간 : ");
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
		String 훈련;
		//10자리 랜덤값이랑 입력한 숫자가 같으면
		if(time>=0) {
			if(ran==input) {
				th.interrupt();
				훈련= 훈련이름+"훈련에 성공헀습니다!\n\n";
				for(int i=0; i<훈련.length(); i++) {
					try {
						Thread.sleep(50);
						System.out.format("%c", 훈련.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				result=true;
			}else {
				th.interrupt();
				훈련= 훈련이름+"훈련에 실패했습니다...\n\n";
				for(int i=0; i<훈련.length(); i++) {
					try {
						Thread.sleep(50);
						System.out.format("%c", 훈련.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}else {
			th.interrupt();
			훈련= "시간이 초과되어 "+훈련이름+"훈련에 실패했습니다...\n";
			for(int i=0; i<훈련.length(); i++) {
				try {
					Thread.sleep(50);
					System.out.format("%c", 훈련.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
