package SIS.example.Simple.Inventory.System.controllers;

import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ICategoryController {

    @PostMapping
    ResponseEntity<SerializedResponse> registerCategory(@RequestBody CategoryDTO categoryDTO);
    @GetMapping
    ResponseEntity<SerializedResponse> readCategoryById(@PathVariable Long categoryId);
    @GetMapping
    ResponseEntity<SerializedResponse> readAll();
    @GetMapping
    ResponseEntity<SerializedResponse> getProductsByCategory(@PathVariable Long categoryId);
    @PutMapping
    ResponseEntity<SerializedResponse> updatedCategory(@RequestBody CategoryDTO categoryDTO);
    @DeleteMapping
    ResponseEntity<SerializedResponse> deleteCategory(@PathVariable Long categoryId);
}
