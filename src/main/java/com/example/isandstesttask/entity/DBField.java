package com.example.isandstesttask.entity;

public interface DBField {
    void setId(java.util.UUID id);

    void setCreatedDate(java.sql.Timestamp createdDate);

    void setLastModifiedDate(java.sql.Timestamp lastModifiedDate);

    java.util.UUID getId();

    java.sql.Timestamp getCreatedDate();

    java.sql.Timestamp getLastModifiedDate();
}