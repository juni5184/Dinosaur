package teamnova_0412;

public class 물약 extends 아이템{
	
	public int 물약소지 (int 캐릭터물약, String name){
		System.out.println("물약을 가방에 넣었습니다.");
		캐릭터물약++;
		System.out.println(name+"이 물약을 "+캐릭터물약+"개 가지고 있습니다.");
		return 캐릭터물약;
	}
	
	public int 물약먹기(int 캐릭터체력, String name) {
		if(캐릭터체력<200) {
			System.out.println("\n"+name+"이 물약을 먹었습니다.\n체력이 30상승합니다.\n");
			캐릭터체력= 캐릭터체력+30;
		}else {
			String drink= "\n체력이 충분이 찼습니다.\n";
			for(int i=0; i<drink.length(); i++) {
				try {
					Thread.sleep(50);
					System.out.format("%c", drink.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return 캐릭터체력;
	}
	
}
