package teamnova_0412;

import java.util.ArrayList;

public class ĳ���� extends ���� {

	int ����ġ;
	int ����=1;
	int ���హ��=0;
	
	ArrayList<String> list= new ArrayList<String>();
	
	
	public ĳ����() {
	}
	public ĳ����(int ü��, int ���ݷ�, int ����, int ����, int ����ġ,int ����) {
		super(ü��, ���ݷ�, ����, ����);
		this.����ġ= ����ġ;
		this.����= ����;
	}
	
	
	public int ��Ȱ�ϱ�() {
		System.out.println("\nü�� 10���� ��Ȱ�߽��ϴ�.");
		ü��=10;
		return ü��;
	}
	
	public int ���λ��(int ĳ��������, int ��������) {
		System.out.println(��������+"������ ������ϴ�!");
		ĳ��������= ĳ��������+��������;
		return ĳ��������;
	}
	
	public int ����ġ���(int ����ġ�ο�) {
		System.out.println("����ġ�� "+����ġ�ο�+" �ö����ϴ�. ���� ����ġ : ("+(����ġ+����ġ�ο�)+"/10)");
		����ġ= ����ġ+����ġ�ο�;
		return ����ġ;
	}
	
	//�� ���� �ִ� ���� ������� �ʴ°����� ���� ������ �޾ƿ�����??
	public String �������(int ����, int ����ġ, int ü��, int ���ݷ�) {
		System.out.println("������ �ö����ϴ�!");
		����++;
		ü��=100;
		���ݷ�= ���ݷ�+10;
		return "���� ���� : "+����;
	}
	
	public int �޽��ϱ�(int ü��) {
		String rest;
		if(ü��<200) {
		rest="\n�޽��� �մϴ�...\n\n";
		for(int i=0; i<rest.length(); i++) {
			try {
				Thread.sleep(300);
				System.out.format("%c", rest.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String power="ü���� 10����߽��ϴ�.\n";
		for(int i=0; i<power.length(); i++) {
			try {
				Thread.sleep(100);
				System.out.format("%c", power.charAt(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ü��= ü��+10;
		}else {
			rest="����� �������ϴ�. �ٸ� Ȱ���� �ϼ���.\n";
			for(int i=0; i<rest.length(); i++) {
				try {
					Thread.sleep(100);
					System.out.format("%c", rest.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return ü��;
	}
	
	public int �ռ��ϱ� (int ä����1, int ä����2, int ä��������, String ä����) {
		System.out.println(list.get(ä����1)+"�� "+list.get(ä����2+1)+"�� �ռ��մϴ�.");
		int percent= (int)(Math.random()*10);
		
		String success;
		if(percent>=5) {
			success= "\n"+ä����+"�ռ��� �����߽��ϴ�!\n";
			for(int i=0; i<success.length(); i++) {
				try {
					Thread.sleep(100);
					System.out.format("%c", success.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.remove(ä����2);
			list.remove(ä����1);
			list.add("ū �ռ�"+ä����);
			ä��������=ä��������-1;
		}else {
			success= "\n"+ä����+"�ռ��� �����߽��ϴ�...\n";
			for(int i=0; i<success.length(); i++) {
				try {
					Thread.sleep(100);
					System.out.format("%c", success.charAt(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.remove(ä����1);
			list.remove(ä����2);
			ä��������= ä��������-2;
		}
		
		return ä��������;
	}
	
	
	public void ä�����κ����(String ä����, int ä��������) {
		System.out.println(ä����+"���� : "+ä��������);
		for(int i=0; i<ä��������; i++) {
			System.out.println((i+1)+". "+list.get(i));
		}
	}
	
	public int ä�����Ǹ�(int ä������ȣ, int ĳ��������, int ä��������) {
			System.out.println("\n"+list.get(ä������ȣ)+"�� �Ǹ��߽��ϴ�.");
			System.out.println(ä��������+"������ ������ϴ�.");
			list.remove(ä������ȣ);
			ĳ��������=ĳ��������+ä��������;
		return ĳ��������;
	}
	
	
}
