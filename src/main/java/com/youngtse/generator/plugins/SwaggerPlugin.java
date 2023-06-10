package com.youngtse.generator.plugins;

import org.mybatis.generator.api.PluginAdapter;

import java.util.List;

/**
 * @author Youngtse
 * @title SwaggerPlugin
 * @date 2023/6/7 16:15
 * @description TODO
 */
public class SwaggerPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return false;
    }
}
