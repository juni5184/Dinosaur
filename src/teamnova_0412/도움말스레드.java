package teamnova_0412;

public class 도움말스레드 extends Thread {

	//도움말 스레드
	//20초에 한번씩 출력
		@Override
		public void run() {
			int i=0;
			while(true) {
				try {
					Thread.sleep(30000);
					if(i==0) {
						System.out.println("                                                                       "
								+ "==================도움말=================\n\n"
								+ "                                                                                                                                                                    "
								+ "데미지는 \n"
								+ "                                                                        "
								+ "(공격력-20 ~ 공격력 사이의 랜덤 값) – 방어력/10 \n"
								+ "                                                                                                                                                               "
								+ "만큼 입습니다.\r\n\n"  
								+ "                                                                       "
								+ "=======================================");
						i++;
					}else if(i==1) {
						System.out.println("                                                                       "
								+ "==================도움말=================\n\n"
								+ "                                                                                                                                                               "
								+ "사냥을 5번 나가면 \n"
								+ "                                                                                                                                                "
								+ "옷이 낡아서 방어력이 10만큼 감소 됩니다.\r\n\n" 
								+ "                                                                       "+
								"=======================================");
						i++;
					}else if(i==2) {
						System.out.println("                                                                       "
								+ "==================도움말=================\n\n"
								+ "                                                                                                                                                         "
								+ "공룡은 랜덤하게 출현합니다.\r\n\n" +
								"                                                                       "+
								"=======================================");
						i++;
					}else if(i==3) {
						System.out.println("                                                                       "
								+ "==================도움말=================\n\n"
								+"                                                                                                                                              "
								+ "전투 도중 도망은 70프로의 확률로 가능합니다.\n\n"
								+"                                                                       "
								+"=======================================");
						i++;
					}else if(i==4) {
						System.out.println("                                                                       "
								+ "==================도움말=================\n\n"
								+"                                                                                                                                           "
								+ "한번 합성된 채집물은 더 이상 합성할수 없습니다.\n\n"
								+"                                                                       "
								+"=======================================");
						i++;
					}else if(i==5) {
						System.out.println("                                                                       "
								+ "==================도움말=================\n\n"
								+"                                                                                                                                              "
								+ "레벨업을 하면 공격력과 방어력이 10씩 오르고, \n"
								+"                                                                                                                                                        "
								+ "체력은 100으로 돌아옵니다.\r\n\n" + 
								"                                                                       "
								+"=======================================");
						i=0;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

}
