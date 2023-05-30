package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;
import java.util.Map;
import java.util.List;

public class ProductController {

    private final ProductService productService;
    private final ProductPrint productPrint;

    public ProductController() {
        productService = new ProductService();
        productPrint = new ProductPrint();
    }

    public void selectAllProductList() {

        List<ProductDTO> productList = productService.selectAllProductList();
        if(productList != null && productList.size() >0) {
            productPrint.printAllProductList(productList);
        } else {
            productPrint.printErrorMessage("selectAllProduct");
        }

    }

    public void selectProductByCondition(SearchCondition searchCondition) {
        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);
        if(productList != null && productList.size() > 0){
            productPrint.printProductList(productList,searchCondition);
        }else {
            productPrint.printErrorMessage("selectProductList");
        }
    }

    public void registNewProduct(ProductDTO product) {

        String releaseDate = product.getRelease_date().replaceAll("-", "");
        product.setRelease_date(releaseDate);
        //product.setProduction_status("Y");
        //product.setSales_quantity("0");
        ProductService productService = new ProductService();
        boolean result = productService.registNewProduct(product);

        if (result) {
            System.out.println("제품 등록에 성공했습니다.");
        } else {
            System.out.println("제품 등록에 실패했습니다.");
        }

    }

    public void modifyProductInfo(ProductDTO product) {
        product.setRelease_date(product.getRelease_date().replaceAll("-",""));

        if(productService.modifyProductInfo(product)){
            productPrint.printSuccessMessage("updateProduct");
        }else {
            productPrint.printErrorMessage("updateProduct");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {

        //boolean result = productService.deleteProduct(parameter);

        if(productService.deleteProduct(parameter)){
            productPrint.printSuccessMessage("deleteProduct");
        }else{
            productPrint.printErrorMessage("deleteProduct");
        }

    }
}
