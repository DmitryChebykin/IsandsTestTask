package com.example.isandstesttask.repository;

import com.example.isandstesttask.entity.BaseField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.UUID;

@NoRepositoryBean
public interface GenericProductRepository<E extends BaseField> extends JpaRepository<E, UUID>, JpaSpecificationExecutor<E> {
}