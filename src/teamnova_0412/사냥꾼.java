package teamnova_0412;

public class ��ɲ� extends ĳ���� {
	
	
	int ���װ���=0;
	
	public ��ɲ�() {
	}
	public ��ɲ�(int ü��, int ���ݷ�, int ����, int ����, int ����ġ, int ����) {
		super(ü��, ���ݷ�, ����, ����, ����ġ, ����);
		this.���ݷ�= ���ݷ�+20;
	}
	public void �ѽ��() {
		System.out.println("��ɲ��� ������ �����ߴ�!");
	}
	public int ���׹����(String �����̸�, int ���װ���) {
		System.out.println("��ɲ��� " +�����̸� +" ������ �����!");
		list.add(�����̸�+" ����");
		���װ���++;
		return ���װ���;
	}
	
	
	
}
