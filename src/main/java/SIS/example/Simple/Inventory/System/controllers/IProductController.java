package SIS.example.Simple.Inventory.System.controllers;

import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IProductController {

    @PostMapping
    ResponseEntity<SerializedResponse> registerProduct(@RequestBody ProductDTO productDTO);
    @GetMapping
    ResponseEntity<SerializedResponse> readProductById(@PathVariable Long productId);
    @GetMapping
    ResponseEntity<SerializedResponse> readAll();
    @PutMapping
    ResponseEntity<SerializedResponse> updateProduct(@RequestBody ProductDTO productDTO);
    @DeleteMapping
    ResponseEntity<SerializedResponse> deleteProduct(@PathVariable Long productId);
}