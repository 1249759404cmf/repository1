public class thread_test{
	public static void main(String[] args) {
		myRunnable runnable=new myRunnable();
		Thread thread=new Thread(runnable);
		Thread thread1=new Thread(){
			@Override
			public void run() {
				System.out.println("额呵呵额呵呵呵额");
			}
		};
		thread1.start();
		for (int i = 0; i < 1000; i++) {
			System.out.println("hehe");
		}

	}



	public static class myThread extends Thread{
		//这是重写了父类的构造方法,创建一个有名字的线程
		public myThread(String name) {
			super(name);
		}

		//这里重写run方法,就可以定义这个线程执行的内容
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(currentThread().getName());
			}
		}
	}

	public static class myRunnable implements Runnable{

		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("二狗");
			}
		}
	}
}
