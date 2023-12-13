package SIS.example.Simple.Inventory.System.repositories;

import SIS.example.Simple.Inventory.System.commons.domains.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepo extends JpaRepository<Product, Long> {
 @Transactional
 @Modifying
 @Query(value = "INSERT INTO product (register_date, name) VALUES (:#{#product.registerDate}, :#{#product.name})", nativeQuery = true)
 void createProduct(@Param("product") Product product);
}