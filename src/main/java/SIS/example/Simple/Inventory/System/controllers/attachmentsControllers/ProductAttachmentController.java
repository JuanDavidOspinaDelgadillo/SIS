package SIS.example.Simple.Inventory.System.controllers.attachmentsControllers;

import SIS.example.Simple.Inventory.System.commons.constants.URLs.IProductEndPoints;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.ProductDTO;
import SIS.example.Simple.Inventory.System.controllers.IProductController;
import SIS.example.Simple.Inventory.System.services.attachmentsServices.ProductAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IProductEndPoints.URL_BASE_PRODUCT)
public class ProductAttachmentController implements IProductController {

    private final ProductAttachmentService productAttachmentService;

    @Autowired
    public ProductAttachmentController(ProductAttachmentService productAttachmentService){
        this.productAttachmentService = productAttachmentService;
    }
    @Override
    @PostMapping(IProductEndPoints.URL_REGISTER_PRODUCT)
    public ResponseEntity<SerializedResponse> registerProduct(@RequestBody ProductDTO productDTO) {
        return this.productAttachmentService.registerProduct(productDTO);
    }

    @Override
    @GetMapping(IProductEndPoints.URL_READ_A_PRODUCT)
    public ResponseEntity<SerializedResponse> readProductById(@PathVariable Long productId) {
        return this.productAttachmentService.readProductById(productId);
    }

    @Override
    @GetMapping(IProductEndPoints.URL_READ_ALL_PRODUCTS)
    public ResponseEntity<SerializedResponse> readAll() {
        return this.productAttachmentService.readAll();
    }

    @Override
    @PutMapping(IProductEndPoints.URL_UPDATE_A_PRODUCT)
    public ResponseEntity<SerializedResponse> updateProduct(@RequestBody ProductDTO productDTO) {
        return this.productAttachmentService.updateProduct(productDTO);
    }

    @Override
    @DeleteMapping(IProductEndPoints.URL_DELETE_A_PRODUCT)
    public ResponseEntity<SerializedResponse> deleteProduct(@PathVariable Long productId) {
        return this.productAttachmentService.deleteProduct(productId);
    }
}