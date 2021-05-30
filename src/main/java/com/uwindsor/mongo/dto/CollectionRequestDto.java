package com.uwindsor.mongo.dto;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class CollectionRequestDto {
    private Integer pageSize;
    private Integer pageNumber;
    private String sorting;
}