package teamnova_0412;

public class 유닛 {
	
	int 체력=100;
	int 공격력=50;
	int 방어력=30;
	int 코인;

	public 유닛() {
	}
	
	public 유닛(int 체력, int 공격력, int 방어력, int 코인) {
		this.체력= 체력;
		this.공격력= 공격력;
		this.방어력= 방어력;
		this.코인= 코인;
	}
	
	public String 능력치보여주기(String 이름, int 레벨, int 체력, int 공격력, int 방어력, int 코인) {
		String str;
		if(레벨==0) {
			str= 이름+"[체력:"+체력+"/공격력:"+공격력+"/방어력:"+방어력+"/공룡코인:"+코인+"]";
		}else {
			str= 이름+"[레벨:"+레벨+"/체력:"+체력+"/공격력:"+공격력+"/방어력:"+방어력+"/코인:"+코인+"]";
		}
		return str;
	}
	
	
}
