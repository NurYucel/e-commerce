package com.nur.api;

import com.nur.business.abstracts.ProductService;
import com.nur.business.dto.requests.create.CreateProductRequest;
import com.nur.business.dto.requests.update.UpdateProductRequest;
import com.nur.business.dto.responses.create.CreateProductResponse;
import com.nur.business.dto.responses.get.GetAllProductsResponse;
import com.nur.business.dto.responses.update.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductsController {
    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll(@RequestParam Integer page,@RequestParam Integer size){
        return service.getAll(page, size);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable Long id, @RequestBody UpdateProductRequest request){
        return service.updateProduct(id,request);
    }

    @PutMapping("create-product")
    public CreateProductResponse createProduct(@PathVariable CreateProductRequest request){
        return service.createProduct(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.deleteProduct(id);
    }
}
