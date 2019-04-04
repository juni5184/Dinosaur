package teamnova_0412;

import java.util.Random;

public class 공룡 extends 유닛 {
	
	String 이름="";
	int 경험치부여;
	int 채집물코인;
	boolean 도망여부=false;
	
	Random rand= new Random();
	
	public 공룡() {
	}
	
	public 공룡( String 이름, int 체력, int 공격력, int 방어력,  int 경험치부여, int 코인, int 채집물코인) {
		super(체력, 공격력, 방어력, 코인);
		this.이름= 이름;
		this.경험치부여= 경험치부여;
		this.채집물코인 = 채집물코인;
	}
	
	public int 데미지(String 공룡, int 체력, int 사냥꾼공격력 ,int 공룡방어력) {
		사냥꾼공격력= rand.nextInt(21)+(사냥꾼공격력-20);
		System.out.println(공룡 +"가 "+(사냥꾼공격력-(공룡방어력/10))+"데미지를 입었다!");
		체력= 체력-사냥꾼공격력+(공룡방어력/10);
		return 체력;
	}
	
	public boolean 도망가기(String 공룡이름, int 체력) {
		int per= (int)(Math.random()*10);
		if(체력<20 && 체력>0) {
			if(per>7) {
				System.out.println();
				String run= "\n"+공룡이름+"가 도망갔습니다...\n";
				for(int i=0; i<run.length(); i++) {
					try {
						Thread.sleep(50);
						System.out.format("%c", run.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				도망여부= true;
				}
			}
		}
		return 도망여부;
	}
	
}
