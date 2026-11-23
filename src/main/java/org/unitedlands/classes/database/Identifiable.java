package org.unitedlands.classes.database;

import java.util.UUID;

public interface Identifiable {
    UUID getUuid();
    void setUuid(UUID id);
}