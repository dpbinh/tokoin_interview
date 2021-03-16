package com.dpbinh.search.repository;

import com.dpbinh.search.entity.BaseEntity;

import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public interface BaseRepository<T extends BaseEntity> {
    Set<T> findBy(Predicate<T> predicate);

    Optional<T> findOneById(Object id);
}
