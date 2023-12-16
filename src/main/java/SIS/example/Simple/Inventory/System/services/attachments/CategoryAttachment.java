package SIS.example.Simple.Inventory.System.services.attachments;

import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.SISBadRequestException;
import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.SISInternalServerErrorException;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses.GeneralResponses;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.CategoryDTO;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Category;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Product;
import SIS.example.Simple.Inventory.System.commons.mapper.mappedEntities.CategoryMapper;
import SIS.example.Simple.Inventory.System.repositories.CategoryRepo;
import SIS.example.Simple.Inventory.System.services.ICategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
@Log4j2
public class CategoryAttachment implements ICategoryService {
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryAttachment(CategoryRepo categoryRepo, CategoryMapper categoryMapper){
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ResponseEntity<SerializedResponse> registerCategory(CategoryDTO categoryDTO) {
        try {
            Optional<Category> categoryExist = this.categoryRepo.getCategoryById(categoryDTO.getId());
            if (categoryExist.isPresent()){
                Category category = this.categoryMapper.mapCategoryDTOToCategoryEntity(categoryDTO);
                this.categoryRepo.createCategory(category);
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .object(GeneralResponses.CORRECT_RESPONSE)
                        .httpStatus(HttpStatus.OK)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> readCategoryById(Long categoryId) {
        try {
            Optional<Category> categoryExist = this.categoryRepo.getCategoryById(categoryId);
            if (categoryExist.isPresent()) {
                Category category = categoryExist.get();
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(category)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> readAll() {
        try {
            List<Category> categoryList = this.categoryRepo.getCategories();
            if (!categoryList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(categoryList)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> getProductsByCategory(Long categoryId) {
        try {
            List<Product> productList = this.categoryRepo.getProductsByCategoryId(categoryId);
            if (!productList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(productList)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> updatedCategory(CategoryDTO categoryDTO) {
        try {
            Optional<Category> categoryExist = this.categoryRepo.getCategoryById(categoryDTO.getId());
            if (categoryExist.isPresent()) {
                Category category = this.categoryMapper.mapCategoryDTOToCategoryEntity(categoryDTO);
                this.categoryRepo.updateCategory(category);
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(GeneralResponses.CORRECT_RESPONSE)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> deleteCategory(Long categoryId) {
        try {
            Optional<Category> categoryExist = this.categoryRepo.getCategoryById(categoryId);
            if (categoryExist.isPresent()) {
                this.categoryRepo.deleteByCategoryId(categoryId);
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(GeneralResponses.CORRECT_RESPONSE)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }
}