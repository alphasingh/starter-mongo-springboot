package com.uwindsor.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.Instant;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ObjectEntity {

    @Id
    private String id;

    @Field(value = "value", targetType = FieldType.STRING)
    private String value;

    @Field(value = "activity", targetType = FieldType.STRING)
    private ObjectActivity activity;

    @CreatedDate
    private Instant createdAt;

    @CreatedBy
    private String createdBy;
}
