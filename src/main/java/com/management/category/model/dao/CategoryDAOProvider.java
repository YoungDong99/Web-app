package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {

        SQL sql = new SQL();

        if("orderList".equals(parameter.get("option"))){
            sql.SELECT("a.CATEGORY_CODE")
                    .SELECT("a.CATEGORY_NAME")
                    .SELECT("COUNT(b.PRODUCT_CODE) AS PRODUCT_COUNT")
                    .FROM("PRODUCT_CATEGORY a")
                    .LEFT_OUTER_JOIN("PRODUCT_INFO b ON a.CATEGORY_CODE=b.CATEGORY_CODE")
                    .GROUP_BY("a.CATEGORY_CODE","a.CATEGORY_NAME")
                    .ORDER_BY("PRODUCT_COUNT DESC");
        }else {
            sql.SELECT("CATEGORY_CODE")
                    .SELECT("CATEGORY_NAME")
                    .FROM("PRODUCT_CATEGORY");
        }

        return sql.toString();

    }

    public String insertCategory(CategoryDTO category) {

        SQL sql = new SQL();
        sql.INSERT_INTO("PRODUCT_CATEGORY")
                .VALUES("CATEGORY_NAME","#{ categoryName }");
        return sql.toString();

    }

    public String updateCategory(CategoryDTO category) {

        SQL sql = new SQL();
        sql.UPDATE("PRODUCT_CATEGORY")
                .SET("CATEGORY_NAME = #{categoryName}")
                .WHERE("CATEGORY_CODE = #{ categoryCode }");
        return sql.toString();

    }

    public String deleteCategory(Map<String, String> parameter) {

        SQL sql = new SQL();
        sql.DELETE_FROM("PRODUCT_CATEGORY")
                .WHERE("CATEGORY_CODE = #{categoryCode}");
        return sql.toString();
    }
}
