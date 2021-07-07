package com.example.isandstesttask.repository.product;

import com.example.isandstesttask.entity.BaseProductImpl;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface ProductRepository<E extends BaseProductImpl> extends JpaRepository<E, UUID>, JpaSpecificationExecutor<E> {
    @Override
    List<E> findAll(Specification<E> specification);
}