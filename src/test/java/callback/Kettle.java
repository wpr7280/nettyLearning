package callback;

public class Kettle {

	public void heat(Callback callback){
		try {
			//ģ����ˮ�Ĺ���
			Thread.sleep(3000);
			callback.callbackAction();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
