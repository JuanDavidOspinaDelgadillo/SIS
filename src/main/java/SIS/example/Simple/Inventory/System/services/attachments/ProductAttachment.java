package SIS.example.Simple.Inventory.System.services.attachments;

import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.SISBadRequestException;
import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.SISInternalServerErrorException;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses.GeneralResponses;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.ProductDTO;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Product;
import SIS.example.Simple.Inventory.System.commons.mapper.mappedEntities.ProductMapper;
import SIS.example.Simple.Inventory.System.repositories.ProductRepo;
import SIS.example.Simple.Inventory.System.services.IProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Log4j2
@Service
public class ProductAttachment implements IProductService {

    private final ProductMapper productMapper;
    private final ProductRepo productRepo;

    @Autowired
    public ProductAttachment(ProductMapper productMapper, ProductRepo productRepo){
        this.productMapper = productMapper;
        this.productRepo = productRepo;
    }
    @Override
    public ResponseEntity<SerializedResponse> registerProduct(ProductDTO productDTO) {
        try {
            Optional<Product> productExist = this.productRepo.getProductByProductId(productDTO.getId());
            if(productExist.isPresent()) {
                Product product = this.productMapper.mapProductDTOToProductEntity(productDTO);
                this.productRepo.registerProduct(product);
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
    public ResponseEntity<SerializedResponse> readProductById(Long productId) {
        try {
            Optional<Product> productExist = this.productRepo.getProductByProductId(productId);
            if(productExist.isPresent()) {
                Product product = productExist.get();
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(product)
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
            List<Product> productList = this.productRepo.getAll();
            if(!productList.isEmpty()) {
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
    public ResponseEntity<SerializedResponse> updateProduct(ProductDTO productDTO) {
        try {
            Optional<Product> productExist = this.productRepo.getProductByProductId(productDTO.getId());
            if (productExist.isPresent()) {
                Product product = this.productMapper.mapProductDTOToProductEntity(productDTO);
                this.productRepo.updateProduct(product);
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
    public ResponseEntity<SerializedResponse> deleteProduct(Long productId) {
        try {
            Optional<Product> productExist = this.productRepo.getProductByProductId(productId);
            if (productExist.isPresent()) {
                this.productRepo.deleteByProductId(productId);
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