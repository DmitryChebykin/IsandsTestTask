package com.example.isandstesttask.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "colors")
@Setter
@Getter
@NoArgsConstructor
public class Color extends BaseEntity {
    @Column(unique = true)
    private String colorName;

    public Color(UUID id, Timestamp createdDate, Timestamp lastModifiedDate, String colorName) {
        super(id, createdDate, lastModifiedDate);
        this.colorName = colorName;
    }
}