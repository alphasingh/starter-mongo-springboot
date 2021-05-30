package com.uwindsor.mongo.service;

import com.uwindsor.mongo.entity.ObjectEntity;
import com.uwindsor.mongo.repository.ObjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Autowired, @Lazy}))
public class ObjectService {
    private final ObjectRepository objectRepository;

    public ObjectEntity create(final ObjectEntity toBeCreated) {
        return objectRepository.save(toBeCreated);
    }

    public Page<ObjectEntity> getAllObjects(final ObjectEntity filter, final Pageable paging) {
        return objectRepository.findAll(Example.of(filter), paging);
    }
}
