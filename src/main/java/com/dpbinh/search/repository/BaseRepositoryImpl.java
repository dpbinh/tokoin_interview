package com.dpbinh.search.repository;

import com.dpbinh.search.domain.BaseEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class BaseRepositoryImpl<T extends BaseEntity> implements BaseRepository {
    private Map<Object, T> idIndexMap;
    private Set<T> entities;

    public BaseRepositoryImpl(String entitiesPath, TypeReference<List<T>> typeReference) throws IOException {
        load(entitiesPath, typeReference);
    }

    @Override
    public Set findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public Optional findOneById(Object id) {
        return Optional.ofNullable(idIndexMap.get(id));
    }

    private void load(String entitiesPath, TypeReference<List<T>> typeReference) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        List<T> loadedEntities = objectMapper.readValue(new File(entitiesPath), typeReference);

        if(loadedEntities == null || loadedEntities.size() == 0) {
            return;
        }

        idIndexMap = loadedEntities.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getId() != null)
                .collect(Collectors.toMap(p -> p.getId(), p -> p, (o1, o2) -> o2));
        entities = new HashSet<>(loadedEntities);
    }
}
