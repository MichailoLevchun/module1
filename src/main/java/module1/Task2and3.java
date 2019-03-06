package module1;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2and3 {
	final static Logger LOG = Logger.getLogger(Task2and3.class);

	private String name;

	@MyAnnotation(id = 0)
	private String surname;

	@MyAnnotation(id = 1)
	private int age;

	@MyAnnotation(id = 2, description = "Show which type of weapon uses soldier")
	private String weapon;

	public static void trackMyAnnotations(List<Integer> myAnnotations, Class<?> class1) {
		for (Field fields : class1.getDeclaredFields()) {
			MyAnnotation myAnnotation = fields.getAnnotation(MyAnnotation.class);
			if (myAnnotation != null) {
				LOG.info("Found MyAnnotation: " + myAnnotation.id() + " " + myAnnotation.description());
				myAnnotations.remove(new Integer(myAnnotation.id()));
			}
		}
	}

	public static void start() {
		List<Integer> myAnnotations = new ArrayList<Integer>();
		Collections.addAll(myAnnotations, 0, 1, 2);
		trackMyAnnotations(myAnnotations, Task2and3.class);
	}
}
