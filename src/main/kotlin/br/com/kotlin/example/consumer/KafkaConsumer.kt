package br.com.kotlin.example.consumer

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class KafkaConsumer {

    @KafkaListener(topics = ["\${kafka.topic}"], groupId = "ppr")
    fun kafkaConsumer(data: ConsumerRecord<Any, Any>, ack: Acknowledgment) {
        println(data)
        ack.acknowledge()
    }

}