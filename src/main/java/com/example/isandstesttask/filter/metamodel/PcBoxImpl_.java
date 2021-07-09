package com.example.isandstesttask.filter.metamodel;

import com.example.isandstesttask.filter.metamodel.BaseProductImpl_;
import com.example.isandstesttask.test.PcBoxImpl;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PcBoxImpl.class)
public abstract class PcBoxImpl_ extends BaseProductImpl_ {

	public static volatile SingularAttribute<PcBoxImpl, String> processorType;
	public static volatile SingularAttribute<PcBoxImpl, String> category;
	public static volatile SingularAttribute<PcBoxImpl, String> productType;

	public static final String PROCESSOR_TYPE = "processorType";
	public static final String CATEGORY = "category";
	public static final String PRODUCT_TYPE = "productType";

}