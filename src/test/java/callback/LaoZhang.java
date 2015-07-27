package callback;


public class LaoZhang implements Callback{
	private Kettle kettle;
	
	public LaoZhang(Kettle kettle) {
		this.kettle = kettle;
	}
	public void heatUpWater(){
		System.out.println("老张去烧水了");
		new Thread(new Runnable() {
			public void run() {
				kettle.heat(LaoZhang.this);
			}
		}).start();
		watchTV();
	}
	public void watchTV(){
		System.out.println("老张去看电视了");
	}
	@Override
	public void callbackAction() {
		System.out.println("水烧开了");
	}
	public static void main(String[] args) {
		Kettle kettle = new Kettle();
		LaoZhang laoZhang = new LaoZhang(kettle);
		laoZhang.heatUpWater();
	}
}
