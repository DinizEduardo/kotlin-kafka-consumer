package br.com.kotlin.example.consumer

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Deserializer


class JsonNodeDeserializer : Deserializer<JsonNode?> {

    private val objectMapper = ObjectMapper()

    override fun deserialize(topic: String?, data: ByteArray?): JsonNode {
        return try {
            objectMapper.readTree(data)
        } catch (e: Exception) {
            throw RuntimeException("Error deserializing JSON", e)
        }
    }
}