package teamnova_0412;

public class 아이템 {
	
	int 가격;
	
	public int 구매(String 품목, int 가격, int 캐릭터코인) {//물약이 구매당한거지만 팔린거라고 친다.
		캐릭터코인 = 캐릭터코인-가격;
		return 캐릭터코인;
	}
	
}
