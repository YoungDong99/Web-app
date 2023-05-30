package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {

        System.out.println("~~~~~~~~~~전체 제품 목록~~~~~~~~~~");
        for(ProductDTO productDTO: allProductList){
            System.out.println(productDTO);
        }
        System.out.println("제품 조회에 성공했습니다.");
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        String searchOption = "";
        switch (searchCondition.getOption()){
            case "productName": searchOption = "제품명 검색 결과"; break;
            case "salesStore": searchOption = "판매점 검색 결과"; break;
            case "nonProduct": searchOption = "이달의 신제품 검색 결과"; break;
            case "nonProduction": searchOption = "생산 중단 제품 검색 결과"; break;
        }

        System.out.println("=========" + searchOption + "목록=========");
        for(ProductDTO product: productList){
            System.out.println(product);
        }
        System.out.println("=============================");

    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode){
            case "registProduct": successMessage = "신규 제품을 등록하였습니다.";break;
            case "updateProduct": successMessage = "제품 정보를 수정하였습니다."; break;
            case "deleteProduct" : successMessage = "제품을 삭제하였습니다."; break;
        }
        System.out.println(successMessage);
        System.out.println("====================");

    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode){
            case "selectAllProductList": errorMessage = "조회 결과가 없습니다."; break;
            case "selectProductList": errorMessage = "조건에 만족하는 것이 없습니다."; break;
            case "registProduct": errorMessage = "제품 등록에 실패 하였습니다"; break;
            case "updateProduct": errorMessage = "제품 정보 수정에 실패 하였습니다."; break;
            case "deleteProduct": errorMessage = "제품 삭제에 실패 하였습니다."; break;
        }

        System.out.println(errorMessage);
        System.out.println("====================");

    }

}
