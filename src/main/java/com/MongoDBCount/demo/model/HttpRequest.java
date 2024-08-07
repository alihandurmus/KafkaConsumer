package com.MongoDBCount.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "httpRequestStatistic")
@Data
@NoArgsConstructor
public class HttpRequest {
    @Id
    private String id;
    private String request_type;
    private String request_status;
    private long timestamp;

    public HttpRequest(String message){
        String[] parts = message.split(",");
        for (String part : parts) {
            String key = part.split(":")[0];
            String value = part.split(":")[1];
            switch (key){
                case "method":
                    this.request_type = value;
                    break;
                case "status":
                    this.request_status = value;
                    break;
                case "timestamp":
                    this.timestamp = Long.parseLong(value);
                    break;
                default:
                    break;
            }

        }
    }


}

