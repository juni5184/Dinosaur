package teamnova_0412;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//시작시 3초의 딜레이를 주는 로딩 쓰레드
		String 로딩 = "로딩중...";
		for(int i=0; i<로딩.length(); i++) {
			try {
				Thread.sleep(500);
				System.out.format("%c", 로딩.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println();
		
		Scanner scan= new Scanner(System.in);
		캐릭터 캐릭터1= new 캐릭터();

		System.out.println("=========================================================\n\n"
				+ "공룡을 사냥해서 경험치를 쌓아 레벨 10까지 도달하세요!\n\n"
				+ "=========================================================\n\n"
				+ "플레이어의 직업을 선택하세요.\n"
				+ "1.사냥꾼(공격력 +20)\n"
				+ "2.도적(방어력 +20)\n"
				+ ("\n기본 능력치 => "
				+ 캐릭터1.능력치보여주기("", 캐릭터1.레벨, 캐릭터1.체력, 캐릭터1.공격력, 캐릭터1.방어력,캐릭터1.코인))
				+ "\n\n=========================================================");
		
		//게임시작시 나오는 BGM 쓰레드
		Music introMusic= new Music("bensound-goinghigher.mp3",true);
		introMusic.start();
		
		//도움말 쓰레드
		//게임에 도움이되는 도움말을 20초마다 띄워준다.
		도움말스레드 thread= new 도움말스레드();
		thread.start();
		
		int 직업= scan.nextInt(); //사냥꾼 or 도적

		if(직업==1) { //사냥꾼
			사냥꾼 사냥꾼1= new 사냥꾼(캐릭터1.체력,캐릭터1.공격력,캐릭터1.방어력,캐릭터1.레벨,캐릭터1.경험치, 캐릭터1.코인);
			String explain="\n사냥꾼을 선택하여 공격력이 높아집니다.\n";
			for(int i=0; i<explain.length(); i++) {
				try {
					Thread.sleep(100);
					System.out.format("%c", explain.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("사냥꾼 "+사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
			System.out.println("\n공룡을 사냥해서 경험치를 쌓아 레벨 10까지 도달하세요.\n");
			System.out.println("=========================================================\n");
			
			int 전투횟수=0; //전투횟수가 5이상이 되면 옷이 낡음
			while(사냥꾼1.레벨!=10) {
				String todo= "무엇을 하시겠습니까?\n";
				for(int i=0; i<todo.length(); i++) {
					try {
						Thread.sleep(100);
						System.out.format("%c", todo.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println( 사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인)
						+ "\n\n1.사냥하러 가기 2.휴식하기 3.아이템 상점 4.훈련하기 5.인벤토리 보기 /0.게임 끝내기");
				
				int 할일= scan.nextInt();
				System.out.println();
				if(할일==1) { //사냥하기
					Music fightMusic= new Music("bensound-epic.mp3",true);
					introMusic.close();
					fightMusic.start();
					
					//날씨에 따라 사냥꾼의 공격력에 영향을 미침
					날씨 날씨= new 날씨();
					사냥꾼1.공격력= 날씨.날씨메소드(사냥꾼1.공격력);
					
					String move="사냥을 하러 이동합니다.";
					for(int i=0; i<move.length(); i++) {
						try {
							Thread.sleep(100);
							System.out.format("%c", move.charAt(i));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println();
					fightMusic.interrupt();
					//공룡발견 스레드
					//공룡을 발견하는데 1~5초 사이의 시간이 걸림
					String find="두리번두리번...";
					int rand= (int)(Math.random()*10);
					for(int i=0; i<find.length(); i++) {
						try {
							Thread.sleep(50*rand);
							System.out.format("%c", find.charAt(i));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println();
					//3마리 공룡 랜덤으로 출현
					int dinor= (int)((Math.random()*10)+1)/3+1;
					while(dinor>3) {
						dinor= (int)((Math.random()*10)+1)/3+1;
					}
					int attack;
					//공룡 종류 3마리
					//티라노사우르스, 트리케라톱스, 브라키오사우르스
					if(dinor==1) {
						System.out.println("        ,\r\n" + 
								"       /|\r\n" + 
								"      / |\r\n" + 
								"     /  /\r\n" + 
								"    |   |\r\n" + 
								"   /    |\r\n" + 
								"   |    \\_\r\n" + 
								"   |      \\__\r\n" + 
								"   \\       __\\_______\r\n" + 
								"    \\                 \\_\r\n" + 
								"    | /                 \\\r\n" + 
								"    \\/                   \\\r\n" + 
								"     |                    |\r\n" + 
								"     \\                   \\|\r\n" + 
								"     |                    \\\r\n" + 
								"     \\                     |\r\n" + 
								"     /\\    \\_               \\\r\n" + 
								"    / |      \\__ (   )       \\\r\n" + 
								"   /  \\      / |\\\\  /       __\\____\r\n" + 
								"   |  ,     |  /\\ \\ \\__    |       \\_\r\n" + 
								"   \\_/|\\___/   \\   \\}}}\\__|  (@)     )\r\n" + 
								"    \\)\\)\\)      \\_\\---\\   \\|       \\ \\\r\n" + 
								"                  \\>\\>\\>   \\   /\\__o_o)\r\n" + 
								"                            | /  VVVVV\r\n" + 
								"                            \\ \\    \\\r\n" + 
								"                             \\ \\MMMMM\n"+ 
								"                              \\______/ ");
						티라노 티라노1= new 티라노("티라노사우르스",100,70,30,5,10,5);
						System.out.println(티라노1.이름+"가 나타습니다!\n"
										+티라노1.능력치보여주기(티라노1.이름, 0, 티라노1.체력, 티라노1.공격력, 티라노1.방어력, 티라노1.코인));
						System.out.println("\n=========================================================\n");
						Thread fight = new Thread(new Runnable() {
							@Override
							public void run() {
								while(티라노1.체력!=0&&사냥꾼1.체력!=0) {
									try {
										//3초에 한번씩 물어뜯기
										//캐릭터가 가만히 있어도 공룡이 선제공격함
										Thread.sleep(3000);
										System.out.println();
										사냥꾼1.체력= 티라노1.물어뜯기(티라노1.이름,사냥꾼1.체력,티라노1.공격력,사냥꾼1.방어력,"사냥꾼");
										System.out.println("사냥꾼 "+사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
										if(사냥꾼1.체력<=0) {
											//캐릭터의 체력이 0미만이 되면 멈춤
											String die="\n사냥꾼의 체력이 0이 되었습니다...";
											break;
										}
									} catch (InterruptedException e) {
										return;
									}
								}
								System.out.println();
							}
						}); 
						fight.start();
					
						System.out.println("\n공격하시겠습니까? 1.공격한다 2.도망친다");
						attack= scan.nextInt();
						if(attack==1) {
							System.out.println("\n=========================================================\n");
							//yes or no
							//사망시 부활할지 말지를 선택
							int yn=0;
							
							while(티라노1.체력>0) {//전투 while
								
								if(사냥꾼1.체력>0) { //캐릭터차례
									
									System.out.println("\n무슨 공격을 하시겠습니까?");
									System.out.println("1.총쏘기 2.가죽 벗기기 3.물약먹기("+사냥꾼1.물약갯수+") 4.도망치기");
									System.out.println();
									//무슨 공격을 할지 선택
									int what= scan.nextInt();
									if(what==1) {
										사냥꾼1.총쏘기();
										티라노1.체력= 티라노1.데미지(티라노1.이름,티라노1.체력,사냥꾼1.공격력, 티라노1.방어력);
										System.out.println(티라노1.능력치보여주기(티라노1.이름, 0, 티라노1.체력, 티라노1.공격력, 티라노1.방어력, 티라노1.코인)+"\n");
									}else if(what==2) {
										사냥꾼1.가죽갯수= 사냥꾼1.가죽벗기기(티라노1.이름, 사냥꾼1.가죽갯수);
										티라노1.체력= 티라노1.데미지(티라노1.이름,티라노1.체력,사냥꾼1.공격력, 티라노1.방어력);
										System.out.println(티라노1.능력치보여주기(티라노1.이름, 0, 티라노1.체력, 티라노1.공격력, 티라노1.방어력, 티라노1.코인)+"\n");
									}else if(what==3) {
										물약 물약1= new 물약();
										사냥꾼1.체력= 물약1.물약먹기(사냥꾼1.체력, "사냥꾼");
										if(사냥꾼1.물약갯수>0) {
											사냥꾼1.물약갯수--;
										}else {
											System.out.println("물약이 없습니다. 물약은 상점에서 구매하세요.\n");
										}
									}else if(what==4) {
										int 도망= (int)(Math.random()*10);
										String run;
										if(도망>3) {
											fight.interrupt();
											run= "\n도망 쳤습니다...";
											for(int i=0; i<run.length(); i++) {
												try {
													Thread.sleep(200);
													System.out.format("%c", run.charAt(i));
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
											}
											yn=1;
											break;
										}else {
											run= "도망에 실패했습니다. 계속 싸우세요!!!\n";
											System.out.println(run);
										}
									}
									티라노1.도망여부= 티라노1.도망가기("티라노사우르스", 티라노1.체력);
									if(티라노1.도망여부==true) {
										fight.interrupt();
										break;
									}
									
									if(티라노1.체력<=0) {
										fight.interrupt();
										System.out.println("=========================================================\n");
										System.out.println("티라노사우르스를 처치했습니다.\n");
									}
								}else {
									fight.interrupt();
									String die="\n사냥꾼이 사망했습니다...";
									for(int i=0; i<die.length(); i++) {
										try {
											Thread.sleep(200);
											System.out.format("%c", die.charAt(i));
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
									yn= scan.nextInt();
									if(yn==1) {
										//다시시작
										사냥꾼1.부활하기();
										System.out.println("사냥꾼 "+사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
										break;
									}else {
										System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
										int input= scan.nextInt();
										if(input==1) {
											System.out.println("게임을 종료합니다.");
											System.exit(0);
										}else {
											System.out.println("게임을 계속 진행합니다.\n");
										}
									}
								}
							}
							//부활한것도 아니고 티라노가 도망간것도 아니면
							//경험치부여, 레벨업 진행
							if(yn!=1&&티라노1.도망여부!=true) {
								사냥꾼1.경험치= 사냥꾼1.경험치상승(티라노1.경험치부여);
								사냥꾼1.코인= 사냥꾼1.코인상승(사냥꾼1.코인,티라노1.코인);
								if(사냥꾼1.경험치>=10){
									System.out.println(사냥꾼1.레벨상승(사냥꾼1.레벨, 사냥꾼1.경험치, 사냥꾼1.체력, 사냥꾼1.공격력));
									사냥꾼1.경험치= 사냥꾼1.경험치-10;
									사냥꾼1.레벨++;
									사냥꾼1.체력=100;
									사냥꾼1.공격력= 사냥꾼1.공격력+10;
								}
							}
						}else if(attack==2){
							//싸우시겠습니까? 에서 도망
							fight.interrupt();
							System.out.println("도망쳤습니다.");
						}
						
					}else if(dinor==2) {
						트리케라톱스 트리케라톱스1= new 트리케라톱스("트리케라톱스",150,50,50,8,15,6);
						System.out.println("                            __.--'~~~~~`--.\r\n" + 
								"         ..       __.    .-~               ~-.\r\n" + 
								"         ((\\     /   `}.~                     `.\r\n" + 
								"          \\\\\\  .{     }               /     \\   \\\r\n" + 
								"      (\\   \\\\~~       }              |       }   \\\r\n" + 
								"       \\`.-~ -@~     }  ,-,.         |       )    \\\r\n" + 
								"       (___     ) _}  (    :        |    / /      `._\r\n" + 
								"        `----._-~.     _\\ \\ |_       \\   / /-.__     `._\r\n" + 
								"               ~~----~~  \\ \\| ~~--~~~(  + /     ~-._    ~-._\r\n" + 
								"                         /  /         \\  \\          ~--.,___~_-_.\r\n" + 
								"                      __/  /          _\\  )\r\n" + 
								"                    .<___.'         .<___/" + 
								"");
						
						System.out.println(트리케라톱스1.이름+"가 나타났습니다!\n"
								+ 트리케라톱스1.능력치보여주기(트리케라톱스1.이름, 0, 트리케라톱스1.체력, 트리케라톱스1.공격력, 트리케라톱스1.방어력, 트리케라톱스1.코인));
						System.out.println("\n=========================================================\n");
						//공룡 선제 공격
						Thread fight = new Thread(new Runnable() {
							@Override
							public void run() {
								while(트리케라톱스1.체력!=0&&사냥꾼1.체력!=0) {
									try {
										//2.5초에 한번씩 돌진
										Thread.sleep(3500);
										System.out.println();
										사냥꾼1.체력= 트리케라톱스1.돌진(트리케라톱스1.이름,사냥꾼1.체력,트리케라톱스1.공격력,사냥꾼1.방어력,"사냥꾼");
										System.out.println("사냥꾼 "+사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
										if(사냥꾼1.체력<=0) {
											String die="\n사냥꾼의 체력이 0이 되었습니다...";
											break;
										}
									} catch (InterruptedException e) {
										return;
									}
								}
								System.out.println();
							}
						}); 
						fight.start();
						
						
						System.out.println("\n공격하시겠습니까? 1.공격한다 2.도망친다");
						attack= scan.nextInt();
						if(attack==1) {
							System.out.println("\n공격을 시작합니다.");
							System.out.println("\n=========================================================\n");
							int yn=0;
							while(트리케라톱스1.체력>0) {//전투 while
								if(사냥꾼1.체력>0) {
									System.out.println("\n무슨 공격을 하시겠습니까?");
									System.out.println("1.총쏘기 2.가죽 벗기기 3.물약먹기("+사냥꾼1.물약갯수+") 4.도망치기");
									int what= scan.nextInt();
									if(what==1) {
										사냥꾼1.총쏘기();
										트리케라톱스1.체력= 트리케라톱스1.데미지(트리케라톱스1.이름,트리케라톱스1.체력,사냥꾼1.공격력, 트리케라톱스1.방어력);
										System.out.println(트리케라톱스1.능력치보여주기(트리케라톱스1.이름, 0, 트리케라톱스1.체력, 트리케라톱스1.공격력, 트리케라톱스1.방어력, 트리케라톱스1.코인)+"\n");
									}else if(what==2) {
										사냥꾼1.가죽갯수= 사냥꾼1.가죽벗기기(트리케라톱스1.이름, 사냥꾼1.가죽갯수);
										트리케라톱스1.체력= 트리케라톱스1.데미지(트리케라톱스1.이름,트리케라톱스1.체력,사냥꾼1.공격력, 트리케라톱스1.방어력);
										System.out.println(트리케라톱스1.능력치보여주기(트리케라톱스1.이름, 0, 트리케라톱스1.체력, 트리케라톱스1.공격력, 트리케라톱스1.방어력, 트리케라톱스1.코인)+"\n");
									}else if(what==3) {
										물약 물약1= new 물약();
										if(사냥꾼1.물약갯수>0) {
											사냥꾼1.체력= 물약1.물약먹기(사냥꾼1.체력, "사냥꾼");
											사냥꾼1.물약갯수--;
										}else {
											System.out.println("물약이 없습니다. 물약은 상점에서 구매하세요.\n");
										}
									}else if(what==4) {
										int 도망= (int)(Math.random()*10);
										String run;
										if(도망>3) {
											fight.interrupt();
											run= "\n도망 쳤습니다...";
											for(int i=0; i<run.length(); i++) {
												try {
													Thread.sleep(200);
													System.out.format("%c", run.charAt(i));
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
											}
											yn=1;
											break;
										}else {
											run= "도망에 실패했습니다. 계속 싸우세요!!!\n";
											System.out.println(run);
										}
									}
									
									트리케라톱스1.도망여부= 트리케라톱스1.도망가기("트리케라톱스", 트리케라톱스1.체력);
									if(트리케라톱스1.도망여부==true) {
										fight.interrupt();
										break;
									}
									
									if(트리케라톱스1.체력<=0) {
										fight.interrupt();
										System.out.println("=========================================================\n");
										System.out.println("트리케라톱스를 처치했습니다.\n");
									}
								}else {
									fight.interrupt();
									String die="\n사냥꾼이 사망했습니다...";
									for(int i=0; i<die.length(); i++) {
										try {
											Thread.sleep(200);
											System.out.format("%c", die.charAt(i));
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
									yn= scan.nextInt();
									if(yn==1) {
										//다시시작
										사냥꾼1.부활하기();
										System.out.println("사냥꾼 "+사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
										break;
									}else {
										System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
										int input= scan.nextInt();
										if(input==1) {
											System.out.println("게임을 종료합니다.");
											System.exit(0);
										}else {
											System.out.println("게임을 계속 진행합니다.\n");
										}
									}
								}
							}
							if(yn!=1&&트리케라톱스1.도망여부!=true) { //부활한게 아니면
								사냥꾼1.경험치= 사냥꾼1.경험치상승(트리케라톱스1.경험치부여);
								사냥꾼1.코인= 사냥꾼1.코인상승(사냥꾼1.코인,트리케라톱스1.코인);
								if(사냥꾼1.경험치>=10){
									System.out.println(사냥꾼1.레벨상승(사냥꾼1.레벨, 사냥꾼1.경험치, 사냥꾼1.체력, 사냥꾼1.공격력));
									사냥꾼1.경험치= 사냥꾼1.경험치-10;
									사냥꾼1.레벨++;
									사냥꾼1.체력=100;
									사냥꾼1.공격력= 사냥꾼1.공격력+10;
								}
							}
						}else if(attack==2){
							fight.interrupt();
							System.out.println("도망쳤습니다.");
						}
						
					}else if(dinor==3) {
						System.out.println("         _\r\n" + 
								"       .~q`,\r\n" + 
								"      {__,  \\\r\n" + 
								"          \\' \\\r\n" + 
								"           \\  \\\r\n" + 
								"            \\  \\\r\n" + 
								"             \\  `._            __.__\r\n" + 
								"              \\    ~-._  _.==~~     ~~--.._\r\n" + 
								"               \\        '                  ~-.\r\n" + 
								"                \\      _-   -_                `.\r\n" + 
								"                 \\    /       }        .-    .  \\\r\n" + 
								"                  `. |      /  }      (       ;  \\\r\n" + 
								"                    `|     /  /       (       :   '\\\r\n" + 
								"                     \\    |  /        |      /       \\\r\n" + 
								"                      |     /`-.______.\\     |~-.      \\\r\n" + 
								"                      |   |/           (     |   `.      \\_\r\n" + 
								"                      |   ||            ~\\   \\      '._    `-.._____..----..___\r\n" + 
								"                      |   |/             _\\   \\         ~-.__________.-~~~~~~~~~'''\r\n" + 
								"                    .o'___/            .o______}\r\n" );
						브라키오 브라키오1= new 브라키오("브라키오사우르스",200,60,70,10,20,7);
						System.out.println(브라키오1.이름+"가 나타났습니다!\n"
								+ 브라키오1.능력치보여주기(브라키오1.이름, 0, 브라키오1.체력, 브라키오1.공격력, 브라키오1.방어력, 브라키오1.코인));
						System.out.println("\n=========================================================\n");
						//공룡 선제 공격
						Thread fight = new Thread(new Runnable() {
							@Override
							public void run() {
								while(브라키오1.체력!=0&&사냥꾼1.체력!=0) {
									try {
										//3.5초에 한번씩 꼬리공격
										Thread.sleep(3500);
										System.out.println();
										사냥꾼1.체력= 브라키오1.꼬리공격(브라키오1.이름,사냥꾼1.체력,브라키오1.공격력,사냥꾼1.방어력,"사냥꾼");
										System.out.println("사냥꾼 "+사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
										if(사냥꾼1.체력<=0) {
											String die="\n사냥꾼의 체력이 0이 되었습니다...";
											break;
										}
									} catch (InterruptedException e) {
										return;
									}
								}
								System.out.println();
							}
						}); 
						fight.start();
						
						System.out.println("\n공격하시겠습니까? 1.공격한다 2.도망친다");
						attack= scan.nextInt();
						if(attack==1) {
							System.out.println("\n공격을 시작합니다.");
							System.out.println("\n=========================================================\n");
							int yn=0;
							while(브라키오1.체력>0) {//전투 while
								if(사냥꾼1.체력>0) {
									System.out.println("\n무슨 공격을 하시겠습니까?");
									System.out.println("1.총쏘기 2.가죽 벗기기 3.물약먹기("+사냥꾼1.물약갯수+") 4.도망치기");
									int what= scan.nextInt();
									if(what==1) {
										사냥꾼1.총쏘기();
										브라키오1.체력= 브라키오1.데미지(브라키오1.이름,브라키오1.체력,사냥꾼1.공격력, 브라키오1.방어력);
										System.out.println(브라키오1.능력치보여주기(브라키오1.이름, 0, 브라키오1.체력, 브라키오1.공격력, 브라키오1.방어력, 브라키오1.코인)+"\n");
									}else if(what==2) {
										사냥꾼1.가죽갯수=사냥꾼1.가죽벗기기(브라키오1.이름, 사냥꾼1.가죽갯수);
										브라키오1.체력= 브라키오1.데미지(브라키오1.이름,브라키오1.체력,사냥꾼1.공격력, 브라키오1.방어력);
										System.out.println(브라키오1.능력치보여주기(브라키오1.이름, 0, 브라키오1.체력, 브라키오1.공격력, 브라키오1.방어력, 브라키오1.코인)+"\n");
									}else if(what==3) {
										물약 물약1= new 물약();
										if(사냥꾼1.물약갯수>0) {
											사냥꾼1.체력= 물약1.물약먹기(사냥꾼1.체력, "사냥꾼");
											사냥꾼1.물약갯수--;
										}else {
											System.out.println("물약이 없습니다. 물약은 상점에서 구매하세요.\n");
										}
									}else if(what==4) {
										int 도망= (int)(Math.random()*10);
										String run;
										if(도망>3) {
											fight.interrupt();
											run= "\n도망 쳤습니다...";
											for(int i=0; i<run.length(); i++) {
												try {
													Thread.sleep(200);
													System.out.format("%c", run.charAt(i));
												} catch (InterruptedException e) {
													e.printStackTrace();
												}
											}
											yn=1;
											break;
										}else {
											run= "도망에 실패했습니다. 계속 싸우세요!!!\n";
											System.out.println(run);
										}
									}
									
									브라키오1.도망여부= 브라키오1.도망가기("브라키오사우르스", 브라키오1.체력);
									if(브라키오1.도망여부==true) {
										fight.interrupt();
										break;
									}
									
									if(브라키오1.체력<=0) {
										System.out.println("=========================================================\n");
										System.out.println("브라키오사우르스를 처치했습니다.\n");
										fight.interrupt();
									}
								}else {
									fight.interrupt();
									String die="\n사냥꾼이 사망했습니다...";
									for(int i=0; i<die.length(); i++) {
										try {
											Thread.sleep(200);
											System.out.format("%c", die.charAt(i));
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
									yn= scan.nextInt();
									if(yn==1) {
										//다시시작
										사냥꾼1.부활하기();
										System.out.println("사냥꾼 "+사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
										break;
									}else {
										System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
										int input= scan.nextInt();
										if(input==1) {
											System.out.println("게임을 종료합니다.");
											System.exit(0);
										}else {
											System.out.println("게임을 계속 진행합니다.\n");
										}
									}
								}
							}
							if(yn!=1&&브라키오1.도망여부!=true) { //부활한게 아니면
								사냥꾼1.경험치= 사냥꾼1.경험치상승(브라키오1.경험치부여);
								사냥꾼1.코인= 사냥꾼1.코인상승(사냥꾼1.코인,브라키오1.코인);
								if(사냥꾼1.경험치>=10){
									System.out.println(사냥꾼1.레벨상승(사냥꾼1.레벨, 사냥꾼1.경험치, 사냥꾼1.체력, 사냥꾼1.공격력));
									사냥꾼1.경험치= 사냥꾼1.경험치-10;
									사냥꾼1.레벨++;
									사냥꾼1.체력=100;
									사냥꾼1.공격력= 사냥꾼1.공격력+10;
								}
							}
						}else if(attack==2){
							fight.interrupt();
							System.out.println("도망쳤습니다.");
						}
					}
					전투횟수++;
					if(전투횟수==5) {
						사냥꾼1.방어력= 사냥꾼1.방어력-10;
						System.out.println("\n=========================================================");
						System.out.println("\n전투를 5회 진행하여 옷이 낡았습니다...\n방어력이 10 떨어집니다.");
						전투횟수=0;
					}
					introMusic= new Music("bensound-goinghigher.mp3",true);
					fightMusic.close();
					introMusic.start();
				}else if(할일 ==2) { //휴식하기
					Music restMusic= new Music("bensound-love.mp3",true);
					introMusic.close();
					restMusic.start();
					while(true) {
						System.out.println("=========================================================\n");
						String rest1= "어떻게 휴식할지 선택하세요.\n";
						for(int i=0; i<rest1.length(); i++) {
							try {
								Thread.sleep(50);
								System.out.format("%c", rest1.charAt(i));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("1.일반휴식(체력 +10) 2.물약사용(갯수:"+사냥꾼1.물약갯수+")(체력+30) / 0.나가기");
						int rest= scan.nextInt();
						//어떻게 휴식할지 선택
						while(rest!=0) { //나가기
							if(rest==1) {
								사냥꾼1.체력= 사냥꾼1.휴식하기(사냥꾼1.체력);	
								System.out.println(사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
								break;
							}else if(rest==2) {
								물약 물약1= new 물약();
								if(사냥꾼1.물약갯수>0) {
									사냥꾼1.체력= 물약1.물약먹기(사냥꾼1.체력, "사냥꾼");
									System.out.println(사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
									사냥꾼1.물약갯수--;
								}else {
									String buy="\n물약이 없습니다. 상점에서 물약을 구매하세요.\n";
									for(int i=0; i<buy.length(); i++) {
										try {
											Thread.sleep(100);
											System.out.format("%c", buy.charAt(i));
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
								}
								break;
							}else {
								System.out.println("\n휴식방법을 제대로 선택하세요.");
								break;
							}
						}
						break;
					}
					introMusic= new Music("bensound-goinghigher.mp3",true);
					restMusic.close();
					introMusic.start();
				}else if(할일 ==3) { //아이템 구매
					Music storeMusic= new Music("bensound-cute.mp3",true);
					introMusic.close();
					storeMusic.start();
					String move="아이템 상점으로 이동합니다.\n";
					for(int i=0; i<move.length(); i++) {
						try {
							Thread.sleep(100);
							System.out.format("%c", move.charAt(i));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("\n=========================================================\n");
					System.out.println("상점에서는 물약을 구매할 수 있고, 무기와 방어구를 업그레이드 시킬 수 있습니다.\n"
							+ "물약은 캐릭터가 소지하게 되고 전투에서 사용가능합니다.\n"
							+ "무기,방어구는 각각 공격력,방어력을 높여줍니다.\n\n"
							+ "구매한 무기와 방어구는 즉시 업그레이드됩니다.");
					while(true) {
						System.out.println("\n=========================================================\n");
						System.out.println("무엇을 하시겠습니까? 1.구매 2.판매 / 0.나가기");
						int 상점 = scan.nextInt();
						if(상점==1) { //구매
							System.out.println("\n무엇을 구매하시겠습니까? 현재코인 : "+사냥꾼1.코인+"\n");
							System.out.println("1.물약(5코인) 2.무기(10코인) 3.방어구(5코인) / 0.나가기");
								int 구매= scan.nextInt();
								if(구매==1) {
									System.out.println("\n물약을 구매하시겠습니까? 1.네/2.아니요");
									구매= scan.nextInt();
									if(구매==1) {
										if(사냥꾼1.코인>=5) {
											if(사냥꾼1.물약갯수<=10) {
												물약 물약1= new 물약();
												System.out.println("물약을 구매합니다.\n");
												사냥꾼1.코인=물약1.구매("물약", 5, 사냥꾼1.코인);
												사냥꾼1.물약갯수=물약1.물약소지(사냥꾼1.물약갯수, "사냥꾼");
												System.out.println(사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
											}else {
												System.out.println("가방이 꽉 찼습니다. 아이템을 더 이상 구매할 수 없습니다.");
											}
										}else {
											System.out.println("돈이 부족합니다.\n공룡을 사냥하면 코인을 얻을 수 있습니다.");
											break;
										}
									}else {
										System.out.println("\n물약을 구매하지 않았습니다.");
										
									}
								}else if(구매==2) {
									System.out.println("\n무기를 구매하시겠습니까? 1.네/2.아니요");
									구매= scan.nextInt();
									if(구매==1) {
										if(사냥꾼1.코인>=10) {
											무기 무기1= new 무기();
											사냥꾼1.코인=무기1.구매("무기", 10, 사냥꾼1.코인);
											사냥꾼1.공격력= 무기1.공격력상승(사냥꾼1.공격력);
											System.out.println(사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
										}else {
											System.out.println("돈이 부족합니다.\n공룡을 사냥하면 코인을 얻을 수 있습니다.");
											break;
										}
									}else {
										System.out.println("\n무기를 구매하지 않았습니다.");
									}
								}else if(구매==3) {
									System.out.println("\n방어구를 구매하시겠습니까? 1.네/2.아니요");
									구매= scan.nextInt();
									if(구매==1) {
										if(사냥꾼1.코인>=5) {
											방어구 방어구1 = new 방어구();
											사냥꾼1.코인=방어구1.구매("방어구", 5, 사냥꾼1.코인);
											사냥꾼1.방어력=방어구1.방어력상승(사냥꾼1.방어력);
											System.out.println(사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
										}else {
											System.out.println("돈이 부족합니다.\n공룡을 사냥하면 코인을 얻을 수 있습니다.");
											break;
										}
									}else {
										System.out.println("\n방어구를 구매하지 않았습니다.");
									}
								}else {
									String out= "\n상점을 나갑니다.\n";
									for(int i=0; i<out.length(); i++) {
										try {
											Thread.sleep(100);
											System.out.format("%c", out.charAt(i));
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
									}
									break;
								
								}
						}else if(상점==2) {//물건 판매
							String sell= "\n아이템을 판매합니다.\n";
							for(int i=0; i<sell.length(); i++) {
								try {
									Thread.sleep(100);
									System.out.format("%c", sell.charAt(i));
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							티라노 티라노1= new 티라노("티라노사우르스",100,70,30,5,10,5);
							트리케라톱스 트리케라1= new 트리케라톱스("트리케라톱스",150,50,50,8,15,6);
							브라키오 브라키오1= new 브라키오("브라키오사우르스",200,60,70,10,20,7); 
							System.out.println("\n판매할 물건의 인덱스를 선택하세요. / 0.나가기");
							사냥꾼1.채집물인벤출력("가죽",사냥꾼1.가죽갯수);
							System.out.println();
							int 가죽= (scan.nextInt())-1;
							if(가죽==-1) {
								System.out.println("\n판매를 끝냅니다.");
								break;
							}
							
							System.out.println("\n"+(가죽+1)+"."+사냥꾼1.list.get(가죽)+"을 판매할까요? 1.네 2.아니오");
							int yn2= scan.nextInt();
							if(yn2==1) {
								사냥꾼1.가죽갯수--;
								if(사냥꾼1.list.get(가죽).equals("티라노사우르스 가죽")) {
									사냥꾼1.코인= 사냥꾼1.채집물판매(가죽, 사냥꾼1.코인, 티라노1.채집물코인);
								}else if(사냥꾼1.list.get(가죽).equals("트리케라톱스 가죽")) {
									사냥꾼1.코인= 사냥꾼1.채집물판매(가죽, 사냥꾼1.코인, 트리케라1.채집물코인);
								}else if(사냥꾼1.list.get(가죽).equals("브라키오사우르스 가죽")) {
									사냥꾼1.코인= 사냥꾼1.채집물판매(가죽, 사냥꾼1.코인, 브라키오1.채집물코인);
								}else if(사냥꾼1.list.get(가죽).equals("큰 합성가죽")) {
									//큰 합성가죽 15코인
									사냥꾼1.코인= 사냥꾼1.채집물판매(가죽, 사냥꾼1.코인, 15);
								}
							}else if(yn2==2) {
								System.out.println(사냥꾼1.list.get(가죽)+"\n가죽을 판매하지 않았습니다.");
							}
						
						}else if(상점==0) {
							String out= "\n상점을 나갑니다.\n";
							for(int i=0; i<out.length(); i++) {
								try {
									Thread.sleep(100);
									System.out.format("%c", out.charAt(i));
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							break;
						}
					}
					introMusic= new Music("bensound-goinghigher.mp3",true);
					storeMusic.close();
					introMusic.start();
				}else if(할일==4) {//훈련하기
					Music workMusic= new Music("bensound-highoctane.mp3",true);
					introMusic.close();
					workMusic.start();
					훈련 훈련1= new 훈련();
					String move="훈련을 위해 훈련장으로 이동합니다.\n";
					for(int i=0; i<move.length(); i++) {
						try {
							Thread.sleep(100);
							System.out.format("%c", move.charAt(i));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("\n=========================================================\n");
					System.out.println("훈련장에서는 사냥훈련, 회피훈련을 할 수 있습니다.\n"
							+ "사냥훈련과 회피훈련은 체력을 소모하여 공격력과 방어력을 올려줍니다.\n");
					System.out.println("=========================================================");
					while(true) {
						String work="\n무슨 훈련을 하시겠습니까?\n";
						for(int i=0; i<work.length(); i++) {
							try {
								Thread.sleep(100);
								System.out.format("%c", work.charAt(i));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("1.사냥 훈련(공격력상승) 2.회피 훈련(방어력상승)/ 0.나가기");
						//훈련종류 선택
						int 종류= scan.nextInt();
						System.out.println();
						if(종류==1) {//사냥훈련
							사냥훈련 사냥1= new 사냥훈련();
							if(훈련1.훈련하기("사냥")==true) {
								사냥꾼1.공격력=사냥1.공격력상승(사냥꾼1.공격력);
							}
							사냥꾼1.체력= 사냥꾼1.체력-10;
							System.out.println(사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
							
							//훈련하다가 체력을 모두 소진해서 사망하는 경우
							if(사냥꾼1.체력<=0) {
								String die="\n사냥꾼이 사망했습니다...";
								for(int i=0; i<die.length(); i++) {
									try {
										Thread.sleep(200);
										System.out.format("%c", die.charAt(i));
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
								int yn= scan.nextInt();
								if(yn==1) {
									//다시시작
									사냥꾼1.부활하기();
									System.out.println("사냥꾼 "+사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
									break;
								}else {
									System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
									int input= scan.nextInt();
									if(input==1) {
										System.out.println("게임을 종료합니다.");
										System.exit(0);
									}else {
										System.out.println("게임을 계속 진행합니다.\n");
									}
								}
							}
						}else if(종류==2) {//회피훈련
							회피훈련 회피1= new 회피훈련();
							if(훈련1.훈련하기("회피")==true) {
								사냥꾼1.방어력= 회피1.방어력상승(사냥꾼1.방어력);
							}
							사냥꾼1.체력= 사냥꾼1.체력-10;
							System.out.println(사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
							if(사냥꾼1.체력<=0) {
								String die="\n사냥꾼이 사망했습니다...";
								for(int i=0; i<die.length(); i++) {
									try {
										Thread.sleep(200);
										System.out.format("%c", die.charAt(i));
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
								int yn= scan.nextInt();
								if(yn==1) {
									//다시시작
									사냥꾼1.부활하기();
									System.out.println("사냥꾼 "+사냥꾼1.능력치보여주기("", 사냥꾼1.레벨, 사냥꾼1.체력, 사냥꾼1.공격력, 사냥꾼1.방어력, 사냥꾼1.코인));
									break;
								}else {
									System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
									int input= scan.nextInt();
									if(input==1) {
										System.out.println("게임을 종료합니다.");
										System.exit(0);
									}else {
										System.out.println("게임을 계속 진행합니다.\n");
									}
								}
							}
						}else {
							String out= "훈련장을 나갑니다...";
							for(int i=0; i<out.length(); i++) {
								try {
									Thread.sleep(100);
									System.out.format("%c", out.charAt(i));
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							break;
						}
					}
					introMusic= new Music("bensound-goinghigher.mp3",true);
					workMusic.close();
					introMusic.start();
				}else if(할일==5){//인벤토리 보기
					//인벤토리에는 사냥할때 얻은 가죽, 발톱이 들어감
					System.out.println("\n=========================================================\n");
					if(사냥꾼1.list.size()==0) {
						System.out.println("인벤토리에 아무것도 없습니다...");
						
					}else {
						String list= "인벤토리를 출력합니다.\n";
						for(int i=0; i<list.length(); i++) {
							try {
								Thread.sleep(30);
								System.out.format("%c", list.charAt(i));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						사냥꾼1.채집물인벤출력("가죽", 사냥꾼1.가죽갯수);
						System.out.println("\n=========================================================\n");
						
						System.out.println( "일반 가죽이 2개 이상 있으면 가죽합성을 할 수 있습니다."
								+ "\n이미 합성된 가죽은 합성재료로 사용할 수 없습니다.");
						System.out.println("\n=========================================================\n");
						
						if(사냥꾼1.가죽갯수>=2) {
							System.out.println("가죽 합성을 하시겠습니까? 1.네 2.아니오");
							int yn3= scan.nextInt();
							if(yn3==1) {
								String mix= "\n합성에 사용할 가죽을 2가지 선택하세요.\n\n";
								for(int i=0; i<mix.length(); i++) {
									try {
										Thread.sleep(30);
										System.out.format("%c", mix.charAt(i));
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								사냥꾼1.채집물인벤출력("가죽", 사냥꾼1.가죽갯수);
								System.out.println();
								int 가죽1, 가죽2;
								while(true) {
								가죽1= scan.nextInt();
									if(사냥꾼1.list.get(가죽1-1).equals("큰 합성가죽")) {
										System.out.println("이미 합성된 가죽입니다.");
										break;
									}else {
										System.out.println(가죽1+"."+사냥꾼1.list.get(가죽1-1)+"을 선택했습니다.");
										break;
									}
								}
								
								while(true) {
									가죽2= scan.nextInt();
									if(사냥꾼1.list.get(가죽2-1).equals("큰 합성가죽")) {
										System.out.println("이미 합성된 가죽입니다.");
										break;
									}else if(가죽1==가죽2) {
										System.out.println("이미 선택된 가죽입니다.");
									}else {
										System.out.println(가죽2+"."+사냥꾼1.list.get(가죽2-1)+"을 선택했습니다.");
										사냥꾼1.가죽갯수= 사냥꾼1.합성하기(가죽1-1, 가죽2-2, 사냥꾼1.가죽갯수,"가죽");
										break;
									}
								}
							}else if(yn3==2) {
								String out= "인벤토리를 나갑니다...\n";
								for(int i=0; i<out.length(); i++) {
									try {
										Thread.sleep(100);
										System.out.format("%c", out.charAt(i));
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}
						}
					
					}
				}else {
				
					System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
					int input= scan.nextInt();
					if(input==1) {
						System.out.println("게임을 종료합니다.");
						System.exit(0);
					}else {
						System.out.println("게임을 계속 진행합니다.\n");
					}
				}
				System.out.println("\n=========================================================\n");
			}
			
			//레벨이 10이 되었다!
			introMusic.close();
			Music finishMusic= new Music("bensound-anewbeginning.mp3",true);
			finishMusic.start();
			String congraturation= "레벨이 10이 되었습니다!\n"+
					"                                   .''.       \r\n" + 
					"       .''.      .        *''*    :_\\/_:     . \r\n" + 
					"      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\r\n" + 
					"  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\r\n" + 
					" :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\r\n" + 
					" : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\r\n" + 
					"  '..'  ':::'     * /\\ *     .'/.\\'.   '\r\n" + 
					"      *            *..*         :\r\n" + 
					"        *\r\n" + 
					"        *\n"
					+ "\n=========================================================\n";
					for(int i=0; i<congraturation.length(); i++) {
						try {
							Thread.sleep(3);
							System.out.format("%c", congraturation.charAt(i));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
			System.out.println("축하합니다!!");
			System.out.println("목표 레벨을 달성했습니다. 게임을 종료합니다.");
		}
		
		//도적
		else if(직업==2) { 
			도적 도적1= new 도적(캐릭터1.체력,캐릭터1.공격력,캐릭터1.방어력,캐릭터1.레벨,캐릭터1.경험치, 캐릭터1.코인);
			String explain="\n도적을 선택하여 방어력이 높아집니다.\n";
			for(int i=0; i<explain.length(); i++) {
				try {
					Thread.sleep(100);
					System.out.format("%c", explain.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		System.out.println("도적 "+도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
		System.out.println("\n공룡을 사냥해서 경험치를 쌓아 레벨 10까지 도달하세요.\n");
		System.out.println("=========================================================\n");
		
		int 전투횟수=0; //전투횟수가 5이상이 되면 옷이 낡음
		while(도적1.레벨!=10) {
			
			String todo= "무엇을 하시겠습니까?\n";
			for(int i=0; i<todo.length(); i++) {
				try {
					Thread.sleep(100);
					System.out.format("%c", todo.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println( 도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인)
					+ "\n\n1.사냥하러 가기 2.휴식하기 3.아이템 상점 4.훈련하기 5.인벤토리 보기 /0.게임 끝내기");
			
			int 할일= scan.nextInt();
			System.out.println();
			if(할일==1) { //사냥하기
				Music fightMusic= new Music("bensound-epic.mp3",true);
				introMusic.close();
				fightMusic.start();
				//날씨에 따라 도적의 공격력에 영향을 미침
				날씨 날씨= new 날씨();
				도적1.공격력= 날씨.날씨메소드(도적1.공격력);
				
				String move="사냥을 하러 이동합니다.";
				for(int i=0; i<move.length(); i++) {
					try {
						Thread.sleep(100);
						System.out.format("%c", move.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
				//공룡발견 스레드
				//공룡을 발견하는데 1~5초 사이의 시간이 걸림
				String find="두리번두리번...";
				int rand= (int)(Math.random()*10);
				for(int i=0; i<find.length(); i++) {
					try {
						Thread.sleep(50*rand);
						System.out.format("%c", find.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println();
				//3마리 공룡 랜덤으로 출현
				int dinor= (int)((Math.random()*10)+1)/3+1;
				while(dinor>3) {
					dinor= (int)((Math.random()*10)+1)/3+1;
				}
				int attack;
				//공룡 종류 3마리
				//티라노사우르스, 트리케라톱스, 브라키오사우르스
				if(dinor==1) {
					System.out.println("        ,\r\n" + 
							"       /|\r\n" + 
							"      / |\r\n" + 
							"     /  /\r\n" + 
							"    |   |\r\n" + 
							"   /    |\r\n" + 
							"   |    \\_\r\n" + 
							"   |      \\__\r\n" + 
							"   \\       __\\_______\r\n" + 
							"    \\                 \\_\r\n" + 
							"    | /                 \\\r\n" + 
							"    \\/                   \\\r\n" + 
							"     |                    |\r\n" + 
							"     \\                   \\|\r\n" + 
							"     |                    \\\r\n" + 
							"     \\                     |\r\n" + 
							"     /\\    \\_               \\\r\n" + 
							"    / |      \\__ (   )       \\\r\n" + 
							"   /  \\      / |\\\\  /       __\\____\r\n" + 
							"   |  ,     |  /\\ \\ \\__    |       \\_\r\n" + 
							"   \\_/|\\___/   \\   \\}}}\\__|  (@)     )\r\n" + 
							"    \\)\\)\\)      \\_\\---\\   \\|       \\ \\\r\n" + 
							"                  \\>\\>\\>   \\   /\\__o_o)\r\n" + 
							"                            | /  VVVVV\r\n" + 
							"                            \\ \\    \\\r\n" + 
							"                             \\ \\MMMMM\n"+ 
							"                              \\______/ ");
					티라노 티라노1= new 티라노("티라노사우르스",100,70,30,5,10,5);
					System.out.println(티라노1.이름+"가 나타습니다!\n"
									+티라노1.능력치보여주기(티라노1.이름, 0, 티라노1.체력, 티라노1.공격력, 티라노1.방어력, 티라노1.코인));
					System.out.println("\n=========================================================\n");
					Thread fight = new Thread(new Runnable() {
						@Override
						public void run() {
							while(티라노1.체력!=0&&도적1.체력!=0) {
								try {
									//2초에 한번씩 물어뜯기
									//캐릭터가 가만히 있어도 공룡이 선제공격함
									Thread.sleep(3000);
									System.out.println();
									도적1.체력= 티라노1.물어뜯기(티라노1.이름,도적1.체력,티라노1.공격력,도적1.방어력,"도적");
									System.out.println("도적 "+도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
									if(도적1.체력<=0) {
										//캐릭터의 체력이 0미만이 되면 멈춤
										String die="\n도적의 체력이 0이 되었습니다...";
										break;
									}
								} catch (InterruptedException e) {
									return;
								}
							}
							System.out.println();
						}
					}); 
					fight.start();
				
					System.out.println("\n공격하시겠습니까? 1.공격한다 2.도망친다");
					attack= scan.nextInt();
					if(attack==1) {
						System.out.println("\n=========================================================\n");
						//yes or no
						//사망시 부활할지 말지를 선택
						int yn=0;
						
						while(티라노1.체력>0) {//전투 while
							
							if(도적1.체력>0) { //캐릭터차례
								
								System.out.println("\n무슨 공격을 하시겠습니까?");
								System.out.println("1.칼 휘두르기 2.발톱뽑기 3.물약먹기("+도적1.물약갯수+") 4.도망치기");
								System.out.println();
								//무슨 공격을 할지 선택
								int what= scan.nextInt();
								if(what==1) {
									도적1.칼휘두르기();
									티라노1.체력= 티라노1.데미지(티라노1.이름,티라노1.체력,도적1.공격력, 티라노1.방어력);
									System.out.println(티라노1.능력치보여주기(티라노1.이름, 0, 티라노1.체력, 티라노1.공격력, 티라노1.방어력, 티라노1.코인)+"\n");
								}else if(what==2) {
									도적1.발톱갯수= 도적1.발톱뽑기(티라노1.이름, 도적1.발톱갯수);
									티라노1.체력= 티라노1.데미지(티라노1.이름,티라노1.체력,도적1.공격력, 티라노1.방어력);
									System.out.println(티라노1.능력치보여주기(티라노1.이름, 0, 티라노1.체력, 티라노1.공격력, 티라노1.방어력, 티라노1.코인)+"\n");
								}else if(what==3) {
									물약 물약1= new 물약();
									도적1.체력= 물약1.물약먹기(도적1.체력, "도적");
									if(도적1.물약갯수>0) {
										도적1.물약갯수--;
									}else {
										System.out.println("물약이 없습니다. 물약은 상점에서 구매하세요.\n");
									}
								}else if(what==4) {
									int 도망= (int)(Math.random()*10);
									String run;
									if(도망>3) {
										fight.interrupt();
										run= "\n도망 쳤습니다...";
										for(int i=0; i<run.length(); i++) {
											try {
												Thread.sleep(200);
												System.out.format("%c", run.charAt(i));
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}
										yn=1;
										break;
									}else {
										run= "도망에 실패했습니다. 계속 싸우세요!!!\n";
										System.out.println(run);
									}
								}
								티라노1.도망여부= 티라노1.도망가기("티라노사우르스", 티라노1.체력);
								if(티라노1.도망여부==true) {
									fight.interrupt();
									break;
								}
								
								if(티라노1.체력<=0) {
									fight.interrupt();
									System.out.println("=========================================================\n");
									System.out.println("티라노사우르스를 처치했습니다.\n");
								}
							}else {
								fight.interrupt();
								String die="\n도적이 사망했습니다...";
								for(int i=0; i<die.length(); i++) {
									try {
										Thread.sleep(200);
										System.out.format("%c", die.charAt(i));
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
								yn= scan.nextInt();
								if(yn==1) {
									//다시시작
									도적1.부활하기();
									System.out.println("도적 "+도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
									break;
								}else {
									System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
									int input= scan.nextInt();
									if(input==1) {
										System.out.println("게임을 종료합니다.");
										System.exit(0);
									}else {
										System.out.println("게임을 계속 진행합니다.\n");
									}
								}
							}
						}
						//부활한것도 아니고 티라노가 도망간것도 아니면
						//경험치부여, 레벨업 진행
						if(yn!=1&&티라노1.도망여부!=true) {
							도적1.경험치= 도적1.경험치상승(티라노1.경험치부여);
							도적1.코인= 도적1.코인상승(도적1.코인,티라노1.코인);
							if(도적1.경험치>=10){
								System.out.println(도적1.레벨상승(도적1.레벨, 도적1.경험치, 도적1.체력, 도적1.공격력));
								도적1.경험치= 도적1.경험치-10;
								도적1.레벨++;
								도적1.체력=100;
								도적1.공격력= 도적1.공격력+10;
							}
						}
					}else if(attack==2){
						//싸우시겠습니까? 에서 도망
						fight.interrupt();
						System.out.println("도망쳤습니다.");
					}
					
				}else if(dinor==2) {
					트리케라톱스 트리케라톱스1= new 트리케라톱스("트리케라톱스",150,50,50,8,15,6);
					System.out.println("                            __.--'~~~~~`--.\r\n" + 
							"         ..       __.    .-~               ~-.\r\n" + 
							"         ((\\     /   `}.~                     `.\r\n" + 
							"          \\\\\\  .{     }               /     \\   \\\r\n" + 
							"      (\\   \\\\~~       }              |       }   \\\r\n" + 
							"       \\`.-~ -@~     }  ,-,.         |       )    \\\r\n" + 
							"       (___     ) _}  (    :        |    / /      `._\r\n" + 
							"        `----._-~.     _\\ \\ |_       \\   / /-.__     `._\r\n" + 
							"               ~~----~~  \\ \\| ~~--~~~(  + /     ~-._    ~-._\r\n" + 
							"                         /  /         \\  \\          ~--.,___~_-_.\r\n" + 
							"                      __/  /          _\\  )\r\n" + 
							"                    .<___.'         .<___/" + 
							"");
					
					System.out.println(트리케라톱스1.이름+"가 나타났습니다!\n"
							+ 트리케라톱스1.능력치보여주기(트리케라톱스1.이름, 0, 트리케라톱스1.체력, 트리케라톱스1.공격력, 트리케라톱스1.방어력, 트리케라톱스1.코인));
					System.out.println("\n=========================================================\n");
					//공룡 선제 공격
					Thread fight = new Thread(new Runnable() {
						@Override
						public void run() {
							while(트리케라톱스1.체력!=0&&도적1.체력!=0) {
								try {
									//2.5초에 한번씩 돌진
									Thread.sleep(3500);
									System.out.println();
									도적1.체력= 트리케라톱스1.돌진(트리케라톱스1.이름,도적1.체력,트리케라톱스1.공격력,도적1.방어력,"도적");
									System.out.println("도적 "+도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
									if(도적1.체력<=0) {
										String die="\n도적의 체력이 0이 되었습니다...";
										break;
									}
								} catch (InterruptedException e) {
									return;
								}
							}
							System.out.println();
						}
					}); 
					fight.start();
					
					
					System.out.println("\n공격하시겠습니까? 1.공격한다 2.도망친다");
					attack= scan.nextInt();
					if(attack==1) {
						System.out.println("\n공격을 시작합니다.");
						System.out.println("\n=========================================================\n");
						int yn=0;
						while(트리케라톱스1.체력>0) {//전투 while
							if(도적1.체력>0) {
								System.out.println("\n무슨 공격을 하시겠습니까?");
								System.out.println("1.칼 휘두르기 2.발톱뽑기 3.물약먹기("+도적1.물약갯수+") 4.도망치기");
								int what= scan.nextInt();
								if(what==1) {
									도적1.칼휘두르기();
									트리케라톱스1.체력= 트리케라톱스1.데미지(트리케라톱스1.이름,트리케라톱스1.체력,도적1.공격력, 트리케라톱스1.방어력);
									System.out.println(트리케라톱스1.능력치보여주기(트리케라톱스1.이름, 0, 트리케라톱스1.체력, 트리케라톱스1.공격력, 트리케라톱스1.방어력, 트리케라톱스1.코인)+"\n");
								}else if(what==2) {
									도적1.발톱갯수= 도적1.발톱뽑기(트리케라톱스1.이름, 도적1.발톱갯수);
									트리케라톱스1.체력= 트리케라톱스1.데미지(트리케라톱스1.이름,트리케라톱스1.체력,도적1.공격력, 트리케라톱스1.방어력);
									System.out.println(트리케라톱스1.능력치보여주기(트리케라톱스1.이름, 0, 트리케라톱스1.체력, 트리케라톱스1.공격력, 트리케라톱스1.방어력, 트리케라톱스1.코인)+"\n");
								}else if(what==3) {
									물약 물약1= new 물약();
									if(도적1.물약갯수>0) {
										도적1.체력= 물약1.물약먹기(도적1.체력, "도적");
										도적1.물약갯수--;
									}else {
										System.out.println("물약이 없습니다. 물약은 상점에서 구매하세요.\n");
									}
								}else if(what==4) {
									int 도망= (int)(Math.random()*10);
									String run;
									if(도망>3) {
										fight.interrupt();
										run= "\n도망 쳤습니다...";
										for(int i=0; i<run.length(); i++) {
											try {
												Thread.sleep(200);
												System.out.format("%c", run.charAt(i));
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}
										yn=1;
										break;
									}else {
										run= "도망에 실패했습니다. 계속 싸우세요!!!\n";
										System.out.println(run);
									}
								}
								
								트리케라톱스1.도망여부= 트리케라톱스1.도망가기("트리케라톱스", 트리케라톱스1.체력);
								if(트리케라톱스1.도망여부==true) {
									fight.interrupt();
									break;
								}
								
								if(트리케라톱스1.체력<=0) {
									fight.interrupt();
									System.out.println("=========================================================\n");
									System.out.println("트리케라톱스를 처치했습니다.\n");
								}
							}else {
								fight.interrupt();
								String die="\n도적이 사망했습니다...";
								for(int i=0; i<die.length(); i++) {
									try {
										Thread.sleep(200);
										System.out.format("%c", die.charAt(i));
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
								yn= scan.nextInt();
								if(yn==1) {
									//다시시작
									도적1.부활하기();
									System.out.println("도적 "+도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
									break;
								}else {
									System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
									int input= scan.nextInt();
									if(input==1) {
										System.out.println("게임을 종료합니다.");
										System.exit(0);
									}else {
										System.out.println("게임을 계속 진행합니다.\n");
									}
								}
							}
						}
						if(yn!=1&&트리케라톱스1.도망여부!=true) { //부활한게 아니면
							도적1.경험치= 도적1.경험치상승(트리케라톱스1.경험치부여);
							도적1.코인= 도적1.코인상승(도적1.코인,트리케라톱스1.코인);
							if(도적1.경험치>=10){
								System.out.println(도적1.레벨상승(도적1.레벨, 도적1.경험치, 도적1.체력, 도적1.공격력));
								도적1.경험치= 도적1.경험치-10;
								도적1.레벨++;
								도적1.체력=100;
								도적1.공격력= 도적1.공격력+10;
							}
						}
					}else if(attack==2){
						fight.interrupt();
						System.out.println("도망쳤습니다.");
					}
					
				}else if(dinor==3) {
					System.out.println("         _\r\n" + 
							"       .~q`,\r\n" + 
							"      {__,  \\\r\n" + 
							"          \\' \\\r\n" + 
							"           \\  \\\r\n" + 
							"            \\  \\\r\n" + 
							"             \\  `._            __.__\r\n" + 
							"              \\    ~-._  _.==~~     ~~--.._\r\n" + 
							"               \\        '                  ~-.\r\n" + 
							"                \\      _-   -_                `.\r\n" + 
							"                 \\    /       }        .-    .  \\\r\n" + 
							"                  `. |      /  }      (       ;  \\\r\n" + 
							"                    `|     /  /       (       :   '\\\r\n" + 
							"                     \\    |  /        |      /       \\\r\n" + 
							"                      |     /`-.______.\\     |~-.      \\\r\n" + 
							"                      |   |/           (     |   `.      \\_\r\n" + 
							"                      |   ||            ~\\   \\      '._    `-.._____..----..___\r\n" + 
							"                      |   |/             _\\   \\         ~-.__________.-~~~~~~~~~'''\r\n" + 
							"                    .o'___/            .o______}\r\n" );
					브라키오 브라키오1= new 브라키오("브라키오사우르스",200,60,70,10,20,7);
					System.out.println(브라키오1.이름+"가 나타났습니다!\n"
							+ 브라키오1.능력치보여주기(브라키오1.이름, 0, 브라키오1.체력, 브라키오1.공격력, 브라키오1.방어력, 브라키오1.코인));
					System.out.println("\n=========================================================\n");
					//공룡 선제 공격
					Thread fight = new Thread(new Runnable() {
						@Override
						public void run() {
							while(브라키오1.체력!=0&&도적1.체력!=0) {
								try {
									//2.5초에 한번씩 꼬리공격
									Thread.sleep(3500);
									System.out.println();
									도적1.체력= 브라키오1.꼬리공격(브라키오1.이름,도적1.체력,브라키오1.공격력,도적1.방어력,"도적");
									System.out.println("도적 "+도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
									if(도적1.체력<=0) {
										String die="\n도적의 체력이 0이 되었습니다...";
										break;
									}
								} catch (InterruptedException e) {
									return;
								}
							}
							System.out.println();
						}
					}); 
					fight.start();
					
					System.out.println("\n공격하시겠습니까? 1.공격한다 2.도망친다");
					attack= scan.nextInt();
					if(attack==1) {
						System.out.println("\n공격을 시작합니다.");
						System.out.println("\n=========================================================\n");
						int yn=0;
						while(브라키오1.체력>0) {//전투 while
							if(도적1.체력>0) {
								System.out.println("\n무슨 공격을 하시겠습니까?");
								System.out.println("1.칼 휘두르기 2.발톱뽑기 3.물약먹기("+도적1.물약갯수+") 4.도망치기");
								int what= scan.nextInt();
								if(what==1) {
									도적1.칼휘두르기();
									브라키오1.체력= 브라키오1.데미지(브라키오1.이름,브라키오1.체력,도적1.공격력, 브라키오1.방어력);
									System.out.println(브라키오1.능력치보여주기(브라키오1.이름, 0, 브라키오1.체력, 브라키오1.공격력, 브라키오1.방어력, 브라키오1.코인)+"\n");
								}else if(what==2) {
									도적1.발톱갯수=도적1.발톱뽑기(브라키오1.이름, 도적1.발톱갯수);
									브라키오1.체력= 브라키오1.데미지(브라키오1.이름,브라키오1.체력,도적1.공격력, 브라키오1.방어력);
									System.out.println(브라키오1.능력치보여주기(브라키오1.이름, 0, 브라키오1.체력, 브라키오1.공격력, 브라키오1.방어력, 브라키오1.코인)+"\n");
								}else if(what==3) {
									물약 물약1= new 물약();
									if(도적1.물약갯수>0) {
										도적1.체력= 물약1.물약먹기(도적1.체력, "도적");
										도적1.물약갯수--;
									}else {
										System.out.println("물약이 없습니다. 물약은 상점에서 구매하세요.\n");
									}
								}else if(what==4) {
									int 도망= (int)(Math.random()*10);
									String run;
									if(도망>3) {
										fight.interrupt();
										run= "\n도망 쳤습니다...";
										for(int i=0; i<run.length(); i++) {
											try {
												Thread.sleep(200);
												System.out.format("%c", run.charAt(i));
											} catch (InterruptedException e) {
												e.printStackTrace();
											}
										}
										yn=1;
										break;
									}else {
										run= "도망에 실패했습니다. 계속 싸우세요!!!\n";
										System.out.println(run);
									}
								}
								
								브라키오1.도망여부= 브라키오1.도망가기("브라키오사우르스", 브라키오1.체력);
								if(브라키오1.도망여부==true) {
									fight.interrupt();
									break;
								}
								
								if(브라키오1.체력<=0) {
									System.out.println("=========================================================\n");
									System.out.println("브라키오사우르스를 처치했습니다.\n");
									fight.interrupt();
								}
							}else {
								fight.interrupt();
								String die="\n도적이 사망했습니다...";
								for(int i=0; i<die.length(); i++) {
									try {
										Thread.sleep(200);
										System.out.format("%c", die.charAt(i));
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
								yn= scan.nextInt();
								if(yn==1) {
									//다시시작
									도적1.부활하기();
									System.out.println("도적 "+도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
									break;
								}else {
									System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
									int input= scan.nextInt();
									if(input==1) {
										System.out.println("게임을 종료합니다.");
										System.exit(0);
									}else {
										System.out.println("게임을 계속 진행합니다.\n");
									}
								}
							}
						}
						if(yn!=1&&브라키오1.도망여부!=true) { //부활한게 아니면
							도적1.경험치= 도적1.경험치상승(브라키오1.경험치부여);
							도적1.코인= 도적1.코인상승(도적1.코인,브라키오1.코인);
							if(도적1.경험치>=10){
								System.out.println(도적1.레벨상승(도적1.레벨, 도적1.경험치, 도적1.체력, 도적1.공격력));
								도적1.경험치= 도적1.경험치-10;
								도적1.레벨++;
								도적1.체력=100;
								도적1.공격력= 도적1.공격력+10;
							}
						}
					}else if(attack==2){
						fight.interrupt();
						System.out.println("도망쳤습니다.");
					}
				}
				전투횟수++;
				if(전투횟수==5) {
					도적1.방어력= 도적1.방어력-10;
					System.out.println("\n=========================================================");
					System.out.println("\n전투를 5회 진행하여 옷이 낡았습니다...\n방어력이 10 떨어집니다.");
					전투횟수=0;
				}
				introMusic= new Music("bensound-goinghigher.mp3",true);
				fightMusic.close();
				introMusic.start();
			}else if(할일 ==2) { //휴식하기
				Music restMusic= new Music("bensound-love.mp3",true);
				introMusic.close();
				restMusic.start();
				
				System.out.println("=========================================================\n");
				String rest1= "어떻게 휴식할지 선택하세요.\n";
				for(int i=0; i<rest1.length(); i++) {
					try {
						Thread.sleep(50);
						System.out.format("%c", rest1.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("1.일반휴식(체력 +10) 2.물약사용(갯수:"+도적1.물약갯수+")(체력+30) / 0.나가기");
				int rest= scan.nextInt();
				while(rest!=0) {
					if(rest==1) {
						도적1.체력= 도적1.휴식하기(도적1.체력);	
						System.out.println(도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
						break;
					}else if(rest==2) {
						물약 물약1= new 물약();
						if(도적1.물약갯수>0) {
							도적1.체력= 물약1.물약먹기(도적1.체력, "도적");
							System.out.println(도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
							도적1.물약갯수--;
						}else {
							String buy="\n물약이 없습니다. 상점에서 물약을 구매하세요.\n";
							for(int i=0; i<buy.length(); i++) {
								try {
									Thread.sleep(100);
									System.out.format("%c", buy.charAt(i));
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
						break;
					}else {
						System.out.println("\n휴식방법을 제대로 선택하세요.");
						break;
					}
				}
				introMusic= new Music("bensound-goinghigher.mp3",true);
				restMusic.close();
				introMusic.start();
			}else if(할일 ==3) { //아이템 구매
				Music storeMusic= new Music("bensound-cute.mp3",true);
				introMusic.close();
				storeMusic.start();
				
				String move="아이템 상점으로 이동합니다.\n";
				for(int i=0; i<move.length(); i++) {
					try {
						Thread.sleep(100);
						System.out.format("%c", move.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("\n=========================================================\n");
				System.out.println("상점에서는 물약을 구매할 수 있고, 무기와 방어구를 업그레이드 시킬 수 있습니다.\n"
						+ "물약은 캐릭터가 소지하게 되고 전투에서 사용가능합니다.\n"
						+ "무기,방어구는 각각 공격력,방어력을 높여줍니다.\n\n"
						+ "구매한 무기와 방어구는 즉시 업그레이드됩니다.");
				while(true) {
					System.out.println("\n=========================================================\n");
					System.out.println("무엇을 하시겠습니까? 1.구매 2.판매 / 0.나가기");
					int 상점 = scan.nextInt();
					if(상점==1) { //구매
						System.out.println("\n무엇을 구매하시겠습니까? 현재코인 : "+도적1.코인+"\n");
						System.out.println("1.물약(5코인) 2.무기(10코인) 3.방어구(5코인) / 0.나가기");
							int 구매= scan.nextInt();
							if(구매==1) {
								System.out.println("\n물약을 구매하시겠습니까? 1.네/2.아니요");
								구매= scan.nextInt();
								if(구매==1) {
									if(도적1.코인>=5) {
										if(도적1.물약갯수<=10) {
											물약 물약1= new 물약();
											System.out.println("물약을 구매합니다.\n");
											도적1.코인=물약1.구매("물약", 5, 도적1.코인);
											도적1.물약갯수=물약1.물약소지(도적1.물약갯수, "도적");
											System.out.println(도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
										}else {
											System.out.println("가방이 꽉 찼습니다. 아이템을 더 이상 구매할 수 없습니다.");
										}
									}else {
										System.out.println("돈이 부족합니다.\n공룡을 사냥하면 코인을 얻을 수 있습니다.");
										break;
									}
								}else {
									System.out.println("\n물약을 구매하지 않았습니다.");
									
								}
							}else if(구매==2) {
								System.out.println("\n무기를 구매하시겠습니까? 1.네/2.아니요");
								구매= scan.nextInt();
								if(구매==1) {
									if(도적1.코인>=10) {
										무기 무기1= new 무기();
										도적1.코인=무기1.구매("무기", 10, 도적1.코인);
										도적1.공격력= 무기1.공격력상승(도적1.공격력);
										System.out.println(도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
									}else {
										System.out.println("돈이 부족합니다.\n공룡을 사냥하면 코인을 얻을 수 있습니다.");
										break;
									}
								}else {
									System.out.println("\n무기를 구매하지 않았습니다.");
								}
							}else if(구매==3) {
								System.out.println("\n방어구를 구매하시겠습니까? 1.네/2.아니요");
								구매= scan.nextInt();
								if(구매==1) {
									if(도적1.코인>=5) {
										방어구 방어구1 = new 방어구();
										도적1.코인=방어구1.구매("방어구", 5, 도적1.코인);
										도적1.방어력=방어구1.방어력상승(도적1.방어력);
										System.out.println(도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
									}else {
										System.out.println("돈이 부족합니다.\n공룡을 사냥하면 코인을 얻을 수 있습니다.");
										break;
									}
								}else {
									System.out.println("\n방어구를 구매하지 않았습니다.");
								}
							}else {
								String out= "\n상점을 나갑니다.\n";
								for(int i=0; i<out.length(); i++) {
									try {
										Thread.sleep(100);
										System.out.format("%c", out.charAt(i));
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
								break;
							
							}
					}else if(상점==2) {//물건 판매
						String sell= "\n아이템을 판매합니다.\n";
						for(int i=0; i<sell.length(); i++) {
							try {
								Thread.sleep(100);
								System.out.format("%c", sell.charAt(i));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						티라노 티라노1= new 티라노("티라노사우르스",100,70,30,5,10,5);
						트리케라톱스 트리케라1= new 트리케라톱스("트리케라톱스",150,50,50,8,15,6);
						브라키오 브라키오1= new 브라키오("브라키오사우르스",200,60,70,10,20,7); 
						System.out.println("\n판매할 물건의 인덱스를 선택하세요. / 0.나가기");
						도적1.채집물인벤출력("발톱",도적1.발톱갯수);
						System.out.println();
						int 발톱= (scan.nextInt())-1;
						if(발톱==-1) {
							System.out.println("\n판매를 끝냅니다.");
							break;
						}
						
						System.out.println("\n"+(발톱+1)+"."+도적1.list.get(발톱)+"을 판매할까요? 1.네 2.아니오");
						int yn2= scan.nextInt();
						if(yn2==1) {
							도적1.발톱갯수--;
							if(도적1.list.get(발톱).equals("티라노사우르스 발톱")) {
								도적1.코인= 도적1.채집물판매(발톱, 도적1.코인, 티라노1.채집물코인);
							}else if(도적1.list.get(발톱).equals("트리케라톱스 발톱")) {
								도적1.코인= 도적1.채집물판매(발톱, 도적1.코인, 트리케라1.채집물코인);
							}else if(도적1.list.get(발톱).equals("브라키오사우르스 발톱")) {
								도적1.코인= 도적1.채집물판매(발톱, 도적1.코인, 브라키오1.채집물코인);
							}else if(도적1.list.get(발톱).equals("큰 합성발톱")) {
								//큰 합성발톱 15코인
								도적1.코인= 도적1.채집물판매(발톱, 도적1.코인, 15);
							}
						}else if(yn2==2) {
							System.out.println(도적1.list.get(발톱)+"\n발톱을 판매하지 않았습니다.");
						}
					
					}else if(상점==0) {
						String out= "\n상점을 나갑니다.\n";
						for(int i=0; i<out.length(); i++) {
							try {
								Thread.sleep(100);
								System.out.format("%c", out.charAt(i));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						break;
					}
				}
				introMusic= new Music("bensound-goinghigher.mp3",true);
				storeMusic.close();
				introMusic.start();
			}else if(할일==4) {//훈련하기
				Music workMusic= new Music("bensound-highoctane.mp3",true);
				introMusic.close();
				workMusic.start();
				훈련 훈련1= new 훈련();
				String move="훈련을 위해 훈련장으로 이동합니다.\n";
				for(int i=0; i<move.length(); i++) {
					try {
						Thread.sleep(100);
						System.out.format("%c", move.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("\n=========================================================\n");
				System.out.println("훈련장에서는 사냥훈련, 회피훈련을 할 수 있습니다.\n"
						+ "사냥훈련과 회피훈련은 체력을 소모하여 공격력과 방어력을 올려줍니다.\n");
				System.out.println("=========================================================");
				while(true) {
					String work="\n무슨 훈련을 하시겠습니까?\n";
					for(int i=0; i<work.length(); i++) {
						try {
							Thread.sleep(100);
							System.out.format("%c", work.charAt(i));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("1.사냥 훈련(공격력상승) 2.회피 훈련(방어력상승)/ 0.나가기");
					//훈련종류 선택
					int 종류= scan.nextInt();
					System.out.println();
					if(종류==1) {//사냥훈련
						사냥훈련 사냥1= new 사냥훈련();
						if(훈련1.훈련하기("사냥")==true) {
							도적1.공격력=사냥1.공격력상승(도적1.공격력);
						}
						도적1.체력= 도적1.체력-10;
						System.out.println(도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
						
						//훈련하다가 체력을 모두 소진해서 사망하는 경우
						if(도적1.체력<=0) {
							String die="\n도적이 사망했습니다...";
							for(int i=0; i<die.length(); i++) {
								try {
									Thread.sleep(200);
									System.out.format("%c", die.charAt(i));
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
							int yn= scan.nextInt();
							if(yn==1) {
								//다시시작
								도적1.부활하기();
								System.out.println("도적 "+도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
								break;
							}else {
								System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
								int input= scan.nextInt();
								if(input==1) {
									System.out.println("게임을 종료합니다.");
									System.exit(0);
								}else {
									System.out.println("게임을 계속 진행합니다.\n");
								}
							}
						}
					}else if(종류==2) {//회피훈련
						회피훈련 회피1= new 회피훈련();
						if(훈련1.훈련하기("회피")==true) {
							도적1.방어력= 회피1.방어력상승(도적1.방어력);
						}
						도적1.체력= 도적1.체력-10;
						System.out.println(도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
						if(도적1.체력<=0) {
							String die="\n도적이 사망했습니다...";
							for(int i=0; i<die.length(); i++) {
								try {
									Thread.sleep(200);
									System.out.format("%c", die.charAt(i));
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							System.out.println("\n다시 시작하시겠습니까? 1.yes 2.no");
							int yn= scan.nextInt();
							if(yn==1) {
								//다시시작
								도적1.부활하기();
								System.out.println("도적 "+도적1.능력치보여주기("", 도적1.레벨, 도적1.체력, 도적1.공격력, 도적1.방어력, 도적1.코인));
								break;
							}else {
								System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
								int input= scan.nextInt();
								if(input==1) {
									System.out.println("게임을 종료합니다.");
									System.exit(0);
								}else {
									System.out.println("게임을 계속 진행합니다.\n");
								}
							}
						}
					}else {
						String out= "훈련장을 나갑니다...";
						for(int i=0; i<out.length(); i++) {
							try {
								Thread.sleep(100);
								System.out.format("%c", out.charAt(i));
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						break;
					}
				}
				introMusic= new Music("bensound-goinghigher.mp3",true);
				workMusic.close();
				introMusic.start();
			}else if(할일==5){//인벤토리 보기
				//인벤토리에는 사냥할때 얻은 가죽, 발톱이 들어감
				System.out.println("\n=========================================================\n");
				if(도적1.list.size()==0) {
					System.out.println("인벤토리에 아무것도 없습니다...");
					
				}else {
					String list= "인벤토리를 출력합니다.\n";
					for(int i=0; i<list.length(); i++) {
						try {
							Thread.sleep(30);
							System.out.format("%c", list.charAt(i));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					도적1.채집물인벤출력("발톱", 도적1.발톱갯수);
					System.out.println("\n=========================================================\n");
					
					System.out.println( "일반 발톱이 2개 이상 있으면 발톱합성을 할 수 있습니다."
							+ "\n이미 합성된 발톱은 합성재료로 사용할 수 없습니다.");
					System.out.println("\n=========================================================\n");
					
					if(도적1.발톱갯수>=2) {
						System.out.println("발톱 합성을 하시겠습니까? 1.네 2.아니오");
						int yn3= scan.nextInt();
						if(yn3==1) {
							String mix= "\n합성에 사용할 발톱을 2가지 선택하세요.\n\n";
							for(int i=0; i<mix.length(); i++) {
								try {
									Thread.sleep(30);
									System.out.format("%c", mix.charAt(i));
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							도적1.채집물인벤출력("발톱", 도적1.발톱갯수);
							System.out.println();
							int 발톱1, 발톱2;
							while(true) {
							발톱1= scan.nextInt();
								if(도적1.list.get(발톱1-1).equals("큰 합성발톱")) {
									System.out.println("이미 합성된 발톱입니다.");
									break;
								}else {
									System.out.println(발톱1+"."+도적1.list.get(발톱1-1)+"을 선택했습니다.");
									break;
								}
							}
							
							while(true) {
								발톱2= scan.nextInt();
								if(도적1.list.get(발톱2-1).equals("큰 합성발톱")) {
									System.out.println("이미 합성된 발톱입니다.");
									break;
								}else if(발톱1==발톱2) {
									System.out.println("이미 선택된 발톱입니다.");
								}else {
									System.out.println(발톱2+"."+도적1.list.get(발톱2-1)+"을 선택했습니다.");
									도적1.발톱갯수= 도적1.합성하기(발톱1-1, 발톱2-2, 도적1.발톱갯수,"발톱");
									break;
								}
							}
						}else if(yn3==2) {
							String out= "인벤토리를 나갑니다...\n";
							for(int i=0; i<out.length(); i++) {
								try {
									Thread.sleep(100);
									System.out.format("%c", out.charAt(i));
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}
				
				}
			}else {
			
				System.out.println("게임을 정말 종료하시겠습니까? 1.네/2.아니오");
				int input= scan.nextInt();
				if(input==1) {
					System.out.println("게임을 종료합니다.");
					System.exit(0);
				}else {
					System.out.println("게임을 계속 진행합니다.\n");
				}
			}
			System.out.println("\n=========================================================\n");
		}
		
		//레벨이 10이 되었다!
		introMusic.close();
		Music finishMusic= new Music("finish.wav",true);
		finishMusic.start();
		
		String congraturation= "레벨이 10이 되었습니다!\n"+
				"                                   .''.       \r\n" + 
				"       .''.      .        *''*    :_\\/_:     . \r\n" + 
				"      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\r\n" + 
				"  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\r\n" + 
				" :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\r\n" + 
				" : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\r\n" + 
				"  '..'  ':::'     * /\\ *     .'/.\\'.   '\r\n" + 
				"      *            *..*         :\r\n" + 
				"        *\r\n" + 
				"        *\n"
				+ "\n=========================================================\n";
				for(int i=0; i<congraturation.length(); i++) {
					try {
						Thread.sleep(3);
						System.out.format("%c", congraturation.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		System.out.println("축하합니다!!");
		System.out.println("목표 레벨을 달성했습니다. 게임을 종료합니다.");
	}
	}
	
}








