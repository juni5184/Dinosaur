package teamnova_0412;

import java.util.Random;

public class ���Ű�� extends ����{
	
	Random rand= new Random();

	public ���Ű��(String �̸�,int ü��, int ���ݷ�, int ����, int ����ġ�ο�, int ��������, int ��������) { //200/80/10
		super(�̸�, ü��, ���ݷ�, ����, ����ġ�ο�, ��������, ��������);
	}
	
	public int ��������(String �̸�, int ĳ����ü��, int ���Ű�����ݷ�, int ĳ���͹���, String name) {
		System.out.println(�̸�+"�� ������ �ķ��ƴ�!");
		���Ű�����ݷ�= rand.nextInt(21)+(���Ű�����ݷ�-20);
		System.out.println(name+"�� "+(���Ű�����ݷ�-(ĳ���͹���/10))+"�������� �Ծ���!");
		ĳ����ü��= ĳ����ü��-���Ű�����ݷ�+ĳ���͹���/10;
		return ĳ����ü��;
	}
}
