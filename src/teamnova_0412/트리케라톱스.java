package teamnova_0412;

import java.util.Random;

public class Ʈ���ɶ��齺 extends ����{
	
	Random rand= new Random();
	
	
	public Ʈ���ɶ��齺 (String �̸�,int ü��, int ���ݷ�, int ����, int ����ġ�ο�, int ��������, int ��������) {//150/50/50/8
		super(�̸�, ü��, ���ݷ�, ����, ����ġ�ο�, ��������, ��������);
	}
	
	public int ����(String �̸�, int ĳ����ü��, int Ʈ���ɶ���ݷ�,int ĳ���͹���, String name) {
		System.out.println(�̸�+"�� �����ߴ�!");
		Ʈ���ɶ���ݷ�= rand.nextInt(21)+(Ʈ���ɶ���ݷ�-20);
		System.out.println(name+"�� "+(Ʈ���ɶ���ݷ�-(ĳ���͹���/10))+"�������� �Ծ���!");
		ĳ����ü��= ĳ����ü��-Ʈ���ɶ���ݷ�+ĳ���͹���/10;
		return ĳ����ü��;
	}
}
