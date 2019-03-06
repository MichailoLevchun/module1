package module1;

import org.apache.log4j.Logger;

import java.lang.reflect.Method;

public class Task6 {
	final static Logger LOG = Logger.getLogger(Task6.class);

	public void myMethod1(String a, int... args) {
		for (int i = 0; i < args.length; i++) {
			LOG.info("MyMethod1: " + a + " " + args[0]);
		}
	}

	public void myMethod2(String... args) {
		for (int i = 0; i < args.length; i++) {
			LOG.info("MyMethod2: " + args[i]);

		}
	}

	public static void start() throws IllegalArgumentException {
		try {
			Class<?> cls = Class.forName("module1.Task6");
			Object obj = cls.newInstance();

			Method method1 = cls.getDeclaredMethod("myMethod1", String.class, int[].class);
			method1.invoke(obj, new Object[] { "fdf", new int[] { 1, 2, 3 } });

			Method method2 = cls.getDeclaredMethod("myMethod2", String[].class);
			method2.invoke(obj, new Object[] { new String[] { "dffd", "dhfjd", "hdjkf" } });

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
