package module1;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {

	final static Logger LOG = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		int work = 1;
		Scanner sc = new Scanner(System.in);
		while (work == 1) {

			LOG.info("///////////////////////////////////////////////////////");
			LOG.info("Input 1 to see which fields have my custom annotatation and annotaion value of this fields");
			LOG.info("Input 2 to invoke three methods with different parameters");
			LOG.info("Input 3 to set value into field not knowing its type");
			LOG.info("Input 4 to invoke myMethod(String a, int ... args) and myMethod(String … args)");
			LOG.info("Input 5 to see all information about class that recieved unknown type object");
			LOG.info("Input 6 to exit from program");

			String choice = sc.next();
			switch (choice) {
			case "1": {
				Task2and3.start();
				break;
			}
			case "2": {
				Task4.start();
				break;
			}
			case "3": {
				Task5.start();
				break;
			}
			case "4": {
				Task6.start();
				break;
			}
			case "5":{
				Task7.start();
				Task7.showInfo();
				break;
			}
			case "6": {
				work = 2;
				sc.close();
				break;
			}
			default: {
				LOG.info("Ooops. It seems that you write an invalid symbol");
				break;
			}
			}

		}

	}

}
