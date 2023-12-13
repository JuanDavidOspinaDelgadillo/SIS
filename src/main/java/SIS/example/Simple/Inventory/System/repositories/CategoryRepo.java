package SIS.example.Simple.Inventory.System.repositories;

import SIS.example.Simple.Inventory.System.commons.domains.entities.Category;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO category (name) VALUES (:#{#category.name})", nativeQuery = true)
    void createCategory(Category category);

    @Query(value = "SELECT * FROM category", nativeQuery = true)
    List<Category> getCategories();

    @Query(value = "SELECT * FROM category WHERE category_id = :categoryId ", nativeQuery = true)
    Category getCategoryById(@Param("categoryId") Long categoryId);

    @Query(value = "SELECT * FROM product p WHERE p.category_id = :categoryId", nativeQuery = true)
    List<Product> getProductsByCategoryId(@Param("categoryId") Long categoryId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE category SET name = :#{#category.name} WHERE category_id = :#{#category.categoryId}", nativeQuery = true)
    void updateCategoryByCategoryId(@Param("category") Category category);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM category WHERE category_id = :categoryId", nativeQuery = true)
    void deleteByCategoryId(@Param("categoryId") Long categoryId);
}