package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;
import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        //    (조건 2) List<CategoryDTO>로 받아온 데이터 목록을 전체 출력하세요.
        if("allList".equals(parameter.get("option"))){
            System.out.println("=============전체 제품분류 정보 조회================");
        }else {
            System.out.println("=============주력 제품분류 순위 조회================");
        }

        for(CategoryDTO category: categoryList){
            System.out.println(category);
        }
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";

        switch (successCode){
            case "registCategory": successMessage = "신규 제품 분류를 등록하였습니다."; break;
            case "modifyCategory": successMessage = "제품 분류 정보 수정에 성공하였습니다"; break;
            case "deleteCategory": successMessage = "제품 분류 정보 삭제에 성공하였습니다."; break;
        }
        System.out.println(successMessage);
        System.out.println("================");
    }

    public void printErrorMessage(String errorCode) {


        String errorMessage = "";

        switch (errorCode){
            case "registCategory": errorMessage = "신규 제품 분류 등록에 실패 하였습니다."; break;
            case "modifyCategory": errorMessage = "제품 정보 수정에 실패 하였습니다."; break;
            case "deleteCategory": errorMessage = "제품 분류 정보 삭제에 실패 하였습니다."; break;
        }
        System.out.println(errorMessage);
        System.out.println("===============");

    }

}
