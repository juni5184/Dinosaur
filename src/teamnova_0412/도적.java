package teamnova_0412;

public class ���� extends ĳ����{
	
	int ���鰹��;

	public ����() {
	}
	
	public ����(int ü��, int ���ݷ�, int ����, int ����, int ����ġ, int ����) {
		super(ü��, ���ݷ�, ����, ����, ����ġ, ����);
		this.����= ����+20;
	}
	public void Į�ֵθ���() {
		System.out.println("������ Į�� �ֵѷ���!");
	}
	public int ����̱�(String �����̸�, int ���鰹��) {
		System.out.println("������ "+�����̸�+"������ �̾Ҵ�!");
		���鰹��++;
		return ���鰹��;
	}

	public void �����κ����() {
		System.out.println("���鰹�� : "+���鰹��);
		for(int i=0; i<���鰹��; i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
	}
	
	public int �����Ǹ�(int �����ȣ, int ��������, int ��������) {
			System.out.println("\n"+(�����ȣ+1)+"."+list.get(�����ȣ)+"�� �Ǹ��߽��ϴ�.");
			System.out.println(��������+"������ ������ϴ�.");
			list.remove(�����ȣ);
			��������=��������+��������;
		return ��������;
	}
	


}
