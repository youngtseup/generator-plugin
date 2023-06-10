package com.youngtse.generator.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

/**
 * @author Youngtse
 * @title LombokPlugin
 * @date 2023/6/7 16:14
 * @description TODO
 */
public class LombokPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        /**
         * 设置不生成Getter方法
         */
        return false;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        /**
         * 设置不生成Setter方法
         */
        return false;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addLombokAnnotation(topLevelClass);
        addClassHeader(topLevelClass, introspectedTable);
        return true;
    }

    private void addLombokAnnotation(TopLevelClass topLevelClass) {
        addData(topLevelClass);
        addNoArgsConstructor(topLevelClass);
        addAllArgsConstructor(topLevelClass);
    }

    private void addClassHeader(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

    }

    private void addData(TopLevelClass topLevelClass) {
        topLevelClass.addAnnotation("@Data");
        topLevelClass.addImportedType("lombok.Data");
    }

    private void addNoArgsConstructor(TopLevelClass topLevelClass) {
        topLevelClass.addAnnotation("@NoArgsConstructor");
        topLevelClass.addImportedType("lombok.NoArgsConstructor");
    }

    private void addAllArgsConstructor(TopLevelClass topLevelClass) {
        topLevelClass.addAnnotation("@AllArgsConstructor");
        topLevelClass.addImportedType("lombok.AllArgsConstructor");
    }
}
