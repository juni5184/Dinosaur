package teamnova_0412;

import java.util.Random;

public class ���� extends ���� {
	
	String �̸�="";
	int ����ġ�ο�;
	int ä��������;
	boolean ��������=false;
	
	Random rand= new Random();
	
	public ����() {
	}
	
	public ����( String �̸�, int ü��, int ���ݷ�, int ����,  int ����ġ�ο�, int ����, int ä��������) {
		super(ü��, ���ݷ�, ����, ����);
		this.�̸�= �̸�;
		this.����ġ�ο�= ����ġ�ο�;
		this.ä�������� = ä��������;
	}
	
	public int ������(String ����, int ü��, int ��ɲ۰��ݷ� ,int �������) {
		��ɲ۰��ݷ�= rand.nextInt(21)+(��ɲ۰��ݷ�-20);
		System.out.println(���� +"�� "+(��ɲ۰��ݷ�-(�������/10))+"�������� �Ծ���!");
		ü��= ü��-��ɲ۰��ݷ�+(�������/10);
		return ü��;
	}
	
	public boolean ��������(String �����̸�, int ü��) {
		int per= (int)(Math.random()*10);
		if(ü��<20 && ü��>0) {
			if(per>7) {
				System.out.println();
				String run= "\n"+�����̸�+"�� ���������ϴ�...\n";
				for(int i=0; i<run.length(); i++) {
					try {
						Thread.sleep(50);
						System.out.format("%c", run.charAt(i));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				��������= true;
				}
			}
		}
		return ��������;
	}
	
}
