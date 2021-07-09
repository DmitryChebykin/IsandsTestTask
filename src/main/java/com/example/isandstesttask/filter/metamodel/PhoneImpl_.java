package com.example.isandstesttask.filter.metamodel;

import com.example.isandstesttask.entity.product.PhoneImpl;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PhoneImpl.class)
public abstract class PhoneImpl_ extends  BaseProductImpl_ {

	public static volatile SingularAttribute<PhoneImpl, Integer> memorySize;
	public static volatile SingularAttribute<PhoneImpl, Integer> camerasNumber;
	public static volatile SingularAttribute<PhoneImpl, String> productType;

	public static final String MEMORY_SIZE = "memorySize";
	public static final String CAMERAS_NUMBER = "camerasNumber";
	public static final String PRODUCT_TYPE = "productType";

}