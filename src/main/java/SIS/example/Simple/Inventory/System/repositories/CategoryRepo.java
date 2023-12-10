package SIS.example.Simple.Inventory.System.repositories;

import SIS.example.Simple.Inventory.System.commons.domains.entities.Category;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM category", nativeQuery = true)
    List<Category> getCategories();

    @Query(value = "SELECT * FROM category WHERE category_id = categoryId ", nativeQuery = true)
    Category getCategoryById(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * FROM product p WHERE p.category_id = :categoryId", nativeQuery = true)
    List<Product> getProductsByCategoryId(@Param("categoryId") Long categoryId);
}