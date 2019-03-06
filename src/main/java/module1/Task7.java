package module1;

import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Task7 {
	final static Logger LOG = Logger.getLogger(Task7.class);

	public static <V> V get(Object object, String fieldName) {
		Class<?> cls = object.getClass();
		while (cls != null) {
			try {
				Field field = cls.getDeclaredField(fieldName);
				field.setAccessible(true);
				return (V) field.get(object);
			} catch (NoSuchFieldException e) {
				cls = cls.getSuperclass();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return null;
	}

	public static void start() {
		try {
			Class<?> cls = Class.forName("module1.Task7");
			Object obj = cls.newInstance();
			@SuppressWarnings("unused")
			String fields = get(obj, "fieldName");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showInfo() {
		try {
			Class cls = Class.forName("module1.Task7");

			Field[] fields = cls.getDeclaredFields();
			LOG.info("Variables: ");
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				Class type = fields[i].getType();
				int modifiers = fields[i].getModifiers();
				LOG.info(Modifier.toString(modifiers) + " ");
				if (type.isArray())
					LOG.info(type.getComponentType().getName() + "[] ");
				else
					LOG.info(type.getName() + " ");
				LOG.info(name);
			}

			Constructor[] constrs = cls.getDeclaredConstructors();
			LOG.info("Constructors: ");
			for (int i = 0; i < constrs.length; i++) {
				String name = constrs[i].getName();
				Class params[] = constrs[i].getParameterTypes();
				int modifiers = constrs[i].getModifiers();
				LOG.info(Modifier.toString(modifiers) + " " + name);
				for (int j = 0; params != null && j < params.length; j++) {
					if (j != 0)
						LOG.info(", ");
					Class type = params[j];
					if (type.isArray())
						LOG.info(type.getComponentType().getName()
								+ "[]");
					else
						LOG.info(type.getName());
				}
			}

			Method[] methods = cls.getDeclaredMethods();
			LOG.info("Methods: ");
			for (int i = 0; i < methods.length; i++) {
				int md = methods[i].getModifiers();
				Class retType = methods[i].getReturnType();
				LOG.info(Modifier.toString(md) + " ");
				if (retType.isArray())
					LOG.info(retType.getComponentType().getName() + "[] ");
				else
					LOG.info(retType.getName() + " ");
				LOG.info(methods[i].getName());
				Class cx[] = methods[i].getParameterTypes();
				if (cx.length > 0) {
					for (int j = 0; j < cx.length; j++) {
						if (cx[j].isArray())
							LOG.info(cx[j].getComponentType().getName() + "[]");
						else
							LOG.info(cx[j].getName());
						if (j < (cx.length - 1))
							System.out.print(", ");
					}
				}
			}
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
