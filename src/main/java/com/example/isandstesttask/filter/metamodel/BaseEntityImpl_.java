package com.example.isandstesttask.filter.metamodel;

import com.example.isandstesttask.entity.BaseEntityImpl;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;
import java.util.UUID;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntityImpl.class)
public abstract class BaseEntityImpl_ {

    public static final String CREATED_DATE = "createdDate";
    public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
    public static final String ID = "id";
    public static volatile SingularAttribute<BaseEntityImpl, Timestamp> createdDate;
    public static volatile SingularAttribute<BaseEntityImpl, Timestamp> lastModifiedDate;
    public static volatile SingularAttribute<BaseEntityImpl, UUID> id;
}