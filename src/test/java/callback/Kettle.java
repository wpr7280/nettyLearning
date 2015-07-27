package callback;

public class Kettle {

	public void heat(Callback callback){
		try {
			//模拟烧水的过程
			Thread.sleep(3000);
			callback.callbackAction();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
