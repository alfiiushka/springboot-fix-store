package ru.ivmiit.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ivmiit.store.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
