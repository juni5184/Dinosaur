package teamnova_0412;

public class ȸ���Ʒ� extends �Ʒ� {
	
	public int ���»��(int ĳ���͹���) {
		String success= "������ 10��µǾ����ϴ�.\n";
		for(int i=0; i<success.length(); i++) {
			try {
				Thread.sleep(50);
				System.out.format("%c", success.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return ĳ���͹���+10;
	}
	
}
