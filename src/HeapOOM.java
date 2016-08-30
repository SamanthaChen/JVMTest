/**
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author SamanthaChen
 * ���ԡ��������java�������
 *��debug�������ã� 
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * */
import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

	static class OOMObject{
		
	}
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();
		
		while(true){
			list.add(new OOMObject());
		}

	}

}
