package com.example.isandstesttask.filter.metamodel;

import com.example.isandstesttask.entity.product.RefrigeratorImpl;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RefrigeratorImpl.class)
public abstract class RefrigeratorImpl_ extends com.example.isandstesttask.entity.BaseProductImpl_ {

	public static volatile SingularAttribute<RefrigeratorImpl, Integer> doorsNumber;
	public static volatile SingularAttribute<RefrigeratorImpl, String> compressorType;
	public static volatile SingularAttribute<RefrigeratorImpl, String> productType;

	public static final String DOORS_NUMBER = "doorsNumber";
	public static final String COMPRESSOR_TYPE = "compressorType";
	public static final String PRODUCT_TYPE = "productType";

}