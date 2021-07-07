package com.example.isandstesttask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public class BaseEntityImpl implements BaseEntity {
    @Id
    @Generated(GenerationTime.INSERT)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    @Getter
    UUID id;

    @JsonIgnore
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @JsonIgnore
    @UpdateTimestamp
    private Timestamp lastModifiedDate;

    public BaseEntityImpl(Timestamp createdDate, Timestamp lastModifiedDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}