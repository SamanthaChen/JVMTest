/**
 * �˴�����ʾ�����㣺
 * 1.��������ڱ�GCʱ��������
 * 2.�����ԾȻ���ֻ��һ�Σ���Ϊһ�������finali�������ᱻϵͳ�Զ�����һ��
 * */
public class FinalizeEscapeGC {

	public static FinalizeEscapeGC SAVE_HOOK = null;
	public void isAlive(){
		System.out.println("yes, i am still alive :");
	}
	protected void finalize() throws Throwable{
		super.finalize();
		System.out.println("finaliz method executed��");
		FinalizeEscapeGC.SAVE_HOOK = this;
	}
	public static void main(String[] args) throws Throwable {
		SAVE_HOOK = new FinalizeEscapeGC();
		
		//�����һ�γɹ������Լ�
		SAVE_HOOK = null;
		System.gc();
		//��Ϊfinalize�������ȼ��ܵͣ���ͣ0.5s�ȴ�
		Thread.sleep(500);
		if(SAVE_HOOK !=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead :( ");
		}

		
		//�����������ͬ����������Ծ�ʧ��
		SAVE_HOOK = null;
		System.gc();
		//��Ϊfinalize�������ȼ��ܵͣ���ͣ0.5s�ȴ�
		Thread.sleep(500);
		if(SAVE_HOOK !=null){
			SAVE_HOOK.isAlive();
		}else{
			System.out.println("no,i am dead :( ");
		}

	}

}
