package teamnova_0412;

public class 방어구 extends 아이템{
	
	public int 방어력상승(int 캐릭터방어력) {
		System.out.println("방어구를 업그레이드 합니다.\n");
		System.out.println("방어력이 10 상승되었습니다.");
		return 캐릭터방어력+10;
	}
	
}
