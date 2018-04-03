package Cam;

import java.util.Properties;


import org.apache.kafka.clients.producer.*;

public class SimpleProducer {
	public static void main(String[] args) throws Exception {
		
	//Assign topicName to string variable.
	String topicName = "SimpleProducer";
	
	//create instance for properties to access producer configs.
	Properties props = new Properties();
	
	//assign localhostId;
	props.put("bootstrap.servers", "localhost:9093");
	
	//Set acknowledgements for producer requests
	props.put("acks", "all");
	
	//If the request fails, the producer can automatically retry.
	props.put("retries", 0);
	
	//Specify buffer size in config
	props.put("batch.size", 16384);
	
	//Reduce the no of requests less than 0
	props.put("linger.ms", 1);
	
	//the buffer.memory controls the total memory available to the producer
	props.put("buffer.memory", 33554432);
	
	props.put("key.serializer", 
	         "org.apache.kafka.common.serialization.StringSerializer");
	         
	props.put("value.serializer", 
	         "org.apache.kafka.common.serialization.StringSerializer");
	
	Producer<String, String> producer = new KafkaProducer<>(props);
	
	for(int i = 0; i<=1; i++)  {
		producer.send(new ProducerRecord<String,String>(topicName, Integer.toString(i), Integer.toString(i)));
		System.out.println(i);
	}
		
		System.out.println("Message sent successfully");
	
		producer.close();
		
		
	}
}
	


