package com.example.isandstesttask.filter.metamodel;

import com.example.isandstesttask.entity.BaseProductImpl;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseProductImpl.class)
public abstract class BaseProductImpl_ extends BaseEntityImpl_ {

	public static volatile SingularAttribute<BaseProductImpl, String> modelName;
	public static volatile SingularAttribute<BaseProductImpl, Color> colorName;
	public static volatile SingularAttribute<BaseProductImpl, Brand> brandName;
	public static volatile SingularAttribute<BaseProductImpl, String> serialNumber;
	public static volatile SingularAttribute<BaseProductImpl, String> size;
	public static volatile SingularAttribute<BaseProductImpl, BigDecimal> price;
	public static volatile SingularAttribute<BaseProductImpl, String> producingCountry;
	public static volatile SingularAttribute<BaseProductImpl, Boolean> available;
	public static volatile SingularAttribute<BaseProductImpl, Boolean> isSoldByInstallments;
	public static volatile SingularAttribute<BaseProductImpl, Boolean> isOnlineOrdering;
	public static volatile SingularAttribute<BaseProductImpl, String> productType;

	public static final String MODEL_NAME = "modelName";
	public static final String COLOR_NAME = "colorName";
	public static final String BRAND_NAME = "brandName";
	public static final String SERIAL_NUMBER = "serialNumber";
	public static final String SIZE = "size";
	public static final String PRICE = "price";
	public static final String PRODUCING_COUNTRY = "producingCountry";
	public static final String AVAILABLE = "available";
	public static final String IS_SOLD_BY_INSTALLMENTS = "isSoldByInstallments";
	public static final String IS_ONLINE_ORDERING = "isOnlineOrdering";
	public static final String PRODUCT_TYPE = "productType";

}