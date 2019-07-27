import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Canlendarr {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		int i = calendar.get(Calendar.YEAR);
		int i1 = calendar.get(Calendar.MONTH);
		int i2 = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(i);
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		ExecutorService executorService = Executors.newFixedThreadPool(6);

	}
}
