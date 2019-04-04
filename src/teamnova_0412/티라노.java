package teamnova_0412;

import java.util.Random;

public class 티라노 extends 공룡{

	Random rand= new Random();
	
	
	public 티라노 (String 이름,int 체력, int 공격력, int 방어력, int 경험치부여, int 공룡코인, int 가죽코인) {//100/80/5
		super(이름, 체력, 공격력, 방어력, 경험치부여, 공룡코인, 가죽코인);
	}
	
	public int 물어뜯기(String 이름, int 캐릭터체력, int 티라노공격력, int 캐릭터방어력, String name) {
		System.out.println(이름+"가 물어뜯었다!");
		티라노공격력= rand.nextInt(21)+(티라노공격력-20);
		System.out.println(name+"이 "+(티라노공격력-(캐릭터방어력/10))+"데미지를 입었다!");
		캐릭터체력= 캐릭터체력-티라노공격력+캐릭터방어력/10;
		return 캐릭터체력;
	}
}
