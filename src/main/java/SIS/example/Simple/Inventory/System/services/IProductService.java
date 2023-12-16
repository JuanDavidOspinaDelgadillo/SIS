package SIS.example.Simple.Inventory.System.services;

import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface IProductService {
    ResponseEntity<SerializedResponse> registerProduct(ProductDTO productDTO);
    ResponseEntity<SerializedResponse> readProductById(Long productId);
    ResponseEntity<SerializedResponse> readAll();
    ResponseEntity<SerializedResponse> updateProduct(ProductDTO productDTO);
    ResponseEntity<SerializedResponse> deleteProduct(Long productId);
}