package com.example.isandstesttask.entity.reference;

import com.example.isandstesttask.entity.BaseEntity;
import com.example.isandstesttask.entity.product.TvBox;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Table(name = "colors")
@Entity

@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate

@Setter
@Getter
@NoArgsConstructor
public class Color extends BaseEntity {
    @Column(unique = true)
    private String colorName;

    @JsonIgnore
    @OneToMany(mappedBy = "colorName", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TvBox> tvBoxes;

    public Color(Timestamp createdDate, Timestamp lastModifiedDate, String colorName) {
        super(createdDate, lastModifiedDate);
        this.colorName = colorName;
    }

    @Override
    public int hashCode() {
        return getColorName().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Color)) {
            return false;
        }

        Color color = (Color) o;

        return getColorName().equals(color.getColorName());
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public static final class ColorBuilder {
        UUID id;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;
        private String colorName;
        private List<TvBox> tvBoxes;

        private ColorBuilder() {
        }

        public static ColorBuilder aColor() {
            return new ColorBuilder();
        }

        public ColorBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public ColorBuilder withCreatedDate(Timestamp createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public ColorBuilder withLastModifiedDate(Timestamp lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return this;
        }

        public ColorBuilder withColorName(String colorName) {
            this.colorName = colorName;
            return this;
        }

        public ColorBuilder withTvBoxes(List<TvBox> tvBoxes) {
            this.tvBoxes = tvBoxes;
            return this;
        }

        public ColorBuilder but() {
            return aColor().withId(id).withCreatedDate(createdDate).withLastModifiedDate(lastModifiedDate).withColorName(colorName).withTvBoxes(tvBoxes);
        }

        public Color build() {
            Color color = new Color();
            color.setId(id);
            color.setCreatedDate(createdDate);
            color.setLastModifiedDate(lastModifiedDate);
            color.setColorName(colorName);
            color.setTvBoxes(tvBoxes);
            return color;
        }
    }
}