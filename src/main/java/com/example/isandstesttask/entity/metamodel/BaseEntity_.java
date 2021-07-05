package com.example.isandstesttask.entity.metamodel;

import com.example.isandstesttask.entity.BaseEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;
import java.util.UUID;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntity.class)
public abstract class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, Timestamp> createdDate;
	public static volatile SingularAttribute<BaseEntity, Timestamp> lastModifiedDate;
	public static volatile SingularAttribute<BaseEntity, UUID> id;

	public static final String CREATED_DATE = "createdDate";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String ID = "id";

}