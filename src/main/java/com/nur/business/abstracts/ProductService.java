package com.nur.business.abstracts;


import com.nur.business.dto.requests.create.CreateProductRequest;
import com.nur.business.dto.requests.update.UpdateProductRequest;
import com.nur.business.dto.responses.create.CreateProductResponse;
import com.nur.business.dto.responses.get.GetAllProductsResponse;
import com.nur.business.dto.responses.update.UpdateProductResponse;
import com.nur.entities.Product;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll(Integer pageNo, Integer pageSize);
    Product getProduct(Long id);
    CreateProductResponse createProduct(CreateProductRequest request);
    UpdateProductResponse updateProduct(Long id, UpdateProductRequest request);
    void deleteProduct(Long id);



}
