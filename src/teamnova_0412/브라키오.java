package teamnova_0412;

import java.util.Random;

public class 브라키오 extends 공룡{
	
	Random rand= new Random();

	public 브라키오(String 이름,int 체력, int 공격력, int 방어력, int 경험치부여, int 공룡코인, int 가죽코인) { //200/80/10
		super(이름, 체력, 공격력, 방어력, 경험치부여, 공룡코인, 가죽코인);
	}
	
	public int 꼬리공격(String 이름, int 캐릭터체력, int 브라키오공격력, int 캐릭터방어력, String name) {
		System.out.println(이름+"가 꼬리로 후려쳤다!");
		브라키오공격력= rand.nextInt(21)+(브라키오공격력-20);
		System.out.println(name+"이 "+(브라키오공격력-(캐릭터방어력/10))+"데미지를 입었다!");
		캐릭터체력= 캐릭터체력-브라키오공격력+캐릭터방어력/10;
		return 캐릭터체력;
	}
}
