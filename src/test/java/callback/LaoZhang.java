package callback;


public class LaoZhang implements Callback{
	private Kettle kettle;
	
	public LaoZhang(Kettle kettle) {
		this.kettle = kettle;
	}
	public void heatUpWater(){
		System.out.println("����ȥ��ˮ��");
		new Thread(new Runnable() {
			public void run() {
				kettle.heat(LaoZhang.this);
			}
		}).start();
		watchTV();
	}
	public void watchTV(){
		System.out.println("����ȥ��������");
	}
	@Override
	public void callbackAction() {
		System.out.println("ˮ�տ���");
	}
	public static void main(String[] args) {
		Kettle kettle = new Kettle();
		LaoZhang laoZhang = new LaoZhang(kettle);
		laoZhang.heatUpWater();
	}
}
