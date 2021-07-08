package com.example.isandstesttask.filter.metamodel;

import com.example.isandstesttask.entity.product.VacuumCleanerImpl;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VacuumCleanerImpl.class)
public abstract class VacuumCleanerImpl_ extends BaseProductImpl_ {

    public static final String MODES_NUMBER = "ModesNumber";
    public static final String DUST_CONTAINER_VOLUME = "DustContainerVolume";
    public static final String PRODUCT_TYPE = "productType";
    public static volatile SingularAttribute<VacuumCleanerImpl, Integer> ModesNumber;
    public static volatile SingularAttribute<VacuumCleanerImpl, BigDecimal> DustContainerVolume;
    public static volatile SingularAttribute<VacuumCleanerImpl, String> productType;
}