package com.asiainfo.p5.kafka.basicApi;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * kafka生产者
 *
 * @author zhangzhiwang
 * @date Sep 19, 2020 11:00:27 PM
 */
public class KafkaProducerTest {
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "h1:9092,h2:9092,h3:9092");// kafka的broker地址
		/**
		 * acks有三个值：
		 * -1：broker一旦接收到生产者发送的信息就立即回复应答信息，表示成功接收到消息。此模式下响应速度最快，可用性最高，但是一致性最差，因为broker没有等到leader-partition确认就返回ack应答，万一leader挂了那么生产者也会认为消息发送成功。
		 * 1：broker接收到生产者发送的消息后会等到leader返回成功接收消息的信号后给生产者发送ack消息，这样能够确保leader-broker成功接收到了数据，但是不能保证其它flower已经正确同步了数据。该模式的缺点是万一leader成功接收到了数据后挂掉了，flower还没有来的及同步，那么会导致数据的不一致性。
		 * all：broker会等到leader成功接收到了数据并且所有flower正确同步了数据之后才返回ack应答，这样能够保证数据的一致性，但是损失了性能，这三种模式中该模式是性能最差的。
		 */
		properties.put("acks", "-1");
		properties.put("retries", "3");// 在出现问题的情况下producer的重发次数
		properties.put("batch.size", "16384");// kafka性能高的原因之一就是producer方broker发送消息不是一个消息发送一次，而是将消息先缓存下来，然后批量地进行发送，这样可以减少和broker的io交互次数从而提高性能。batch.size就是一个批次能缓存消息大小的阈值，一旦达到这个阈值producer就往broker发送一次数据，该值默认为16k。
		properties.put("linger.ms", "3");// 该参数的意思是producer等待n毫秒往broker发送一次数据，如果发送的数据量达不到batch.size所设定的阈值，那么producer不能一直等下去不发送消息，这样每达到linger.ms时间就要发送一次。
		properties.put("buffer.memory", "33554432");// 客户端能缓存消息的最大容量，默认为32M。当producer缓存的消息大小达到了这个数量值也会触发一次发送操作。buffer.memory和batch.size的关系不太清楚。
		properties.put("max.block.ms", 3000);// 当缓存的消息总大小达到buffer.memory指定的值时，producer将拒绝接收其它线程发送的消息，会阻塞其它线程一段时间，然后抛出异常
		properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");// key和value都要经过序列化才能发送，消费者也必须配置反序列化
		properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
		
		for(int i = 0; i < 100; i++) {
			kafkaProducer.send(new ProducerRecord<String, String>("t2", "key_zzw", "value_zzw_" + i));// 一个消息就是一个Record，而Record时以key和value的形式保存消息的。key的作用就是在没有指定消息发往哪个partition的时候，以key的hash值以及相关算法来确定发往哪个partition，如果key也没有指定那么会轮询发往多个partition
			System.out.println(i);
		}
		
		kafkaProducer.close();
	}
}
