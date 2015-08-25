package cn.ziroom.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 线程池
 * 
 * @author 孙树林
 * 
 */
public class ThreadGroup {

	private ExecutorService service;

	private static ThreadGroup threadGroup;

	public static ThreadGroup getInstanct() {
		if (threadGroup == null) {
			threadGroup = new ThreadGroup();
		}
		return threadGroup;
	}

	private ThreadGroup() {
		synchronized (this) {
			// 创建固定大小的线程
			service = Executors.newFixedThreadPool(15);
		}
	}

	/**
	 * 加入任务
	 * 
	 * @param thread
	 */
	public void addTask(Thread thread) {
		service.execute(thread);
	}
}
