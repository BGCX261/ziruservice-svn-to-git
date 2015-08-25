package cn.ziroom.util;

public class CurrentThread {
	public static void main(String[] args) {
		System.out.print("程序执行..........");
		System.out.println("开启线程");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				int i = 0;
				try {
					Thread.sleep(3600L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for(i=0;i<100;i++){
					System.out.println("执行数据:" + i++);
				}
			}
		});
		t.start();
		System.out.println("程序执行完成");
	}
}
