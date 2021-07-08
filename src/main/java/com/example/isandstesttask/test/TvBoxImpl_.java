package com.example.isandstesttask.test;

import com.example.isandstesttask.filter.metamodel.BaseProductImpl_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RefrigeratorImpl.class)
public abstract class TvBoxImpl_ extends BaseProductImpl_ {

	public static volatile SingularAttribute<RefrigeratorImpl, String> technology;
	public static volatile SingularAttribute<RefrigeratorImpl, String> category;
	public static volatile SingularAttribute<RefrigeratorImpl, String> productType;

	public static final String TECHNOLOGY = "technology";
	public static final String CATEGORY = "category";
	public static final String PRODUCT_TYPE = "productType";

}