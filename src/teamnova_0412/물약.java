package teamnova_0412;

public class ���� extends ������{
	
	public int ������� (int ĳ���͹���, String name){
		System.out.println("������ ���濡 �־����ϴ�.");
		ĳ���͹���++;
		System.out.println(name+"�� ������ "+ĳ���͹���+"�� ������ �ֽ��ϴ�.");
		return ĳ���͹���;
	}
	
	public int ����Ա�(int ĳ����ü��, String name) {
		if(ĳ����ü��<200) {
			System.out.println("\n"+name+"�� ������ �Ծ����ϴ�.\nü���� 30����մϴ�.\n");
			ĳ����ü��= ĳ����ü��+30;
		}else {
			String drink= "\nü���� ����� á���ϴ�.\n";
			for(int i=0; i<drink.length(); i++) {
				try {
					Thread.sleep(50);
					System.out.format("%c", drink.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return ĳ����ü��;
	}
	
}
