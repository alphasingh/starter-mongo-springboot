package com.uwindsor.mongo.adapter;

import com.uwindsor.mongo.common.ErrorMessage;
import com.uwindsor.mongo.dto.ObjectCollectionDto;
import com.uwindsor.mongo.dto.ObjectDto;
import com.uwindsor.mongo.entity.ObjectEntity;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ObjectAdapter {

    public static ObjectEntity adapt(final ObjectDto dto) {
        Assert.notNull(dto, ErrorMessage.VALIDATION_INVALID_INPUT_EMPTY);
        return ObjectEntity.builder()
                .value(dto.getValue())
                .build();
    }

    public static ObjectDto adapt(final ObjectEntity entity) {
        Assert.notNull(entity, ErrorMessage.VALIDATION_INVALID_INPUT_EMPTY);
        return ObjectDto.builder()
                .id(entity.getId())
                .value(entity.getValue())
                .build();
    }

    public static ObjectCollectionDto adaptCollection(final Page<ObjectEntity> page) {
        Assert.notNull(page, ErrorMessage.VALIDATION_INVALID_INPUT_EMPTY);
        final Integer currentSize = page.getNumberOfElements();
        final Long totalSize = page.getTotalElements();
        final Integer totalPages = page.getTotalPages();
        final Collection<ObjectDto> dtoCollection = page
                .stream().filter(Objects::nonNull)
                .map(ObjectAdapter::adapt)
                .collect(Collectors.toList());
        final ObjectCollectionDto collectionDto = new ObjectCollectionDto();
        collectionDto.setRequest(CollectionRequestAdapter.adaptRequest(page));
        collectionDto.setResultCount(currentSize);
        collectionDto.setTotalCount(totalSize);
        collectionDto.setTotalPages(totalPages);
        collectionDto.setObjects(dtoCollection);
        return collectionDto;
    }
}