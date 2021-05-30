package com.uwindsor.mongo.adapter;

import com.uwindsor.mongo.dto.CollectionRequestDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectionRequestAdapter {

    public static CollectionRequestDto adaptRequest(Page<?> page) {
        return CollectionRequestDto.builder()
                .pageNumber(page.getPageable().getPageNumber())
                .pageSize(page.getPageable().getPageSize())
                .sorting(page.getSort().toString())
                .build();
    }
}