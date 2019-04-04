package teamnova_0412;

public class 무기 extends 아이템{
	

	public int 공격력상승(int 캐릭터공격력) {
		System.out.println("무기를 업그레이드합니다.\n");
		System.out.println("공격력이 10 상승되었습니다.");
		return 캐릭터공격력+10;
	}
}
