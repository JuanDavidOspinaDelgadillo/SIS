package SIS.example.Simple.Inventory.System.repositories;

import SIS.example.Simple.Inventory.System.commons.domains.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
 @Transactional
 @Modifying
 @Query(value = "INSERT INTO product (register_date, name) VALUES (:#{#product.registerDate}, :#{#product.name})", nativeQuery = true)
 void createProduct(@Param("product") Product product);

 @Query(value = "SELECT * FROM product p WHERE p.product_id = :productId", nativeQuery = true)
 Product getProductByProductId(@Param("productId") Long productId);

 @Query(value = "SELECT * FROM product", nativeQuery = true)
 List<Product> getAll();

 @Transactional
 @Modifying
 @Query(value = "UPDATE product SET name = :#{#product.name}, register_date = :#{#product.registerDate}", nativeQuery = true)
 void updateProduct(@Param("product") Product product);

 @Transactional
 @Modifying
 @Query(value = "DELETE FROM product p WHERE p.product_id = :productId", nativeQuery = true)
 void deleteByProductId(@Param("productId") Long productId);
}