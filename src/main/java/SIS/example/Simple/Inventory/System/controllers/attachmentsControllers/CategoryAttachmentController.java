package SIS.example.Simple.Inventory.System.controllers.attachmentsControllers;

import SIS.example.Simple.Inventory.System.commons.constants.URLs.ICategoryEndPoints;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.CategoryDTO;
import SIS.example.Simple.Inventory.System.controllers.ICategoryController;
import SIS.example.Simple.Inventory.System.services.attachmentsServices.CategoryAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ICategoryEndPoints.URL_BASE_CATEGORY)
public class CategoryAttachmentController implements ICategoryController {

    private final CategoryAttachmentService categoryAttachmentService;

    @Autowired
    public CategoryAttachmentController(CategoryAttachmentService categoryAttachmentService){
        this.categoryAttachmentService = categoryAttachmentService;
    }
    @Override
    @PostMapping(ICategoryEndPoints.URL_REGISTER_CATEGORY)
    public ResponseEntity<SerializedResponse> registerCategory(@RequestBody CategoryDTO categoryDTO) {
        return this.categoryAttachmentService.registerCategory(categoryDTO);
    }

    @Override
    @GetMapping(ICategoryEndPoints.URL_READ_A_CATEGORY)
    public ResponseEntity<SerializedResponse> readCategoryById(@PathVariable Long categoryId) {
        return this.categoryAttachmentService.readCategoryById(categoryId);
    }

    @Override
    @GetMapping(ICategoryEndPoints.URL_READ_ALL_CATEGORY)
    public ResponseEntity<SerializedResponse> readAll() {
        return this.categoryAttachmentService.readAll();
    }

    @Override
    @GetMapping(ICategoryEndPoints.URL_READ_ALL_PRODUCTS_BY_CATEGORY)
    public ResponseEntity<SerializedResponse> getProductsByCategory(@PathVariable Long categoryId) {
        return this.categoryAttachmentService.getProductsByCategory(categoryId);
    }

    @Override
    @PutMapping(ICategoryEndPoints.URL_UPDATE_CATEGORY)
    public ResponseEntity<SerializedResponse> updatedCategory(@RequestBody CategoryDTO categoryDTO) {
        return this.categoryAttachmentService.updatedCategory(categoryDTO);
    }

    @Override
    @DeleteMapping(ICategoryEndPoints.URL_DELETE_CATEGORY)
    public ResponseEntity<SerializedResponse> deleteCategory(@PathVariable Long categoryId) {
        return this.categoryAttachmentService.deleteCategory(categoryId);
    }
}