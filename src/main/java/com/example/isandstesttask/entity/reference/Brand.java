package com.example.isandstesttask.entity.reference;

import com.example.isandstesttask.entity.BaseEntity;
import com.example.isandstesttask.entity.product.TvBox;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "brands")
@Setter
@Getter
@NoArgsConstructor
public class Brand extends BaseEntity {
    @Column(unique = true)
    private String brandName;

    @JsonIgnore
    @OneToMany(mappedBy = "brandName", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TvBox> tvBoxes;

    public Brand(Timestamp createdDate, Timestamp lastModifiedDate, String brandName) {
        super(createdDate, lastModifiedDate);
        this.brandName = brandName;
    }

    @Override
    public int hashCode() {
        return brandName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Brand brand = (Brand) o;

        return brandName.equals(brand.brandName);
    }

    public static final class BrandBuilder {
        UUID id;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private String brandName;
        private List<TvBox> tvBoxes;

        private BrandBuilder() {
        }

        public static BrandBuilder aBrand() {
            return new BrandBuilder();
        }

        public BrandBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public BrandBuilder createdDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public BrandBuilder lastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public BrandBuilder brandName(String brandName) {
            this.brandName = brandName;
            return this;
        }

        public BrandBuilder tvBoxes(List<TvBox> tvBoxes) {
            this.tvBoxes = tvBoxes;
            return this;
        }

        public BrandBuilder but() {
            return aBrand().id(id).createdDate(createdDate).lastModifiedDate(lastModifiedDate).brandName(brandName).tvBoxes(tvBoxes);
        }

        public Brand build() {
            Brand brand = new Brand();
            brand.setId(id);
            brand.setCreatedDate(createdDate);
            brand.setLastModifiedDate(lastModifiedDate);
            brand.setBrandName(brandName);
            brand.setTvBoxes(tvBoxes);
            return brand;
        }
    }
}