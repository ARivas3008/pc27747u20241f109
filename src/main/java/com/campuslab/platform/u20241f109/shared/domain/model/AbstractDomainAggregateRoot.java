package com.campuslab.platform.u20241f109.shared.domain.model;

import java.time.Instant;
import java.util.Objects;

public abstract class AbstractDomainAggregateRoot {
    private final Long id;
    private final Instant createdAt;
    private final Instant updatedAt;

    protected AbstractDomainAggregateRoot() {
        this(null, Instant.now());
    }

    private AbstractDomainAggregateRoot(Long id, Instant creationInstant) {
        this(id, creationInstant, creationInstant);
    }

    protected AbstractDomainAggregateRoot(Long id, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.createdAt = Objects.requireNonNull(createdAt, "Creation timestamp is required");
        this.updatedAt = Objects.requireNonNull(updatedAt, "Update timestamp is required");
    }

    public Long getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}