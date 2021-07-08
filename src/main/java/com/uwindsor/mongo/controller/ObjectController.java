package com.uwindsor.mongo.controller;

import com.uwindsor.mongo.adapter.ObjectAdapter;
import com.uwindsor.mongo.dto.ObjectCollectionDto;
import com.uwindsor.mongo.dto.ObjectDto;
import com.uwindsor.mongo.entity.ObjectEntity;
import com.uwindsor.mongo.entity.DataSortOrder;
import com.uwindsor.mongo.service.ObjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__({@Autowired, @Lazy}))
@RequestMapping(value = "/objects")
@CrossOrigin
public class ObjectController {

    private final ObjectService objectService;

    @PostMapping(
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectDto> createObject(
            @RequestBody @Valid final ObjectDto objectDto) {
        log.info("Received request to create object {}", objectDto);
        final ObjectEntity objectToBeCreated = ObjectAdapter.adapt(objectDto);
        final ObjectEntity objectCreated = objectService.create(objectToBeCreated);
        return new ResponseEntity<>(ObjectAdapter.adapt(objectCreated), HttpStatus.OK);
    }

    @GetMapping(
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectCollectionDto> getAllObjects(
            @RequestParam(name = "pageNumber", defaultValue = "0") final int pageNumber,
            @RequestParam(name = "pageSize", defaultValue = "10") final int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") final String sortBy,
            @RequestParam(name = "dataSortOrder", defaultValue = "DESC") final DataSortOrder sortOrder,
            final ObjectDto filters) {
        log.info("Request to get details of all the objects");
        log.info("Page#{} of size {} sorted by {} in {} order", pageNumber, pageSize, sortBy, sortOrder);
        final ObjectEntity filter = ObjectAdapter.adapt(filters);
        final Pageable paging = PageRequest.of(pageNumber, pageSize, sortOrder.getSort(sortBy));
        final Page<ObjectEntity> page = objectService.getAllObjects(filter, paging);
        final ObjectCollectionDto collectionResponse = ObjectAdapter.adaptCollection(page);
        return new ResponseEntity<>(collectionResponse, HttpStatus.OK);
    }
}