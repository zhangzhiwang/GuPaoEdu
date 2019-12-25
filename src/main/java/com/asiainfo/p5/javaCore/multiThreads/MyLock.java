package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Lock</p>
 * Lock是锁的顶级接口，如果你要实现一个锁必须实现Lock接口。AQS是实现锁的一个组件，它简化了锁的实现方式。</p>
 * Lock和AQS的联系和区别是：Lock是面向程序员的，它提供了API供程序员调用从而实现锁的功能；而AQS是面向锁的具体实现的也就是Lock接口的实现类，Lock的实现使用AQS作为组件来实现锁的功能，AQS简化了锁的实现方式。假如说现在要实现一个锁，那么这个锁必须实现锁状态的管理、线程的阻塞和唤醒等功能，而AQS已经实现了这些功能所以锁的实现拿过来直接用就可以。</p>
 * 就好比你开发一个项目来实现订单功能，你的项目是面向用户的，用户只需要你提供的功能而不关系你是怎么实现的，假设这个项目用到了缓存功能，你不需要实际地区开发一个缓存系统，目前有好多成熟的缓存解决方案比如说Redis，那么你的项目里面就可以把Redis作为组建来替你实现缓存的功能。在这里你的项目就相当于Lock锁，缓存组件就相当于AQS。</p>
 * 在具体的实现上建议锁的实现类要组合AQS的子类作为器成员变量，而AQS的子类可以作为锁实现类的静态内部类，所有程序员调用的API都可以已静态代理的方式转到AQS的子类上
 *
 * @author zhangzhiwang
 * @date Dec 25, 2019 8:20:37 PM
 */
public class MyLock implements Lock {// 要实现一个锁必须实现锁的顶级接口Lock
	private Sync sync;

	static class Sync extends AbstractQueuedSynchronizer {// 在锁的实现类MyLock里面要有一个静态内部类来继承AQS
		/**
		 * 在AQS中，state变量是其核心变量，它是用来表示是否有线程获取锁，如果为0代表没有任何线程获取锁，如果大于0代表有线程获取锁。这么重要的变量当然不能将修改权限下放到子类中，也就是对state变量的操作全部集中到抽象类AbstractQueuedSynchronizer中，而且这些方法都是被final修饰的不允许子类复写。这三个方法是：getState()、setState()和compareAndSetState()。
		 */
	}
	
	@Override
	public void lock() {// 静态代理，将所有请求转到sync对象上
		// TODO Auto-generated method stub
		sync.acquire(1);// 伪码
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		// TODO Auto-generated method stub
		sync.acquireInterruptibly(1);// 伪码
	}

	@Override
	public boolean tryLock() {
		// TODO Auto-generated method stub
//		sync.tryAcquireNanos(arg, nanosTimeout);// 伪码
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		sync.release(1);// 伪码
	}

	@Override
	public Condition newCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}
