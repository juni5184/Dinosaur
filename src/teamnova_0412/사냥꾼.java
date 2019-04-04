package teamnova_0412;

public class 사냥꾼 extends 캐릭터 {
	
	
	int 가죽갯수=0;
	
	public 사냥꾼() {
	}
	public 사냥꾼(int 체력, int 공격력, int 방어력, int 레벨, int 경험치, int 코인) {
		super(체력, 공격력, 방어력, 레벨, 경험치, 코인);
		this.공격력= 공격력+20;
	}
	public void 총쏘기() {
		System.out.println("사냥꾼이 총으로 공격했다!");
	}
	public int 가죽벗기기(String 공룡이름, int 가죽갯수) {
		System.out.println("사냥꾼이 " +공룡이름 +" 가죽을 벗겼다!");
		list.add(공룡이름+" 가죽");
		가죽갯수++;
		return 가죽갯수;
	}
	
	
	
}
