package com.nur.business.concretes;

import com.nur.business.abstracts.ProductService;
import com.nur.business.dto.requests.create.CreateProductRequest;
import com.nur.business.dto.requests.update.UpdateProductRequest;
import com.nur.business.dto.responses.create.CreateProductResponse;
import com.nur.business.dto.responses.get.GetAllProductsResponse;
import com.nur.business.dto.responses.update.UpdateProductResponse;
import com.nur.business.rules.ProductBusinessRules;
import com.nur.entities.Product;
import com.nur.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;
    private final ModelMapper mapper;
    private final ProductBusinessRules rules;

    @Override
    public List<GetAllProductsResponse> getAll(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.asc("name")));
        Page<Product> products = repository.findAll(paging);
        return products
                .stream()
                .map(product -> mapper.map(product, GetAllProductsResponse.class))
                .toList();
    }

    @Override
    public Product getProduct(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        repository.save(product);

        CreateProductResponse response = new CreateProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        return response;
    }

    @Override
    public UpdateProductResponse updateProduct(Long id, UpdateProductRequest request) {
        rules.checkIfProductExistsById(id);
        Product product = repository.findById(id).orElseThrow();
        Product createdProduct = repository.save(product);

        return mapper.map(createdProduct,UpdateProductResponse.class);
    }

    @Override
    public void deleteProduct(Long id) {
        rules.checkIfProductExistsById(id);
        repository.deleteById(id);
    }
}
