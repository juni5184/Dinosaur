package teamnova_0412;

public class ���� {
	
	int ü��=100;
	int ���ݷ�=50;
	int ����=30;
	int ����;

	public ����() {
	}
	
	public ����(int ü��, int ���ݷ�, int ����, int ����) {
		this.ü��= ü��;
		this.���ݷ�= ���ݷ�;
		this.����= ����;
		this.����= ����;
	}
	
	public String �ɷ�ġ�����ֱ�(String �̸�, int ����, int ü��, int ���ݷ�, int ����, int ����) {
		String str;
		if(����==0) {
			str= �̸�+"[ü��:"+ü��+"/���ݷ�:"+���ݷ�+"/����:"+����+"/��������:"+����+"]";
		}else {
			str= �̸�+"[����:"+����+"/ü��:"+ü��+"/���ݷ�:"+���ݷ�+"/����:"+����+"/����:"+����+"]";
		}
		return str;
	}
	
	
}
