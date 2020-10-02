package com.asiainfo.p5.kafka.basicApi;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * kafka消费者
 *
 * @author zhangzhiwang
 * @date Sep 20, 2020 12:24:49 AM
 */
public class KafkaConsumerTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put("bootstrap.servers", "h1:9092,h2:9092,h3:9092");
		properties.put("group.id", "consumer_group_zzw");// 指定消费者组
		properties.put("enable.auto.commit", "false");// 只有consumer发送了coomit之后broker才会更新offset
		properties.put("auto.commit.interval.ms", "1000");// 消费者自动提交的间隔
		properties.put("auto.offset.reset", "earliest");// 有三个值： earliest | latest | none，这三个值不能按字面意思来理解，即earliest不一定是从头开始消费
		properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");// key和value的反序列化
		properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
		kafkaConsumer.subscribe(Arrays.asList("t2"));// 消费者可以监听（订阅）多个topic

		try {
			while (true) {
				ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(1000);
				for (ConsumerRecord<String, String> record : consumerRecords) {
					System.out.println("partition = " + record.partition() + ",value = " + record.value());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			kafkaConsumer.close();
		}
	}
}
