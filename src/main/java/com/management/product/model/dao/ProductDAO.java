package com.management.product.model.dao;

import com.management.product.model.dto.ProductDTO;

import java.util.List;
import java.util.Map;

public interface ProductDAO {
    List<ProductDTO> selectAllProduct();

    int insertProduct(ProductDTO product);

    boolean deleteProduct(Map<String, String> parameter);

    boolean updateProduct(ProductDTO product);
}
