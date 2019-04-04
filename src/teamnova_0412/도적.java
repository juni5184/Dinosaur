package teamnova_0412;

public class 도적 extends 캐릭터{
	
	int 발톱갯수;

	public 도적() {
	}
	
	public 도적(int 체력, int 공격력, int 방어력, int 레벨, int 경험치, int 코인) {
		super(체력, 공격력, 방어력, 레벨, 경험치, 코인);
		this.방어력= 방어력+20;
	}
	public void 칼휘두르기() {
		System.out.println("도적이 칼을 휘둘렀다!");
	}
	public int 발톱뽑기(String 공룡이름, int 발톱갯수) {
		System.out.println("도적이 "+공룡이름+"발톱을 뽑았다!");
		발톱갯수++;
		return 발톱갯수;
	}

	public void 발톱인벤출력() {
		System.out.println("발톱갯수 : "+발톱갯수);
		for(int i=0; i<발톱갯수; i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
	}
	
	public int 발톱판매(int 발톱번호, int 도적코인, int 발톱코인) {
			System.out.println("\n"+(발톱번호+1)+"."+list.get(발톱번호)+"을 판매했습니다.");
			System.out.println(발톱코인+"코인을 얻었습니다.");
			list.remove(발톱번호);
			도적코인=도적코인+발톱코인;
		return 도적코인;
	}
	


}
