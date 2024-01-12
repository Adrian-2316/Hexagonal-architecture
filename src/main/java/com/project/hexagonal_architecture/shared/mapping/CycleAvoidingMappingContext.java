package com.project.hexagonal_architecture.shared.mapping;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Context;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A type to be used as {@link Context} parameter to track cycles in graphs.
 *
 * <p>Depending on the actual use case, the two methods below could also be changed to only accept
 * certain argument types, e.g. base classes of graph nodes, avoiding the need to capture any other
 * objects that wouldn't necessarily result in cycles.
 */
public class CycleAvoidingMappingContext implements Iterable<Map.Entry<Object, Object>> {
    private final Map<Object, Object> knownInstances = new IdentityHashMap<>();

    @BeforeMapping
    public <T> T getMappedInstance(Object source, @TargetType Class<T> targetType) {
        return (T) knownInstances.get(source);
    }

    @BeforeMapping
    public void storeMappedInstance(Object source, @MappingTarget Object target) {
        knownInstances.put(source, target);
    }

    @Override
    public Iterator<Map.Entry<Object, Object>> iterator() {
        return knownInstances.entrySet().iterator();
    }

    public void clear() {
        knownInstances.clear();
    }

    public void clearInstances() {
        knownInstances.clear();
    }
}
