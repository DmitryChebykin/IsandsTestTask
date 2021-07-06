package com.example.isandstesttask.entity.product;

import com.example.isandstesttask.entity.BaseField;
import com.example.isandstesttask.entity.DBField;
import java.util.Map;

public interface Product extends DBField, BaseField {
   Map<String, String> getProperties();
}