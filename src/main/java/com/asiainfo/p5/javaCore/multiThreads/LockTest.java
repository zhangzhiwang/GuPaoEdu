package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest extends Thread {
	private static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) throws InterruptedException {
		// 有三个线程分别运行met1方法，假设三个线程都启动后运行的顺序是A->B->C。
		LockTest threadA = new LockTest();
		threadA.setName("threadA");
		threadA.start();
		
		Thread.sleep(10);
		LockTest threadB = new LockTest();
		threadB.setName("threadB");
		threadB.start();
		
		LockTest threadC = new LockTest();
		threadC.setName("threadC");
//		threadC.start();
	}
	
	public void met1() {
		lock.lock();
		/**
		 * 1、当第一线程也就是线程A运行这段代码时，在lock方法里面讲AQS的核心变量state由0（没有任何线程获取锁）设置成1（有线程获取锁），并记录获取锁的线程是线程A，其它什么事情都没干，线程A从lock方法返回继续运行lock方法到unlock方法之间的代码。</p>
		 * 2、在A释放锁之前，B也来调用met1方法，所以也会进入lock方法。当B进入lock方法时，首先尝试获取一次锁（默认是非公平锁的模式下），发现获取失败了，然后看一下获取了锁的线程是不是自己，发现不是自己。然后就构造一个同步队列，这个同步队列是一个双向链表，head节点是一个毫无意义的Node（它既不代表线程A，也不是B和C，就是一个谁都不是的节点来占个头节点的位置），</p>
		 * 	  它的next指向保存了B线程的Node，B线程Node的prev指向Head，所以目前到这步构造了一个head-><-B的一个等待队列，并且这两个Node的waitStatus都没有赋值，都是默认值0。然后讲Head节点的waitStatus状态置为-1之后调用LockSupport.park(this);将本线程B挂起。</p>
		 * 3、过一会A执同步代码块之间的代码运行完了，开始执行unlock方法。进入unlock方法之后，首先将AQS的state状态-1，然后判断减1后的state是不是0（如果线程A有重入的话那么没重入一次state加1，也就是减1之后不一定为0），如果是0将记录持有锁的线程变量为空（代表没有线程持有锁了）并更新state的值，如果不是0就直接更新state的值。</p>
		 * 	  然后去除head节点并将该节点的waitStatus设置成0，并将它next节点（这里是B线程所代表的节点）唤醒，线程A从unlock方法返回并运行结束。</p>
		 * 4、B线程被唤醒之后会从新尝试获取锁，发现这回获取成功了，就将AQS的state置为1，将表示哪个线程获取了锁的变量置为自己，然后将自己置为head节点并将原head节点的next引用置为null，然后结束。</p>
		 * 5、C线程就不分析了，如果等待的话它所代表的Node会挂在B后面。
		 */
		try {
			System.out.println(Thread.currentThread().getName() + "执行一些逻辑");
			while(true) {}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void run() {
		met1();
	}
}
