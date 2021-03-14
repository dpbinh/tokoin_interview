package com.dpbinh.search.repository;

import com.dpbinh.search.domain.BaseEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class BaseRepositoryImpl<T extends BaseEntity> implements BaseRepository {
    private Map<Long, T> idIndexMap;
    private Set<T> entities;

    public BaseRepositoryImpl(String entitiesPath) throws IOException {
        load(entitiesPath);
    }

    @Override
    public Set findBy(String fieldName, Object value) {
        return null;
    }

    @Override
    public Optional findOneById(Long id) {
        return Optional.empty();
    }

    private void load(String entitiesPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<T> loadedEntities = objectMapper.readValue(new File(entitiesPath), new TypeReference<List<T>>() {});

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
