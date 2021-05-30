package com.uwindsor.mongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class CollectionDto {
    /* request details */
    private CollectionRequestDto request;

    /* common properties */
    private Integer resultCount;
    private Long totalCount;
    private Integer totalPages;
}
