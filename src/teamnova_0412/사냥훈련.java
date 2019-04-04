package teamnova_0412;


public class 사냥훈련 extends 훈련 {
	
	public int 공격력상승(int 캐릭터공격력) {
		String success= "공격력이 10상승되었습니다.\n";
		for(int i=0; i<success.length(); i++) {
			try {
				Thread.sleep(50);
				System.out.format("%c", success.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return 캐릭터공격력+10;
	}
}
