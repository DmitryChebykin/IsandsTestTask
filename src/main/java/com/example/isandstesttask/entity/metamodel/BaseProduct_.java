package com.example.isandstesttask.entity.metamodel;

import com.example.isandstesttask.entity.BaseProduct;
import com.example.isandstesttask.entity.reference.Brand;
import com.example.isandstesttask.entity.reference.Color;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseProduct.class)
public abstract class BaseProduct_ extends BaseEntity_ {

	public static volatile SingularAttribute<BaseProduct, String> modelName;
	public static volatile SingularAttribute<BaseProduct, Color> colorName;
	public static volatile SingularAttribute<BaseProduct, Brand> brandName;
	public static volatile SingularAttribute<BaseProduct, String> serialNumber;
	public static volatile SingularAttribute<BaseProduct, String> size;
	public static volatile SingularAttribute<BaseProduct, BigDecimal> price;
	public static volatile SingularAttribute<BaseProduct, String> producingCountry;
	public static volatile SingularAttribute<BaseProduct, Boolean> available;
	public static volatile SingularAttribute<BaseProduct, Boolean> isSoldByInstallments;
	public static volatile SingularAttribute<BaseProduct, Boolean> isOnlineOrdering;
	public static volatile SingularAttribute<BaseProduct, String> productType;

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