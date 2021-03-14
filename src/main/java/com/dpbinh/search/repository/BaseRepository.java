package com.dpbinh.search.repository;

import com.dpbinh.search.domain.BaseEntity;

import java.util.Optional;
import java.util.Set;

public interface BaseRepository<T extends BaseEntity> {
    Set<T> findBy(String fieldName, Object value);

    Optional<T> findOneById(Long id);
}
