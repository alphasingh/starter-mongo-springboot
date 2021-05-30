package com.uwindsor.mongo.entity;

import org.springframework.data.domain.Sort;

public enum DataSortOrder {
    ASC {
        @Override
        public Sort getSort(final String sortBy) {
            return Sort.by(sortBy).ascending();
        }
    },
    DESC {
        @Override
        public Sort getSort(final String sortBy) {
            return Sort.by(sortBy).descending();
        }
    };

    public abstract Sort getSort(String sortBy);
}