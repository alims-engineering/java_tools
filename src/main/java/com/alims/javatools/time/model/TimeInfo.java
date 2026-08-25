package com.alims.javatools.time.model;

import java.time.Instant;

public class TimeInfo {

    protected Instant createdAt;
    protected Instant lastModifiedAt;

    // ====================================
    // Constructor
    // ====================================
    public TimeInfo() {
        Instant now = Instant.now();

        this.createdAt = now;
        this.lastModifiedAt = now;
    }

    public TimeInfo(
            Instant lastModifiedAt
    ) {
        this.createdAt = Instant.now();
        this.lastModifiedAt = lastModifiedAt;
    }

    public TimeInfo(
            Instant createdAt,
            Instant lastModifiedAt
    ) {
        this.createdAt = createdAt;
        this.lastModifiedAt = lastModifiedAt;
    }

    // ====================================
    // Getter
    // ====================================
    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getLastModifiedAt() {
        return lastModifiedAt;
    }
    // ====================================
    // Setter
    // ====================================

    /**
     * @return the previous value
     */
    public Instant setLastModifiedAt(
            Instant lastModifiedAt
    ) {
        Instant oldValue = this.lastModifiedAt;
        this.lastModifiedAt = lastModifiedAt;
        return oldValue;
    }
}
