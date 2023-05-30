package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;
import java.util.List;
import java.util.Map;

public class CategoryController {

    private final CategoryPrint categoryPrint;
    private final CategoryService categoryService;

    public CategoryController() {
        categoryPrint = new CategoryPrint();
        categoryService = new CategoryService();
    }

    public void selectCategoryList(Map<String, String> parameter) {


        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if(categoryList != null && categoryList.size()>0){
            categoryPrint.printTeamList(categoryList,parameter);
        }else {
            categoryPrint.printErrorMessage("selectCategoryList");
        }

    }

    public void registNewCategory(CategoryDTO category) {

        if(categoryService.registNewCategory(category)){
            categoryPrint.printSuccessMessage("registCategory");
        }else{
            categoryPrint.printErrorMessage("registCategory");
        }

    }

    public void modifyCategoryName(CategoryDTO category) {


        if(categoryService.modifyCategoryName(category)){
            categoryPrint.printSuccessMessage("modifyCategory");
        }else{
            categoryPrint.printErrorMessage("modifyCategory");
        }

    }

    public void deleteCategory(Map<String, String> parameter) {



        if(categoryService.deleteCategory(parameter)){
            categoryPrint.printSuccessMessage("deleteCategory");
        }else {
            categoryPrint.printErrorMessage("deleteCategory");
        }

    }
}
