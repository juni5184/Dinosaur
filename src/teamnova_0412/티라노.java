package teamnova_0412;

import java.util.Random;

public class Ƽ��� extends ����{

	Random rand= new Random();
	
	
	public Ƽ��� (String �̸�,int ü��, int ���ݷ�, int ����, int ����ġ�ο�, int ��������, int ��������) {//100/80/5
		super(�̸�, ü��, ���ݷ�, ����, ����ġ�ο�, ��������, ��������);
	}
	
	public int ������(String �̸�, int ĳ����ü��, int Ƽ�����ݷ�, int ĳ���͹���, String name) {
		System.out.println(�̸�+"�� ��������!");
		Ƽ�����ݷ�= rand.nextInt(21)+(Ƽ�����ݷ�-20);
		System.out.println(name+"�� "+(Ƽ�����ݷ�-(ĳ���͹���/10))+"�������� �Ծ���!");
		ĳ����ü��= ĳ����ü��-Ƽ�����ݷ�+ĳ���͹���/10;
		return ĳ����ü��;
	}
}
