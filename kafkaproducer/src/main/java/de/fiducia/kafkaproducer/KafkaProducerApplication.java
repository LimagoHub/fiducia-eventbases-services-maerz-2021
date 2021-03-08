package de.fiducia.kafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import de.fiducia.kafkaproducer.event.messaging.MyChannels;


@SpringBootApplication
@EnableBinding(MyChannels.class)
public class KafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

}
