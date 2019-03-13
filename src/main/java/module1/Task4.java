package module1;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;

public class Task4 {
	final static Logger LOG = Logger.getLogger(Task4.class);

	public void method1(String temp) {
		LOG.info("Method with param String : " + temp);
	}

	public void method2(int temp) {
		LOG.info("Method with param int : " + temp);
	}

	public void method3(double temp) {
		LOG.info("Method with param double : " + temp);
	}

	public static void start() {

		try {
			Class<?> cls = Class.forName("module1.Task4");
			Object obj = cls.newInstance();

			Method method = cls.getDeclaredMethod("method1", String.class);
			method.invoke(obj, new String("fasksdfzhakjf"));

			method = cls.getDeclaredMethod("method2", Integer.TYPE);
			method.invoke(obj, 3324);

			method = cls.getDeclaredMethod("method3", Double.TYPE);
			method.invoke(obj, 72.372);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
