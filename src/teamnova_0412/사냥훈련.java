package teamnova_0412;


public class ����Ʒ� extends �Ʒ� {
	
	public int ���ݷ»��(int ĳ���Ͱ��ݷ�) {
		String success= "���ݷ��� 10��µǾ����ϴ�.\n";
		for(int i=0; i<success.length(); i++) {
			try {
				Thread.sleep(50);
				System.out.format("%c", success.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return ĳ���Ͱ��ݷ�+10;
	}
}
