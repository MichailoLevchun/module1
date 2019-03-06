package module1;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;

public class Task5 {

	final static Logger LOG = Logger.getLogger(Task5.class);

	public static void start()  {
		try{
		Class<?> cls = Class.forName("module1.Task5");
		Object instance = cls.newInstance();
		set(instance, "salary", 15);
		set(instance, "firstname", "John");
		LOG.info("Value is set");
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}


	public static boolean set(Object object, String fieldName, Object fieldValue) {
		Class<?> cls = object.getClass();
		while (cls != null) {
			try {
				Field field = cls.getDeclaredField(fieldName);
				field.setAccessible(true);
				field.set(object, fieldValue);
				return true;
			} catch (NoSuchFieldException e) {
	            cls = cls.getSuperclass();
	        } catch (Exception e) {
	            throw new IllegalStateException(e);
	        }
		}
		return false;
	}

}
