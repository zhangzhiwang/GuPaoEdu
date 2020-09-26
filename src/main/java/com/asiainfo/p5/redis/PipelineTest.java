package com.asiainfo.p5.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * 基于pipeline发送数据
 *
 * @author zhangzhiwang
 * @date Sep 23, 2020 6:46:34 PM
 */
public class PipelineTest {
	public static void main(String[] args) {
		// 不使用管道
		Jedis jedis = new Jedis("localhost", 6379);
		long start = System.currentTimeMillis();
		/**
		 * 在不使用管道的时候客户端每发送一条数据都要阻塞地等待服务端的返回，后一次发送数据必须在前一次接收到服务端返回结果之后，这样和服务端的交互次过会很多，网络开销会很大。
		 * 管道说白了就是批量发送数据，将客户端要发送的一批数据先缓存起来一次性地发送给服务端，减少网络交互。
		 * 管道最多能缓存8192Byte（8M）的数据，当达到这个只是会向服务端发送一次，同时还受限于tcp包的大小，有可能8M的数据会向服务端发送多次，因为tcp包的大小可能达不到8M。
		 * 如果服务器响应的时候客户端还没有发完（因为可能会发送多个tcp的包），客户端会把服务端的响应先放到自己的接收缓冲区，如果接收缓冲区满了就会将返回结果放到服务端的发送缓冲区。
		 * 如果对发送每条命令的响应的实时性要求不高那么可以考虑pipeline的模式。
		 */
		for(int i = 0; i < 100000; i++) {
			jedis.set("s" + i, i + "");
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "ms");
		jedis.close();
		
		// 使用管道
		jedis = new Jedis("localhost", 6379);
		Pipeline pipeline = jedis.pipelined();
		long start2 = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++) {
			pipeline.set("s" + i, i + "");
		}
		pipeline.syncAndReturnAll();
		long end2 = System.currentTimeMillis();
		System.out.println("pipeline耗时：" + (end2 - start2) + "ms");
	}
}
