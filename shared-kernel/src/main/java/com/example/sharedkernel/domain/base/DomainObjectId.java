package com.example.sharedkernel.domain.base;

import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Embeddable
@Getter
public class DomainObjectId implements Serializable {

    private String id;

    @JsonCreator
    protected DomainObjectId(@NonNull String uuid) {
        this.id = Objects.requireNonNull(uuid, "cannot be null");
    }

    public DomainObjectId() {}

    @NonNull
    public static <ID extends DomainObjectId> ID randomId(@NonNull Class<ID> idClass) {
        Objects.requireNonNull(idClass, "cannot be null");
        try {
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        }
        catch (Exception ex) {
            throw new RuntimeException("cannot create instance of " + idClass, ex);
        }
    }
}
