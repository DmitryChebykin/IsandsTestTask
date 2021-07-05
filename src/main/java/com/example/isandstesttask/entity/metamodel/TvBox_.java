package com.example.isandstesttask.entity.metamodel;

import com.example.isandstesttask.entity.product.TvBox;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TvBox.class)
public abstract class TvBox_ extends BaseProduct_ {

	public static volatile SingularAttribute<TvBox, String> technology;
	public static volatile SingularAttribute<TvBox, String> category;

	public static final String TECHNOLOGY = "technology";
	public static final String CATEGORY = "category";

}