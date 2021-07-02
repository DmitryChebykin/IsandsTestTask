package com.example.isandstesttask.entity.reference;

import com.example.isandstesttask.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "brands")
@Setter
@Getter
@NoArgsConstructor
public class Brand extends BaseEntity {
    @Column(unique = true)

    private String brandName;

    public Brand(UUID id, Timestamp createdDate, Timestamp lastModifiedDate, String brandName) {
        super(id, createdDate, lastModifiedDate);
        this.brandName = brandName;
    }
}