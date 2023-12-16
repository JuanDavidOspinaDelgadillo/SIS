package SIS.example.Simple.Inventory.System.services;

import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.io.Serial;

public interface ICategoryService {
    ResponseEntity<SerializedResponse> registerCategory(CategoryDTO categoryDTO);
    ResponseEntity<SerializedResponse> readCategoryById(Long categoryId);
    ResponseEntity<SerializedResponse> readAll();
    ResponseEntity<SerializedResponse> getProductsByCategory(Long categoryId);
    ResponseEntity<SerializedResponse> updatedCategory(CategoryDTO categoryDTO);
    ResponseEntity<SerializedResponse> deleteCategory(Long categoryId);
}