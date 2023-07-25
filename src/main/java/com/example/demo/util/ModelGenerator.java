package com.example.demo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelGenerator {
    public static void main(String[] args) {
        List<String> tableNames = Arrays.asList("User", "Product");
        Map<String, List<String>> columnNames = new HashMap<>();
        columnNames.put("User", Arrays.asList("id", "username", "email"));
        columnNames.put("Product", Arrays.asList("id", "name", "price"));
        Map<String, List<String>> dataTypes = new HashMap<>();
        dataTypes.put("User", Arrays.asList("Long", "String", "String"));
        dataTypes.put("Product", Arrays.asList("Long", "String", "BigDecimal"));

        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setClassForTemplateLoading(ModelGenerator.class, "/");
        try {
            Template template = configuration.getTemplate("ModelTemplate.ftl");

            for (String tableName : tableNames) {
                File file = new File("src/main/java/com/example/demo/models/" + tableName + ".java");
                FileWriter writer = new FileWriter(file);
                Map<String, Object> model = new HashMap<>();
                model.put("TableName", tableName);
                model.put("ColumnNames", columnNames.get(tableName));
                model.put("DataTypes", dataTypes.get(tableName));

                template.process(model, writer);
                writer.close();
            }
            System.out.println("Model generation completed successfully.");
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
