package com.asiainfo.p6_2020.zookeeper;

import java.util.concurrent.CountDownLatch;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.retry.RetryForever;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher.Event.EventType;

/**
 * 操作zookeeper的Java客户端
 *
 * @author zhangzhiwang
 * @date Sep 9, 2020 7:34:31 PM
 */
public class CuratorTest {
	public static void main(String[] args) throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
				.connectString("127.0.0.1:2181")
//				.connectionTimeoutMs(10000)// 连接超时时间，即在规定的时间内客户端如果没有连接上服务端就会报超时
				.sessionTimeoutMs(10000)// 会话超时时间，即客户端连接上服务端之后如果在指定时间内没有收到服务端的心跳连接则认为该会话已经断开，超时了
				/**
				 * 重连策略一共四种：
				 * 1、RetryForever：永远重连下去
				 * 2、RetryUntilElapsed：以sleepMsBetweenRetries的间隔重连,直到超过maxElapsedTimeMs的时间设置 
				 * 3、RetryNTimes：指定重连次数
				 * 4、ExponentialBackoffRetry：每次重连次数是递增的
				 */
//				.retryPolicy(new RetryForever(1000))// 重连策略
//				.retryPolicy(new RetryUntilElapsed(5000, 1000))// 重连策略
				.retryPolicy(new RetryNTimes(3, 1000))// 重连策略
				.build();
		curatorFramework.start();// 启动才生效
		
//		// 创建zk节点（同步操作）
//		String createResult = curatorFramework.create().creatingParentsIfNeeded()// 如果没有父节点则创建父节点
//				.withMode(CreateMode.PERSISTENT_SEQUENTIAL)// 创建持久的有序节点
//		.forPath("/first1/second", "hello".getBytes());
//		System.out.println("createResult = " + createResult);
		
		CountDownLatch countDownLatch = new CountDownLatch(1);
		// 创建zk节点（异步操作）
		curatorFramework.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).inBackground(new BackgroundCallback() {
			@Override
			public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
				if(event.getType() == CuratorEventType.CREATE) {
					System.out.println("event = " + event);
					countDownLatch.countDown();
				}
			}})// inBackground代表后台异步操作
		.forPath("/first1/second", "world".getBytes());
		
		countDownLatch.await();
		
		// 修改数据
//		curatorFramework.setData().forPath("/first/second", "hello world".getBytes());
	}
}
