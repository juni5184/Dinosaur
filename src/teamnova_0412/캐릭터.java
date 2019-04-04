package teamnova_0412;

import java.util.ArrayList;

public class 캐릭터 extends 유닛 {

	int 경험치;
	int 레벨=1;
	int 물약갯수=0;
	
	ArrayList<String> list= new ArrayList<String>();
	
	
	public 캐릭터() {
	}
	public 캐릭터(int 체력, int 공격력, int 방어력, int 레벨, int 경험치,int 코인) {
		super(체력, 공격력, 방어력, 코인);
		this.경험치= 경험치;
		this.레벨= 레벨;
	}
	
	
	public int 부활하기() {
		System.out.println("\n체력 10으로 부활했습니다.");
		체력=10;
		return 체력;
	}
	
	public int 코인상승(int 캐릭터코인, int 공룡코인) {
		System.out.println(공룡코인+"코인을 얻었습니다!");
		캐릭터코인= 캐릭터코인+공룡코인;
		return 캐릭터코인;
	}
	
	public int 경험치상승(int 경험치부여) {
		System.out.println("경험치가 "+경험치부여+" 올랐습니다. 현재 경험치 : ("+(경험치+경험치부여)+"/10)");
		경험치= 경험치+경험치부여;
		return 경험치;
	}
	
	//왜 여기 있는 값은 적용되지 않는가ㅏㅏ 값을 여러개 받아오려면??
	public String 레벨상승(int 레벨, int 경험치, int 체력, int 공격력) {
		System.out.println("레벨이 올랐습니다!");
		레벨++;
		체력=100;
		공격력= 공격력+10;
		return "현재 레벨 : "+레벨;
	}
	
	public int 휴식하기(int 체력) {
		String rest;
		if(체력<200) {
		rest="\n휴식을 합니다...\n\n";
		for(int i=0; i<rest.length(); i++) {
			try {
				Thread.sleep(300);
				System.out.format("%c", rest.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String power="체력이 10상승했습니다.\n";
		for(int i=0; i<power.length(); i++) {
			try {
				Thread.sleep(100);
				System.out.format("%c", power.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		체력= 체력+10;
		}else {
			rest="충분히 쉬었습니다. 다른 활동을 하세요.\n";
			for(int i=0; i<rest.length(); i++) {
				try {
					Thread.sleep(100);
					System.out.format("%c", rest.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return 체력;
	}
	
	public int 합성하기 (int 채집물1, int 채집물2, int 채집물갯수, String 채집물) {
		System.out.println(list.get(채집물1)+"과 "+list.get(채집물2+1)+"를 합성합니다.");
		int percent= (int)(Math.random()*10);
		
		String success;
		if(percent>=5) {
			success= "\n"+채집물+"합성에 성공했습니다!\n";
			for(int i=0; i<success.length(); i++) {
				try {
					Thread.sleep(100);
					System.out.format("%c", success.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.remove(채집물2);
			list.remove(채집물1);
			list.add("큰 합성"+채집물);
			채집물갯수=채집물갯수-1;
		}else {
			success= "\n"+채집물+"합성에 실패했습니다...\n";
			for(int i=0; i<success.length(); i++) {
				try {
					Thread.sleep(100);
					System.out.format("%c", success.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.remove(채집물1);
			list.remove(채집물2);
			채집물갯수= 채집물갯수-2;
		}
		
		return 채집물갯수;
	}
	
	
	public void 채집물인벤출력(String 채집물, int 채집물갯수) {
		System.out.println(채집물+"갯수 : "+채집물갯수);
		for(int i=0; i<채집물갯수; i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
	}
	
	public int 채집물판매(int 채집물번호, int 캐릭터코인, int 채집물코인) {
			System.out.println("\n"+list.get(채집물번호)+"을 판매했습니다.");
			System.out.println(채집물코인+"코인을 얻었습니다.");
			list.remove(채집물번호);
			캐릭터코인=캐릭터코인+채집물코인;
		return 캐릭터코인;
	}
	
	
}
